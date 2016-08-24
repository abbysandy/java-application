package com.starter.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort.Direction;

public class Column {

	private String	name;
	private String	label;
	private boolean	sortable;
	private boolean	editable;
	private boolean	hideable;
	private boolean	visible;
	private String	direction	= "";
	private String	url			= "";

	public Column(String name, String label, boolean sortable, boolean editable, boolean hideable, boolean visible, HttpServletRequest request) {
		this.name = name;
		this.label = label;
		this.sortable = sortable;
		this.editable = editable;
		this.hideable = hideable;
		this.visible = visible;

		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String sort = request.getParameter("sort");

		List<String> params = new ArrayList<>();
		if (page != null) {
			params.add(String.format("page=%s", page));
		}
		if (size != null) {
			params.add(String.format("size=%s", size));
		}

		List<String> sorting = new ArrayList<>();
		boolean found = false;

		if (sort != null) {

			String[] pairs = sort.split("\\|");

			for (String pair : pairs) {
				String[] parts = pair.split(":");

				if (parts.length != 2) {
					break;
				}

				String property = parts[0].toLowerCase();
				String direction = parts[1].toUpperCase();

				if (property.equals(name.toLowerCase())) {
					this.direction = Direction.DESC.toString().toLowerCase();

					if (direction.equals(Direction.ASC.toString())) {
						this.direction = Direction.ASC.toString().toLowerCase();
						sorting.add(String.format("%s:%s", name, Direction.DESC.toString().toLowerCase()));
					}

					found = true;
				} else {
					sorting.add(pair);
				}

			}

		}

		if (!found) {
			sorting.add(String.format("%s:%s", name, Direction.ASC.toString().toLowerCase()));
		}

		if (!sorting.isEmpty()) {
			params.add(String.format("sort=%s", String.join("|", sorting)));
		}

		this.url = String.join("&", params);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isSortable() {
		return this.sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isHideable() {
		return this.hideable;
	}

	public void setHideable(boolean hideable) {
		this.hideable = hideable;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
