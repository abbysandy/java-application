package com.starter.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public abstract class SortUtil {

	public static Map<String, String> Sort(Class<?> clazz, Pageable pageable) {
		Map<String, String> sortable = new HashMap<>();

		Sort sort = pageable.getSort();
		if (sort != null) {

			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				Order orderFor = sort.getOrderFor(field.getName());

				sortable.put(field.getName(), "");

				if (orderFor != null) {
					sortable.put(field.getName(), orderFor.getDirection().toString().toLowerCase());
				}
			}
		}

		return sortable;
	}

}
