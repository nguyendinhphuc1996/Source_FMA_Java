package phuc;

public class BaiTap1
{
	public static void main(String[] args)
	{
		System.out.println("========== Ví dụ 1 ===========");
		Customer c = new Customer();
		c.customerID = 4496;
		c.customerName = "Phuc";
		c.customerAddress = "HCM City";
		c.customerAge = 21;
		c.displayCustomerInformation();
		
		c.changeCustomerAddress("HoChiMinh City");
		c.displayCustomerInformation();
	}
}

class Customer
{
	// Fields / Properties
	int customerID;
	String customerName;
	String customerAddress;
	int customerAge;
	
	// Method
	void changeCustomerAddress(String Address)
	{
		customerAddress = Address;
	}
	
	void displayCustomerInformation()
	{
		System.out.println("ID: "+ customerID);
		System.out.println("Name: "+ customerName);
		System.out.println("Address: "+ customerAddress);
		System.out.println("Age: "+ customerAge);
	}
}
