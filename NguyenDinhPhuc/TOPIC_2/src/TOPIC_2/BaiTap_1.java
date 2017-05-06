package TOPIC_2;

import java.util.Scanner;

// 1. Nhập vào một xâu. Tạo ra xâu đảo ngược với xâu đã nhập.

public class BaiTap_1
{
	private static Scanner in;
	
	String chuoiDaoNguoc(String chuoi) // Cách 1
	{	
		String strDaoNguoc = new String(); 
		char[] arrChar = chuoi.toCharArray();
		for(int i=arrChar.length-1;i>=0;i--)
		{
			strDaoNguoc += arrChar[i];
		}
		return strDaoNguoc;
	}
	public static void main(String[] args)
	{
		System.out.print("Nhập chuỗi ký tự : ");
		in = new Scanner(System.in);
		String str = in.nextLine();
		
		BaiTap_1 obj = new BaiTap_1();
		String strDaoNguoc = obj.chuoiDaoNguoc(str);
		System.out.println("Kết quả đảo ngược : "+ strDaoNguoc); // Cách viết hàm
		
		str = new StringBuilder(strDaoNguoc).reverse().toString();
		System.out.print("Kết quả đảo ngược : "+ str); // Dùng hàm có sẵn đảo ngược trở lại
	}
}
