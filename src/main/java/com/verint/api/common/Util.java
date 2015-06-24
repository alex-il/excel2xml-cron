package com.verint.api.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss.SSS");
		String strDate = sdf.format(new Date());
		return strDate;
	}

}
