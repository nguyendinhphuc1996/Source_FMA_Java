package TOPIC_2;

import java.util.Scanner;

/*
 * 6. Ma trận (Mảng 2 chiều): Cho ma trận số nguyên cấp n x m. Cài đặt các hàm thực hiện các chức năng sau:
 * + Nhập ma trận và in ma trận.
 * + Tìm phần tử chẵn nhỏ nhất.
 * + Tìm dòng có tổng lớn nhất.
 * + Nhập số dòng cần xóa -> Xóa dòng đó
 * + Hoán vị 2 dòng trong ma trận
 */
public class BaiTap_6
{
	static int[][] Matrix;
	
	public static void main(String[] args)
	{
		int n, m;
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("> Nhập ma trận:");
		System.out .print("- Nhập số dòng: ");
		try
		{
			n = nhap.nextInt();
		}
		catch(Exception e)
		{
			System.out .println("Số dòng không hợp lệ!");
			return;
		}
		System.out .print("- Nhập số cột: ");
		try
		{
			m = nhap.nextInt();
		}
		catch(Exception e)
		{
			System.out .print("Số cột không hợp lệ!");
			return;
		}
		
		//-------- Nhập Matrix
		nhapMatrix(n, m);
		
		//-------- Xuất Matrix
		xuatMatrix(Matrix);
		
		//-------- Tìm phần tử chẵn nhỏ nhất.
		int[] soChan_Min = find_SoChan_Min(Matrix);
		if(soChan_Min[0] == 1)
		{
			System.out.println("Số chẵn nhỏ nhất là: "+ soChan_Min[1]);
		}else System.out.println("Không có số chẵn trong Matrix!");
		
		//-------- Tìm dòng có tổng lớn nhất.
		int rowSumMax = findRowSumMax(Matrix);
		System.out.println("Dòng có tổng lớn nhất là: "+rowSumMax);
		
		//-------- Nhập số dòng cần xóa -> Xóa dòng đó
		System.out .print("\n> Nhập số dòng cần xóa: ");
		try
		{
			int rowIndex = nhap.nextInt();
			deleteRow(rowIndex);
			xuatMatrix(Matrix);
		}
		catch(Exception e)
		{
			System.out .println("Nhập không hợp lệ!");
		}
		
		//-------- Hoán vị 2 dòng trong ma trận
		System.out .println("\n> Hoán vị 2 dòng: ");
		System.out .print("- Nhập vị trí dòng 1: ");
		try
		{
			n = nhap.nextInt();
		}
		catch(Exception e)
		{
			System.out .println("Vị trí số dòng không hợp lệ!");
			return;
		}
		System.out .print("- Nhập vị trí dòng 2: ");
		try
		{
			m = nhap.nextInt();
			swapRow(n, m);
			xuatMatrix(Matrix);
		}
		catch(Exception e)
		{
			System.out .print("Vị trí số dòng không hợp lệ!");
			return;
		}
	}

	//============= METHOD ================
	
	static void nhapMatrix(int n, int m)
	{
		BaiTap_6.Matrix = new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				boolean notNumber = false;
				do
				{
					notNumber = false;
					System.out .print("Nhập phần tử Matrix["+i+"]["+j+"] : ");
					Scanner nhap = new Scanner(System.in);
					try
					{
						BaiTap_6.Matrix[i][j] = nhap.nextInt();
					}
					catch(Exception e)
					{
						notNumber = true;
					}
				} while(notNumber == true);
			}
		}
	}
	
	static void xuatMatrix(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	static int[] find_SoChan_Min(int[][] arr)
	{
		int[] result = new int[2];
		int flag = 0; // 1 - True, 0 - Flase
		int minSoChan = -1;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if(arr[i][j]%2==0)
				{
					flag = 1;
					minSoChan = arr[i][j];
					break;
				}
			}
		}
		if(flag == 0)
		{
			result[0] = flag;
			return result;
		}else flag = 1;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if(arr[i][j]%2==0 && arr[i][j] < minSoChan)
				{
					minSoChan = arr[i][j];
				}
			}
		}
		result[0] = flag;
		result[1] = minSoChan;
		return result;
	}
	
	static int sumRow(int[][] arr, int numRow)
	{
		int sum = 0;
		for (int i = 0; i < arr[0].length; i++)
		{
			sum += arr[numRow][i];
		}
		return sum;
	}
	
	static int findRowSumMax(int[][] arr)
	{
		int rowIndex = 0;
		for (int i = 0; i < arr.length-1; i++)
		{
			if(sumRow(arr,rowIndex) < sumRow(arr,i+1))
				rowIndex = i+1;
		}
		return rowIndex;
	}
	
	static void deleteRow(int rowIndex)
	{
		int n = Matrix.length, m = Matrix[0].length;
		int[][] NewMatrix = Matrix;
		
		for (int i = rowIndex; i < n-1; i++)
		{
			for (int j = 0; j < m; j++)
			{
				NewMatrix[i][j] = NewMatrix[i+1][j];
			}
		}
		
		Matrix = new int[n-1][m];
		for (int i = 0; i < Matrix.length; i++)
		{
			for (int j = 0; j < Matrix[0].length; j++)
			{
				Matrix[i][j] = NewMatrix[i][j];
			}
		}
	}
	
	static void swapRow(int rowA,int rowB)
	{
		for (int i = 0; i < Matrix[0].length; i++)
		{
			int Temp = Matrix[rowA][i];
			Matrix[rowA][i] = Matrix[rowB][i];
			Matrix[rowB][i] = Temp;
		}
	}
}
