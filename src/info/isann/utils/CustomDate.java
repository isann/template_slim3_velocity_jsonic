package info.isann.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * java.util.Dateクラスを使いやすくするためのクラスです。
 * @author isann
 *
 */
public class CustomDate {

//	private static final String[] youbi = { " ", "日", "月", "火", "水", "木", "金", "土" };
	
	private int year;
	private int month;
	private int day;
	private int week;
	private int hour;
	private int minute;
	private int second;
	private int millisecond;
	private String dateChars;

	public CustomDate(Date date) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("JST"));
		cal.setTime(date);
		year = cal.get(Calendar.YEAR);          // 例: 1997
		month = cal.get(Calendar.MONTH) + 1;     // (0..11) + 1
		day = cal.get(Calendar.DATE);          // 1..31
		week = cal.get(Calendar.DAY_OF_WEEK);   // 1=Sun..7=Sat
		hour = cal.get(Calendar.HOUR_OF_DAY);   // 0..23
		minute = cal.get(Calendar.MINUTE);      // 0..59
		second = cal.get(Calendar.SECOND);      // 0..59
		millisecond = cal.get(Calendar.MILLISECOND);  // 0..999
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("/").append(month).append("/").append(day).append(" ").append(hour).append(":").append(minute)
		.append(":").append(second).append(".").append(millisecond);
//		sb.append(year).append("年").append(month).append("月").append(day).append("日").append(youbi[week]).append("曜日").append(hour).append("時").append(minute)
//		.append("分").append(second).append("秒").append(millisecond).append("ミリ秒");
		dateChars = sb.toString();
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getWeek() {
		return week;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public int getMillisecond() {
		return millisecond;
	}

	public String getDateChars() {
		return dateChars;
	}
	
}
