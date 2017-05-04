package mypower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MyArray {
	private int[] arr  = null;
	
	public MyArray(int capacity) {
		arr = new int[capacity];
	}
	
	public MyArray(int[] arr) {
		this.arr = new int[arr.length];
		System.arraycopy(arr, 0, this.arr, 0, arr.length);
	}
	
	public int getElement(int index) {
		return arr[index];
	}
	
	public int getLength() {
		return arr.length;
	}
	
	public void print() {
		for(int i : arr) {
			System.out.print(i + "\t");
		}
	}
	
	public void removeAt(int index) {
		int oldLength = arr.length;
		int newLength = oldLength - 1;
		for(int i = index; i < oldLength - 1; i++) {
			arr[i] = arr[i + 1];
		}
		int[] arrTemp = arr;
		arr = new int[newLength];
		System.arraycopy(arrTemp, 0, arr, 0, newLength);
	}
	
	public void input(int... paramsLength) {
		int nLength = 0;
		if(paramsLength.length == 0) {
			System.out.println("Nhập số lượng : ");
			nLength = new Scanner(System.in).nextInt();
		}
		else
			nLength = paramsLength[0];
		arr = new int[nLength];
		for(int i = 0; i < nLength; i++) {
			System.out.println("Nhập phần tử "+i+": ");
			arr[i] = new Scanner(System.in).nextInt();
		}
	}
	
	public void findMax(boolean findMax) {
		int lengthOfArray = arr.length;
		if(lengthOfArray <= 0) {
			System.out.println("Không tìm thấy phần tử có giá trị lớn nhất (mảng rỗng)");
			return;
		}
		int indexOfMaxMinValue = 0;
		for(int i = 1; i < lengthOfArray; i++) {
			if((arr[i] > arr[indexOfMaxMinValue] && findMax)
					|| (arr[i] < arr[indexOfMaxMinValue] && !findMax))
				indexOfMaxMinValue = i;
		}
		String strPrint = String.format("a[%d] = %d", indexOfMaxMinValue, arr[indexOfMaxMinValue]);
		String statusTypeFunction = (findMax) ? "lớn" : "nhỏ";
		System.out.println("Phần tử " + statusTypeFunction + " nhất trong mảng là " + strPrint);
	}
	
	public void findPrime() {
		int countPrime = 0;
		int sumPrime = 0;
		HashMap<Integer, Integer> primeAreFound = new HashMap<Integer, Integer>();
		int length = arr.length;
		for(int i = 0; i < length; i++) {
			if(Topic2Mypower.isPrime(arr[i])) {
				primeAreFound.put(arr[i], arr[i]);
				countPrime++;
				sumPrime += arr[i];
			}
		}
		if(primeAreFound.size() < 0) 
			System.out.println("Không tìm thấy phần tử là số nguyên tố");
		else {
			System.out.println("Số lượng các số nguyên tố : " + countPrime);
			System.out.println("Tổng các số nguyên tố: " + sumPrime);
			System.out.print("Các số nguyên tố xuất hiện trong mảng là : ");
			for(int i : primeAreFound.keySet()) {
				System.out.print("\t" + i);
			}
		}
	}
	
	public void findValue(int value) {
		int length = arr.length;
		ArrayList<Integer> indexesAreFound = new ArrayList<Integer>();
		for(int i = 0; i < length; i++) {
			if(value == arr[i])
				indexesAreFound.add(i);
		}
		if(indexesAreFound.size() < 0) 
			System.out.println("Không tìm thấy giá trị cần tìm");
		else {
			System.out.print("Giá trị cần tìm tương ứng với index mảng là : ");
			for(int i : indexesAreFound) {
				System.out.print("\t" + i);
			}
		}
	}
	
	public int computeSum() {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	
	/*
	 * Tìm số chãn nhỏ nhất
	 * @return -1: không có số chẵn - ngược lại trả về số chẵn
	 */
	public int getMinEvenNum() {
		int evenNum = -1;
		for(int i : arr) {
			if(i % 2 == 0 && i < evenNum) evenNum = i;
		}
		return evenNum;
	}
	
	public void sort() {
		Arrays.sort(arr);
	}
}