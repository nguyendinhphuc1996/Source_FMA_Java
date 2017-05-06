package phuc;

import java.util.Scanner;

public class Demo
{
	public static void main(String[] args)
	{
		System.out.println("----------- Ví dụ 1 về Scanner -----------");
		String s = "Hello World!";
		Scanner scanner = new Scanner(s);
		System.out.println("=>..." + scanner.next());
		System.out.println("=>..." + scanner.next());
		
		scanner.close();

		System.out.println("----------- Ví dụ 2 về Scanner -----------");
		scanner = new Scanner(System.in);	
		System.out.print("Nhập x: ");
		String x = scanner.next();
		System.out.println("=>..." + x);
		
		scanner.close();
		
		System.out.println("----------- Ví dụ 3 về Scanner -----------");
		scanner = new Scanner(System.in);
		System.out.print("Nhập số y: ");
		int y = scanner.nextInt();
		System.out.println("=>..." + y);

		String z = scanner.nextLine();
		System.out.println("=>..." + z);

		scanner.close();
	}
}
