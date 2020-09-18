package com.boot.pattern.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DayTimeUtil {
	/*
	 * 현재 날짜시간 얻어오기
	 * format : yyyy-MM-dd HH:mm:ss
	 **/
	public static String getCurDateTime(String format) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
	}
	
	public static long getMilli(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}
	
	public static void main(String args[]) {
		System.out.println(getCurDateTime("yyyy-MM-dd HH:mm:ss.SSS"));
	}
}