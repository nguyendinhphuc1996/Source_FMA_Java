package phuc;

import MyMethods.MyMethods;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class BaiTap1_1
{
	private static Scanner scan;

	public static void main(String[] args)
	{
		menu();
	}

	// ============== METHOD ==============

	static void menu()
	{
		SinhVien sv = new SinhVien();
		String choice;
		do
		{
			System.out.println("*************** MENU ***************");
			System.out.println("* 1. add -> Input                  *");
			System.out.println("* 2. disp -> Display               *");
			System.out.println("* 3. exit -> Exit application      *");
			System.out.println("************************************");
			scan = new Scanner(System.in);
			System.out.print("[+] Nhập lựa chọn của bạn: ");
			choice = scan.nextLine();
			switch (choice)
			{
				case "add":
					sv.nhapThongTin();
					break;
				case "disp":
					System.out.println();
					sv.display();
					break;
				case "exit":
					break;
				default:
					break;
			}
		} while (!choice.equals("exit"));
	}
}

// Class Sinh Viên

class SinhVien
{
	// variables
	Scanner scan;

	// fields
	String mssv;
	String hoTen;
	String noiSinh;
	Date ngaySinh;
	String gioiTinh;
	String sdt;
	String email;
	String maLop;

	// get/set
	public String getMssv()
	{
		return mssv;
	}

	public void setMssv(String mssv)
	{
		this.mssv = mssv;
	}

	public String getHoTen()
	{
		return hoTen;
	}

	public void setHoTen(String hoTen)
	{
		if(hoTen.trim().equals(""))
		{
			System.out.println("[!] Phải nhập tên!");
		}
		else this.hoTen = hoTen;
	}

	public String getNoiSinh()
	{
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh)
	{
		this.noiSinh = noiSinh;
	}

	public Date getNgaySinh()
	{
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh)
	{
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh()
	{
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh)
	{
		this.gioiTinh = gioiTinh;
	}

	public String getSdt()
	{
		return sdt;
	}

	public void setSdt(String sdt)
	{
		this.sdt = sdt;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMaLop()
	{
		return maLop;
	}

	public void setMaLop(String maLop)
	{
		this.maLop = maLop;
	}
	
	// constructor
	public SinhVien()
	{
		this.mssv = null;
		this.hoTen = null;
		this.noiSinh = null;
		this.ngaySinh = null;
		this.gioiTinh = null;
		this.sdt = null;
		this.email = null;
		this.maLop = null;
	}
	public SinhVien(String mssv, String hoTen, String noiSinh, Date ngaySinh, String gioiTinh, String sdt, String email, String maLop)
	{
		setMssv(mssv);
		setHoTen(hoTen);
		setNoiSinh(noiSinh);
		setNgaySinh(ngaySinh);
		setGioiTinh(gioiTinh);
		setSdt(sdt);
		setEmail(email);
		setMaLop(maLop);
	}
	

	// methods
	public void nhapThongTin()
	{
		scan = new Scanner(System.in);
		String $string = "";
		
		Random rd = new Random();
		$string = ""+(rd.nextInt(50)+1);
		setMssv($string);
		System.out.print("- Nhập tên: ");
		$string = scan.nextLine();
		if(!MyMethods.isStringEmpty($string)) {
			setHoTen($string);
		} else {
			System.out.println("[!] Chưa nhập tên!");
		}
		System.out.print("- Nhập nơi sinh: ");
		setNoiSinh(scan.nextLine());
		System.out.print("- Nhập ngày sinh (dd/MM/yyyy): ");
		String $date = scan.nextLine();
		if(MyMethods.checkStringIsDate($date)) {
			setNgaySinh(MyMethods.getDateFromString($date, "dd/MM/yyyy"));
		} else {
			System.out.println("[!] Nhập ngày sinh không hợp lệ!");
		}
		System.out.print("- Nhập giới tính: ");
		$string = scan.nextLine();
		if(!MyMethods.isStringEmpty($string) && !MyMethods.isStringNull($string) && checkMaleFemale($string)) {
			setGioiTinh($string);
		} else {
			System.out.println("[!] Nhập giới tính không hợp lệ!");
		}
		System.out.print("- Nhập số điện thoại: ");
		$string = scan.nextLine();
		if(!MyMethods.isStringEmpty($string) && !MyMethods.isStringNull($string)) {
			setSdt($string);
		} else {
			System.out.println("[!] Chưa nhập số điện thoại!");
		}
		System.out.print("- Nhập email: ");
		setEmail(scan.nextLine());
		System.out.print("- Nhập mã lớp: ");
		setMaLop(scan.nextLine());
	}
	
	public boolean checkMaleFemale(String $string)
	{
		if($string.toLowerCase().equals("nam") || $string.toLowerCase().equals("nữ"))
		{
			return true;
		}else return false;
	}
	
	public void display()
	{
		System.out.printf("%-5s%-15s%-15s%-10s%-15s%-15s%-20s%-15s\n", "MSSV", "Họ tên", "Nơi sinh", "Ngày sinh","Giới tính", "Số ĐT", "Email", "Mã lớp");
		System.out.printf("%-5s%-15s%-15s%-10s%-15s%-15s%-20s%-15s", this.getMssv().toString(), this.getHoTen(), this.getNoiSinh(), MyMethods.getDateFormat(this.getNgaySinh(), "dd/MM/yyyy"), this.getGioiTinh(),this.getSdt(), this.getEmail(),this.getMaLop());
		System.out.println();
	}
}