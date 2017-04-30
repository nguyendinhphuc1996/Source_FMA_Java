package TOPIC_2;

import java.util.Scanner;
import java.util.stream.IntStream;

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
	static int[] arrSNT;

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
		System.out.println("\n\nMax = " + MaxValue(arrInt) + " & Min = " + MinValue(arrInt));
		
		// Tìm, đếm và tính tổng các phần tử là số nguyên tố.
		int[] arrSoNguyenTo = filter_PhanTu_SNT(arrInt);
		
		System.out.print("\nCác phần tử là Số nguyên tố: ");
		xuatPhanTu_SNT(arrSoNguyenTo);
		
		System.out.println("\nSố phần tử là Số nguyên tố: "+arrSoNguyenTo.length);
		System.out.println("Tổng phần tử là Số nguyên tố: "+IntStream.of(arrSoNguyenTo).sum());
		
		// Sắp xếp mảng tăng dần
		arrInt = IntStream.of(arrInt).sorted().toArray();
		System.out.print("\nMảng vừa sắp xếp tăng dần : ");
		xuatMang(arrInt);
		
		// Tìm phần tử có giá trị x
		System.out.print("\nNhập phần tử x cần tìm : ");
		Scanner nhapX = new Scanner(System.in);
		int x;
		try
		{
			x = nhapX.nextInt();
			System.out.print("\nCó phần tử \'"+ x +"\' không? ");
			if(timPhanTuX(arrInt, x))
				System.out.println("CÓ");
			else
				System.out.println("KHÔNG");
		} catch (Exception e)
		{
			System.out.print("Nhập không hợp lệ!");
		}
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

	static void ResizeArray_Int(int $size)
	{
		int newsize = arrSNT.length; // newsize để kiểm tra giới hạn mảng để đưa phần tử cũ vào
		if ($size < arrSNT.length)
			newsize = $size;

		int[] $arrayNew = arrSNT;
		arrSNT = new int[$size]; // thay đổi kích thước
		for (int i = 0; i < newsize; i++)
		{
			arrSNT[i] = $arrayNew[i];
		}
	}

	static int[] filter_PhanTu_SNT(int[] arr)
	{
		arrSNT = new int[0];
		for (int so : arr)
		{
			if (BaiTap_3.laSoNguyenTo(so)==true)
			{
				ResizeArray_Int(arrSNT.length + 1);
				arrSNT[arrSNT.length - 1] = so;
			}
		}
		return arrSNT;
	}

	static void xuatPhanTu_SNT(int[] arr)
	{
		for(int i:arr)
		{
			System.out.print(i + " ");
		}
	}
	
	static boolean timPhanTuX(int[] arr, int x)
	{
		for(int num:arr)
		{
			if(num == x)
				return true;
		}
		return false;
	}
}
