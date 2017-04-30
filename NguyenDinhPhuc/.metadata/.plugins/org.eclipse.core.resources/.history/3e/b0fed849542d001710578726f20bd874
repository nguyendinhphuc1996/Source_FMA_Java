package TOPIC_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * 4. Xử lý date & time : 
 * Nhập một ngày bất kỳ (Kiểm tra có phải ngày hợp lệ, 
 * tức là chuỗi nhập vào phải là đúng DateTime), 
 * rồi so với ngày hiện tại là cách xa nhiêu ngày 
 * (Phải in ra 2 ngày đã nhập theo định dạng dd/MM/yyyy)
 */

public class BaiTap_4
{
	public static void main(String[] args)
	{
		String $date = new String();
		System.out.print("Nhập vào một ngày (dd/MM/yyyy): ");
		Scanner nhapDate = new Scanner(System.in);
		$date = nhapDate.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date $objDate = sdf.parse($date);
			Date now = new Date();
			
			long khoangCach = $objDate.getTime()-now.getTime();
			System.out.println("> Ngày vừa nhập: "+sdf.format($objDate));
			System.out.println("> Ngày hiện tại: "+sdf.format(now));
			System.out.print("=> Khoảng cách giữa 2 ngày: "+ Math.abs(TimeUnit.DAYS.convert(khoangCach, TimeUnit.MILLISECONDS)) );
			
		} catch (Exception e) // Xem thêm : nên dùng Exception hay ParseException
		{
			System.out.print("Nhập không hợp lệ!");
		}
	}
}
