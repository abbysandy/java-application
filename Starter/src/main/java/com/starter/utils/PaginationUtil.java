package com.starter.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public abstract class PaginationUtil {

	private static final Integer	DEFAULT_PAGE	= 0;
	private static final Integer	DEFAULT_SIZE	= 10;
	private static final String		URL				= "%s/page/%d/size/%s/sort/%s";
	private static final Integer	DEFAULT_WIDTH	= 5;

	public static Pageable pageable(Class<?> clazz, Optional<Integer> pageOption, Optional<Integer> sizeOption, Optional<String> sortOption) {
		Integer page = getPage(pageOption);
		Integer size = getSize(sizeOption);
		Sort sort = getSort(clazz, sortOption);

		return new PageRequest(page, size, sort);
	}

	public static <T> Map<String, Object> pagination(String baseUrl, Pageable pageable, Page<T> list) {
		Map<String, Object> result = new HashMap<>();

		int firstPage = 0;
		int lastPage = list.getTotalPages() - 1;

		int previous = DEFAULT_PAGE;
		if (!list.isFirst()) {
			previous = list.previousPageable().getPageNumber();
		}

		int next = lastPage;
		if (!list.isLast()) {
			next = list.nextPageable().getPageNumber();
		}

		result.put("first", String.format(URL, baseUrl, firstPage, pageable.getPageSize(), "firstName:desc|lastName:asc"));
		result.put("previous", String.format(URL, baseUrl, previous, pageable.getPageSize(), "firstName:desc|lastName:asc"));
		result.put("pages", getPages(firstPage, lastPage, baseUrl, pageable, list));
		result.put("next", String.format(URL, baseUrl, next, pageable.getPageSize(), "firstName:desc|lastName:asc"));
		result.put("last", String.format(URL, baseUrl, lastPage, pageable.getPageSize(), "firstName:desc|lastName:asc"));

		return result;
	}

	private static Integer getPage(Optional<Integer> pageOption) {
		if (pageOption.isPresent()) {
			if (pageOption.get() >= 0) {
				return pageOption.get();
			}
		}

		return DEFAULT_PAGE;
	}

	private static List<Map<String, Object>> getPages(int firstPage, int lastPage, String baseUrl, Pageable pageable, Page<?> list) {
		int currentPage = pageable.getPageNumber();

		List<Map<String, Object>> pages = new ArrayList<>();

		int quotient = Math.floorDiv(DEFAULT_WIDTH, 2);
		int start = currentPage - quotient;
		int end = currentPage + quotient;

		start = Math.max(start, firstPage);
		end = Math.min(end, lastPage);

		start = Math.min(start, lastPage - DEFAULT_WIDTH + 1);
		end = Math.max(end, DEFAULT_WIDTH - 1);

		for (int i = start; i <= end; i++) {
			Map<String, Object> page = new HashMap<>();
			page.put("index", i + 1);
			page.put("url", String.format(URL, baseUrl, i, pageable.getPageSize(), "firstName:desc|lastName:asc"));
			page.put("current", i == currentPage);

			pages.add(page);
		}

		return pages;
	}

	private static Integer getSize(Optional<Integer> sizeOption) {
		if (sizeOption.isPresent()) {
			if (sizeOption.get() > 0) {
				return sizeOption.get();
			}
		}

		return DEFAULT_SIZE;
	}

	private static Sort getSort(Class<?> clazz, Optional<String> sortOption) {
		if (!sortOption.isPresent()) {
			return null;
		}

		List<Order> orders = new ArrayList<>();

		String[] params = sortOption.get().split("\\|");
		for (String param : params) {

			if (!Pattern.compile("(?i)\\w+:(desc|asc)").matcher(param).find()) {
				continue;
			}

			String[] parts = param.split(":");

			Direction direction = getDirection(parts[1]);
			String property = getProperty(clazz, parts[0]);

			if (direction != null && property != null) {
				orders.add(new Order(direction, property));
			}
		}

		return new Sort(orders);
	}

	private static String getProperty(Class<?> clazz, String name) {
		Field[] declaredFields = clazz.getDeclaredFields();

		for (Field declaredField : declaredFields) {
			if (declaredField.getName().toLowerCase().equals(name.toLowerCase())) {
				return declaredField.getName();
			}
		}

		return null;
	}

	private static Direction getDirection(String direction) {
		direction = direction.toUpperCase();

		if (direction.equals(Direction.ASC.toString()) || direction.equals(Direction.DESC.toString())) {
			return Direction.fromString(direction);
		}

		return null;
	}

}
