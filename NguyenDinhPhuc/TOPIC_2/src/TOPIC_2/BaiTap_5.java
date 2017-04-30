package TOPIC_2;

import java.util.Scanner;

/*
 * 5. Mảng (Array): Viết chương trình nhập vào một mảng số nguyên có n phần tử:
 * + Xuất giá trị các phần tử của mảng.
 * + Tìm phần tử có giá trị lớn nhất, nhỏ nhất.
 * + Tìm, đếm và tính tổng các phần tử là số nguyên tố.
 * + Sắp xếp mảng tăng dần
 * + Tìm phần tử có giá trị x
 */
public class BaiTap_5
{
	static int[] arrInt;

	public static void main(String[] args)
	{
		int n = 0;
		System.out.print("Nhập n phần tử mảng số nguyên (n>0): ");
		Scanner nhapN = new Scanner(System.in);
		try
		{
			n = nhapN.nextInt();
			if (n == 0 || n < 0)
				return;
		} catch (Exception e)
		{
			System.out.print("Nhập không hợp lệ!");
		}

		// ----- Nhập mảng
		nhapMang(n);

		// ----- Xuất mảng
		System.out.print("Mảng vừa nhập : ");
		xuatMang(arrInt);
		
		// Max, Min
		System.out.println("\n\nMax = "+MaxValue(arrInt) +" & Min = "+MinValue(arrInt));
	}

	// ======= FUNCTION =======
	static void nhapMang(int n)
	{
		arrInt = new int[n];
		for (int i = 0; i < n; i++)
		{
			boolean notNumber = false;
			do
			{
				notNumber = false;
				System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
				Scanner input = new Scanner(System.in);
				try
				{
					arrInt[i] = input.nextInt();
				} catch (Exception e)
				{
					notNumber = true;
				}
			} while (notNumber == true);
		}
		System.out.println();
	}

	static void xuatMang(int[] arr)
	{
		for (int $int : arr)
		{
			System.out.print($int + " ");
		}
	}

	static int MaxValue(int[] arr)
	{
		int max = arr[0];
		for (int i : arr)
		{
			if (max < i)
				max = i;
		}
		return max;
	}

	static int MinValue(int[] arr)
	{
		int min = arr[0];
		for (int i : arr)
		{
			if (min > i)
				min = i;
		}
		return min;
	}
}
