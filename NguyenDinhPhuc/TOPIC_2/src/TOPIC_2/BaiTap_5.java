package TOPIC_2;

import java.awt.List;
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
		int[] arrSNT = filter_PhanTu_SNT(arrInt);
		
		System.out.println("\nCác phần tử là Số nguyên tố: ");
		xuatPhanTu_SNT(arrSNT);
		
		System.out.println("Số phần tử là Số nguyên tố: "+arrSNT.length);
		System.out.println("Tổng phần tử là Số nguyên tố: "+IntStream.of(arrSNT).sum());
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

	static void ResizeArray_Int(int[] $array, int $size)
	{
		int newsize = $array.length; // newsize để kiểm tra giới hạn mảng để đưa
										// phần từ cũ vào
		if ($size < $array.length)
			newsize = $size;

		int[] $arrayNew = $array;
		$array = new int[$size]; // thay đổi kích thước
		for (int i = 0; i < newsize; i++)
		{
			$array[i] = $arrayNew[i];
		}
	}

	static int[] filter_PhanTu_SNT(int[] arr)
	{
		int[] arrSNT = new int[0];
		for (int so : arr)
		{
			BaiTap_3 obj_BT3 = new BaiTap_3();
			if (obj_BT3.laSoNguyenTo(so))
			{
				ResizeArray_Int(arrSNT, arrSNT.length + 1);
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
}
