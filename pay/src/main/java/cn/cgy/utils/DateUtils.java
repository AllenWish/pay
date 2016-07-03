package cn.cgy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具
 * @author AllenWish-CGy
 * @since  2016年5月23日 下午9:26:52
 */
public class DateUtils {
	
	/**
	 * 14位年月日时分秒
	 * YYYYMMDDHHMMSS
	 */
	public static final String date_14 ="YYYYMMddHHmmss";
	/**
	 * 18位年月日时分秒
	 * YYYY-MM-DD HH-MM-SS
	 */
	public static final String date_18_1 ="YYYY-MM-dd HH-mm-ss";
	/**
	 * 18位年月日时分秒
	 * YYYY-MM-DD HH:MM:SS
	 */
	public static final String date_18_2 ="YYYY-MM-dd HH:mm:ss";
	
	
	/**
	 * 获取当前时间14位
	 * 格式：YYYYMMDDHHMMSS
	 * @return 当前时间
	 */
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
//		String dd = sdf.format(date);
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间
	 * 格式：dateFormat
	 * @param dateFormat
	 * @return 当前时间
	 */
	public static String getCurrentTime(String dateFormat){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
}
