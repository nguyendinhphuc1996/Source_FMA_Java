package phuc;

import java.util.Scanner;

public class SwitchCase
{
	private static Scanner scan;

	private enum MENU
	{
		add, disp, exit, Exception
	}
	
	public static void main(String[] args)
	{
		menu();
	}

	static void menu()
	{
		String action = "Exception";
		do
		{
			scan = new Scanner(System.in);
			System.out.print("> Nhập lựa chọn của bạn: ");
			action = scan.nextLine();
			MENU choice = MENU.Exception;
			try{ choice = MENU.valueOf(action); } 
			catch (Exception e){}
			switch (choice)
			{
				case add:
					System.out.println("Add!");
					break;
				case disp:
					System.out.println("Disp!");
					break;
				case exit:
					System.out.println("Exit!");
					break;
				default:
					System.out.println("[!] Không có chức bạn chọn.");
					break;
			}
		} while (!action.equals("exit"));
	}
}
