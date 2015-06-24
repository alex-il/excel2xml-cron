package com.verint.api.excel.converter.pojo;

import java.util.ArrayList;
import java.util.Hashtable;

public class ExcelWorksheet {

	private String name;
	// private ArrayList<ArrayList<Object>> data = new
	// ArrayList<ArrayList<Object>>();
	private Hashtable<String, ArrayList<String>> data = new Hashtable<String, ArrayList<String>>();
	private int maxCols = 0;

	public void addRow(ArrayList<String> row) {
		final int initialCapacity = row.size();
		ArrayList<String> value = new ArrayList<String>(initialCapacity);
		for (int i = 1; i < initialCapacity; i++) {
			value.add(row.get(i));
		}
		final String key = row.get(0);
		if (key != null && key.length() > 0) {
			data.put(key, value);
		}
		if (maxCols < row.size()) {
			maxCols = row.size();
		}
	}

	public int getMaxRows() {
		return data.size();
	}

	// GET/SET

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hashtable<String, ArrayList<String>> getData() {
		return data;
	}

	public void setData(Hashtable<String, ArrayList<String>> data) {
		this.data = data;
	}

	public int getMaxCols() {
		return maxCols;
	}

	public void setMaxCols(int maxCols) {
		this.maxCols = maxCols;
	}
}
