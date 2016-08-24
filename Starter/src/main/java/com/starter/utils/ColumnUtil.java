package com.starter.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.starter.dao.TableColumnDAO;
import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;

@Service
public class ColumnUtil {

	private HttpServletRequest	request;
	private Map<String, Column>	columns	= new LinkedHashMap<>();

	public ColumnUtil(HttpServletRequest request) {
		this.request = request;
	}

	public void add(String name, String label, boolean sortable, boolean editable, boolean hideable, boolean visible) {
		this.columns.put(name, new Column(name, label, sortable, editable, hideable, visible, this.request));
	}

	public List<Column> getColumns(UserEntity user, TableColumnDAO tableColumnDAO, String section) {
		Iterable<TableColumnEntity> tableColumns = tableColumnDAO.selectByUserAndSection(user, section);

		for (TableColumnEntity tableColumnEntity : tableColumns) {
			if (this.columns.containsKey(tableColumnEntity.getName())) {
				Column column = this.columns.get(tableColumnEntity.getName());
				column.setVisible(tableColumnEntity.isVisible());
			}
		}

		List<Column> data = new ArrayList<>();
		Set<Entry<String, Column>> entrySet = this.columns.entrySet();
		for (Entry<String, Column> entry : entrySet) {
			data.add(entry.getValue());
		}

		return data;
	}

}
