package com.starter.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public abstract class PaginationUtil {

	private static final Integer	DEFAULT_PAGE	= 0;
	private static final Integer	DEFAULT_SIZE	= 10;
	private static final String		PAGINATION_URL	= "%s?page=%d&size=%s";
	private static final String		SORT_URL		= "&sort=%s";
	private static final Integer	DEFAULT_WIDTH	= 5;

	public static Pageable pageable(Class<?> clazz, HttpServletRequest request) {
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		String sortParam = request.getParameter("sort");
		// String searchParam = request.getParameter("search");

		Integer page = getPage(pageParam);
		Integer size = getSize(sizeParam);
		Sort sort = getSort(clazz, sortParam);

		return new PageRequest(page, size, sort);
	}

	public static <T> Map<String, Object> pagination(String baseUrl, Pageable pageable, Page<T> list) {
		Map<String, Object> result = new HashMap<>();

		int firstPage = 0;
		int lastPage = list.getTotalPages() - 1;
		int currentPage = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		long total = list.getTotalElements();
		long rowStart = currentPage * pageSize + 1;
		long rowEnd = Math.min((currentPage + 1) * pageSize, total);

		int previous = DEFAULT_PAGE;
		if (!list.isFirst()) {
			previous = list.previousPageable().getPageNumber();
		}

		int next = lastPage;
		if (!list.isLast()) {
			next = list.nextPageable().getPageNumber();
		}

		List<String> items = new ArrayList<>();
		String sort = "";
		Sort pageableSort = pageable.getSort();
		if (pageableSort != null) {
			for (Order order : pageableSort) {
				items.add(order.getProperty().concat(":").concat(order.getDirection().toString().toLowerCase()));
			}
			sort = SORT_URL.concat(String.join("|", items));
		}

		result.put("first", String.format(PAGINATION_URL, baseUrl, firstPage, pageable.getPageSize(), sort));
		result.put("previous", String.format(PAGINATION_URL, baseUrl, previous, pageable.getPageSize(), sort));
		result.put("pages", getPages(firstPage, lastPage, currentPage, pageSize, baseUrl, sort));
		result.put("next", String.format(PAGINATION_URL, baseUrl, next, pageable.getPageSize(), sort));
		result.put("last", String.format(PAGINATION_URL, baseUrl, lastPage, pageable.getPageSize(), sort));
		result.put("current", currentPage);
		result.put("size", pageSize);
		result.put("total", total);
		result.put("rowStart", rowStart);
		result.put("rowEnd", rowEnd);

		return result;
	}

	private static List<Map<String, Object>> getPages(int firstPage, int lastPage, int currentPage, int pageSize, String baseUrl, String sort) {
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
			page.put("url", String.format(PAGINATION_URL, baseUrl, i, pageSize, sort));
			page.put("current", i == currentPage);

			pages.add(page);
		}

		return pages;
	}

	private static Integer getPage(String pageOption) {
		if (pageOption != null && !pageOption.isEmpty()) {
			int page = Integer.parseInt(pageOption);
			if (page >= 0) {
				return page;
			}
		}

		return DEFAULT_PAGE;
	}

	private static Integer getSize(String sizeOption) {
		if (sizeOption != null && !sizeOption.isEmpty()) {
			int size = Integer.parseInt(sizeOption);
			if (size > 0) {
				return size;
			}
		}

		return DEFAULT_SIZE;
	}

	private static Sort getSort(Class<?> clazz, String sortOption) {
		if (sortOption == null) {
			return null;
		}

		List<Order> orders = new ArrayList<>();

		String[] params = sortOption.split("\\|");
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
