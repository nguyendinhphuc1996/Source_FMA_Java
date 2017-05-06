package TOPIC_2;

import java.util.Scanner;

// 3. Nhập một dãy số. Xuất ra 2 loại từ dãy số đó (Số nguyên tố, số chính phương -> Sử dụng hàm)

public class BaiTap_3
{
	private static Scanner nhapSo;

	static boolean laSoNguyenTo(int so)
	{	
		if (so < 2)
			return false;
		for (int i = 2; i <= Math.sqrt((double) so); i++)
		{
			if (so % i == 0)
				return false;
		}
		return true;
	}

	static boolean laSoChinhPhuong(int so)
	{
		return Math.sqrt((double) so) % 1 == 0;
	}

	public static void main(String[] args)
	{
		String so = new String();
		System.out.print("Nhập vào một dãy số nguyên (cách nhau bằng dấu \',\') : ");
		nhapSo = new Scanner(System.in);
		so = nhapSo.nextLine();
		try
		{
			String daySoNguyenTo = "", daySoChinhPhuong = "";
			so = so.trim();
			String[] arrSo = so.split(",");
			for (String c : arrSo)
			{
				if (laSoNguyenTo(Integer.parseInt(c)))
					daySoNguyenTo += c + " ";
				if (laSoChinhPhuong(Integer.parseInt(c)))
					daySoChinhPhuong += c + " ";
			}
			System.out.println("> Các số nguyên tố: " + daySoNguyenTo);
			System.out.println("> Các số chính phương: " + daySoChinhPhuong);
		} catch (Exception e)
		{
			System.out.print("Nhập không hợp lệ!");
		}
	}
}
