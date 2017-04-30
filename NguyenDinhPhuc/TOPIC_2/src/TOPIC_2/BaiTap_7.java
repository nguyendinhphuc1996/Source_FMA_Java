package TOPIC_2;

import java.util.Scanner;

/*
 * 7. Đệ qui: Dùng đệ qui để tính toán các bài toán sau:
 * - Tính S(n) = 1 + 2 + 3 + ... + n - 1 + n 
 * - Tìm Ước chung lớn nhất giữa a,b
 * - Hãy tính tổng các chữ số chẵn của số nguyên dương n
 */

public class BaiTap_7
{
	public static void main(String[] args)
	{
		int n;
		Scanner scan = new Scanner(System.in);
		
		// ---- Tính S(n) = 1 + 2 + 3 + ... + n - 1 + n 
		System.out.print("> Nhập số nguyên dương n: ");
		try
		{
			n = scan.nextInt();
			System.out.print("=> Tổng S(n) = "+SumN(n));
		}
		catch (Exception e) 
		{
			System.out.print("[!] Nhập không hợp lệ!");
		}
		
		// ---- Tìm Ước chung lớn nhất giữa a,b
		int a, b;
		System.out.print("\n\n> Nhập số nguyên a: ");
		try
		{
			a = scan.nextInt();
		} catch (Exception e)
		{
			System.out.print("[!] Nhập không hợp lệ!");
			return;
		}
		System.out.print("> Nhập số nguyên b: ");
		try
		{
			b = scan.nextInt();
		} catch (Exception e)
		{
			System.out.print("[!] Nhập không hợp lệ!");
			return;
		}
		System.out.print("=> UCLN " + a + " & " + b + " là : " + UCLN(Math.abs(a), Math.abs(b)));
	}
	
	// =========== METHOD ===========
	static int SumN(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		return n+SumN(n-1);
	}
	
	static int UCLN(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return UCLN(b, a % b);
	}
}
