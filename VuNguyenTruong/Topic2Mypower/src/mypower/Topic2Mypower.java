package mypower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Topic2Mypower {

	public static void main(String[] args) {
/*		// Bài 1
		String str = "abcxyz";
		str = getStringReverse(str);
		System.out.println(str);
		
		// Bài 2
		if(isNumeric("123"))	System.out.println("Là số");
		else System.out.println("Không là số");
		
		// Bài 3
		String[] arrStr = {"123", "4", "11", "-11", null, "0"};
		printStatusNumeric(arrStr);
		
		//Bài 4
		Date dateFirst = inputDate();
		outputDate(dateFirst);
		Date dateSecond = inputDate();
		outputDate(dateSecond);
		System.out.println("Khoảng cách giữa 2 ngày : " + computeDistanceDay(dateFirst, dateSecond));*/
		
		// Bài 5:
/*		int ar[] = {12, 2, 3, 5, 6, 10};
		MyArray a = new MyArray(ar);
		System.out.println(a.getLength());
		a.removeAt(0);
		System.out.println(a.getLength());
		a.print();
		//a.findMax();
		a.input(2);*/
		
		// Bài 6
/*		MyArray2D a = new MyArray2D(3, 4);
		a.input();
		a.print();
		a.swap(0, 2);
		System.out.println("Sau khi hoán vị dòng 0 và 2");
		a.deleteRow(0);
		a.print();*/
		
		// Bài 7

		System.out.println(computeSumToN(5));
		System.out.println(ucln(100, 25));
		System.out.println(sumEvenNumber(2468123));
		
		
	}
	
	// Bài 1
	public static String getStringReverse(String strSrc) {
		if(strSrc == null || strSrc.isEmpty()) return strSrc;
		StringBuffer stringBuffer = new StringBuffer(strSrc);
		return stringBuffer.reverse().toString();
	}
	
	// Bài 2 : null, --123, 0132, -, 0
	public static boolean isNumeric(String strSrc) {
		if(strSrc == null || strSrc.isEmpty()) return false;
		int length = strSrc.length();
		for(int i = 0; i < length; i++) {
			if(strSrc.charAt(i) == '-' && i == 0) {
				if(length <= 1) return false;
			}
			else if (!Character.isDigit(strSrc.charAt(i))) 
				return false;
		}
		return true;
	}
	
	// Bài 3
	/** check số nguyên tố */
	public static boolean isPrime(double num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	/** Check số chính phương*/
	public static boolean isPerfectSquare(double num) {
		double sqrtDouble = Math.sqrt(num);
		int sqrtInteger = (int) sqrtDouble;
		if(Math.pow(sqrtDouble, 2) == Math.pow(sqrtInteger, 2))
			return true;
		return false;
	}
	
	public static void printStatusNumeric(String[] lstStrNumeric) {
		String status = "";
		for(String str : lstStrNumeric) {
			if(isNumeric(str)) {
				double num = Double.parseDouble(str);
				if(isPrime(num)) 
					status = "Số nguyên tố";
				else if (isPerfectSquare(num)) 
					status = "Số chính phương";
				else 
					status = "Là số";
			}else
				status = "Không phải là số";
			System.out.println(str + " : " + status);
		}
	}
	// Bài 4
	public static Date inputDate() {
		System.out.println("Nhập ngày(dd/MM/yyyy) : ");
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		boolean errorDateFormat = false;
		do {
			try {
				date = sfd.parse(new Scanner(System.in).nextLine());
				System.out.println(date);
				errorDateFormat = false;
			} catch (ParseException e) {
				System.out.println("Định dạng ngày vừa nhập không đúng, vui lòng nhập lại !");
				date = null;
				errorDateFormat = true;
			}
		} while(errorDateFormat);
		return date;
	}
	
	public static void outputDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(
				calendar.get(Calendar.DAY_OF_MONTH) +"/"+
				(calendar.get(Calendar.MONTH) + 1)  +"/"+
				calendar.get(Calendar.YEAR));
	}
	
	public static long computeDistanceDay(Date dateFirst, Date dateSecond) {
		long daysResult = dateFirst.getDate() - dateSecond.getDate();
		return daysResult;
	}
	
	// Bài 7 :đệ quy
	public static int computeSumToN(int n) {
		if(n == 0) return 0;
		else return computeSumToN(n - 1) + n;
	}
	
	public static int ucln(int numA, int numB) {
		if(numA * numB == 0)
			return numA + numB;
		if(numA > numB)
			return ucln(numA % numB, numB);
		else
			return ucln(numA, numB % numA);
	}

	
	public static int sumEvenNumber(int num) {
		if(num == 0) return 0;
		int evenNum = ((num%10) % 2 == 0) ? num % 10 : 0;
		return sumEvenNumber(num / 10) + evenNum;
	}
	
}
