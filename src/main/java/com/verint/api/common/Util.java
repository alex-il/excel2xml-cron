package com.verint.api.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss.SSS");
		String strDate = sdf.format(new Date());
		return strDate;
	}

	/*
	 * Get the extension of a file.
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}
