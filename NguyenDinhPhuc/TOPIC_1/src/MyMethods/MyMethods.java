package MyMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMethods
{
	// Kiểm tra chuỗi phải là Date
	public static boolean checkStringIsDate(String $string) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date $date = sdf.parse($string);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}
	
	// Chuyển đổi chuối sang Date
	public static Date getDateFromString(String $string, String $format) 
	{
		Date $date = null;
		SimpleDateFormat sdf = new SimpleDateFormat($format);
		try
		{
			$date = sdf.parse($string);
		} catch (Exception e)
		{
		}
		return $date;
	}
	
	// Xuất Date theo định dạng
	public static String getDateFormat(Date $date, String $format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat($format);
		try
		{
			return sdf.format($date);
		}catch(Exception e)
		{
			return "Error(Date)!";
		}
	}

	// Kiểm tra chuỗi có phải là chuỗi Empty (trống)
	public static boolean isStringEmpty(String $string)
	{
		if ($string.equals(""))
			return true;
		return false;
	}
	
	// Kiểm tra chuỗi có phải là chuỗi Null
	public static boolean isStringNull(String $string)
	{
		if ($string.equals(null))
			return true;
		return false;
	}
}
