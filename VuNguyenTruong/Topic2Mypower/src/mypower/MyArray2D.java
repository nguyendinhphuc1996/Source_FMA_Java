package mypower;

import java.util.Collections;
import java.util.Scanner;

public class MyArray2D {
	private MyArray[] arr2D;
	
	public MyArray2D(int nRow, int nColumn) {
		arr2D = new MyArray[nRow];
		for(int i = 0; i < nRow; i++) {
			arr2D[i] = new MyArray(nColumn);
		}
	}
	
	public void print() {
		int nRow = arr2D.length;
		for(int i = 0; i < nRow; i++) {
			arr2D[i].print();
			System.out.println();
		}
	}
	
	public void input() {
		int nRow = 0;
		int nColumn = 0;
		System.out.println("Nhập số dòng: ");
		nRow = new Scanner(System.in).nextInt();
		System.out.println("Nhập số cột: ");
		nColumn = new Scanner(System.in).nextInt();
		
		arr2D = new MyArray[nRow];
		for(int i = 0; i < nRow; i++) {
			arr2D[i] = new MyArray(nColumn);
			System.out.println("Nhập dòng " + i + ":");
			arr2D[i].input(nColumn);
		}
	}
	
	public void deleteRow(int indexRow) {
		int oldRowLength = arr2D.length;
		int newRowLength = oldRowLength - 1;
		for(int i = indexRow; i < oldRowLength - 1; i++) {
			arr2D[i] = arr2D[i + 1];
		}
		MyArray[] arrTemp = arr2D;
		arr2D = new MyArray[newRowLength];
		System.arraycopy(arrTemp, 0, arr2D, 0, newRowLength);
	}
	
	public boolean swap(int indexRowFirst, int indexRowSecond) {
		if(indexRowFirst > arr2D.length || indexRowSecond > arr2D.length
				|| indexRowFirst < 0 || indexRowSecond < 0 )
			return false;
		MyArray arrTemp = arr2D[indexRowFirst];
		arr2D[indexRowFirst] = arr2D[indexRowSecond];
		arr2D[indexRowSecond] = arrTemp;
		return true;
	}
	
	public void findEvenNum() {
		int evenNum = -1;
		int evenNumRow = -1;
		for(MyArray i : arr2D) {
			evenNumRow = i.getMinEvenNum();
			if(evenNumRow < evenNum)
				evenNum = evenNumRow; 
		}
		if(evenNum == -1) 
			System.out.println("Không có phần tử chẵn");
		else 
			System.out.println("Phần tử chẵn nhỏ nhất là " + evenNum);
	}
		
	public void findMaxSumOfROw() {
		int nRow = arr2D.length;
		int indexRowSumMax = -1;
		int sumMax = Integer.MIN_VALUE;
		int sumMaxEachRow = 0;
		for(int i = 0; i < nRow; i++) {
			sumMaxEachRow = arr2D[i].computeSum();
			if(sumMax < sumMaxEachRow) {
				sumMax = sumMaxEachRow;
				indexRowSumMax = i;
			}
		}
		if(indexRowSumMax == -1)
			System.out.println("Mảng 2 chiều rỗng");
		else
			System.out.println("Dòng " + indexRowSumMax + "có tổng lớn nhất = " + sumMax);
	}
}


/*5. Mảng (Array): Viết chương trình nhập vào một mảng số nguyên có n phần tử:
+ Xuất giá trị các phần tử của mảng.
+ Tìm phần tử có giá trị lớn nhất, nhỏ nhất.
+ Tìm, đếm và tính tổng các phần tử là số nguyên tố.
+ Sắp xếp mảng tăng dần
+ Tìm phần tử có giá trị x
6. Ma trận (Mảng 2 chiều): Cho ma trận số nguyên cấp n x m. Cài đặt các hàm thực hiện các chức năng sau:
+ Nhập ma trận và in ma trận.
+ Tìm phần tử chẵn nhỏ nhất.
+ Tìm dòng có tổng lớn nhất.
+ Nhập số dòng cần xóa -> Xóa dòng đó
+ Hoán vị 2 dòng trong ma trận
7. Đệ qui: Dùng đệ qui để tính toán các bài toán sau:
- Tính S(n) = 1 + 2 + 3 + ... + n - 1 + n 
- Tìm Ước chung lớn nhất giữa a,b
- Hãy tính tổng các chữ số chẵn của số nguyên dương n*/