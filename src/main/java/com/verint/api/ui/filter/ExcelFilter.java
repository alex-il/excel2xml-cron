package com.verint.api.ui.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.verint.api.common.Util;

public class ExcelFilter extends FileFilter {

	public boolean accept(File f) {

		if (f.isDirectory()) {
			return true;
		}

		String extension = Util.getExtension(f);
		if (extension != null) {
			if (extension.contains("xls")) {
				return true;
			}
		}

		return false;
	}

	// The description of this filter
	public String getDescription() {
		return "Excel";
	}
}
