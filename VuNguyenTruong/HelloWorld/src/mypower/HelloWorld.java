/*
 * trong 1 source code của 1 project để tiện phát triển phần mềm phân cấp, chia tầng
 * thì chương trình đó có thể có nhiều gói chứa mã nguồn java được gọi là 1 package
 */
package mypower;

/* 
 * Tên class chứa hàm main nên được đặt trùng tên với tên class
 * Java có phân biệt chữ thường chữ hoa -> từ đặc điểm này sẽ ra những quy chuẩn đặt tên cho phù hơp
 * Giúp ta biết được đâu là class đâu là hàm, đâu là biến, đâu là hằng,... 
*/
public class HelloWorld {

	/*
	 * Hàm main có kiểu static vì trong mỗi project chỉ có 1 hàm main để chạy
	 * Hàm main phải ở kiểu static sẽ được tạo ra khi mở chương trình chứ không phụ thuộc vào khi ta dùng mới có
	 * Nhờ đó JVM mới tìm được hàm main này và thực thi
	 * Tham số là 1 mảng String truyền theo kiểu command line 
	 *  + [0]-tên chương trình
	 *  + [1]-số lượng tham số
	 *  + [2,...n]- các tham số với số lượng tương ứng với [1]
	 */
	public static void main(String[] args) {
		
		/*
		 * Theo như quy tắt đặt tên ta nhận xét dòng lệnh dưới đây
		 * System : là tên class
		 * out : được truy xuất qua toán tử . và có chữ thường -> nó là hàm
		 * out : có màu xanh in nghiêng -> nó là hàm hằng (final static) : là chuẩn xuất ra console của java
		 * println : cũng là hàm có tham số là 1 chuỗi truyền vào cần xuất ra màn hình
		 */
		System.out.println("Hello World");
	}
}
