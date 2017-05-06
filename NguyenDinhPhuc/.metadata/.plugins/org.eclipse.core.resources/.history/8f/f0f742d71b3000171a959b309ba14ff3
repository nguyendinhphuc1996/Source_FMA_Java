package TOPIC_2;

import java.util.Scanner;

// 2. Nhập một chuỗi -> Kiểm tra xem đó là số hay chữ.
// tìm hiểu thêm về cách dùng Regex trong bài toán

public class BaiTap_2
{
	static boolean laChuoiSo(String s)
	{
		for (char c : s.toCharArray()) // là foreach
		{
			if (!Character.isDigit(c))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		String str = new String();
		do
		{
			Scanner nhap = new Scanner(System.in);
			System.out.print("Nhập vào một chuỗi: ");
			str = nhap.nextLine();

			System.out.println("-> Chuỗi có phải là dãy số hay không? " + ((laChuoiSo(str)) ? "CÓ" : "KHÔNG"));
		} while (!str.equals("exit"));
	}
}
