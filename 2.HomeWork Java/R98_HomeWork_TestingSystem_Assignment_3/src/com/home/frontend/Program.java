package com.home.frontend;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// Exercise 1 (Optional): Datatype Casting
		// Câu 1:
		// Khai báo 2 số lương có kiểu dữ liệu là float.
		// Khởi tạo Lương của Account 1 là 5240.5 $
		// Khởi tạo Lương của Account 2 là 10970.055$
		// Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
		// Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

		/*
		 * float account1 = 5240.5f; float account2 = 10970.055f;
		 * 
		 * int account1_i = (int) account1; int account2_i = (int) account2;
		 * 
		 * System.out.printf("Lương của Account 1: %d\n", account1_i);
		 * System.out.printf("Lương của Account 2: %d\n", account2_i);
		 * System.out.println("--------------------");
		 */

		// Câu 2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có
		// số 0 ở đầu cho đủ 5 chữ số)

		/*
		 * Random random = new Random(); // int random_number = random.nextInt(99999);
		 * int random_number = 199; if (random_number >= 1000 && random_number <= 9999)
		 * { System.out.println("0" + random_number); } else if (random_number >= 100 &&
		 * random_number <= 999) { System.out.println("00" + random_number); } else if
		 * (random_number >= 10 && random_number <= 99) { System.out.println("000" +
		 * random_number); } else if (random_number >= 0 && random_number <= 9) {
		 * System.out.println("0000" + random_number); } else {
		 * System.out.println(random_number); }
		 * System.out.println("--------------------");
		 */

		// Câu 3: Lấy 2 số cuối của số ở Question 2 và in ra.
		// Gợi ý:
		// Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
		// Cách 2: chia lấy dư số đó cho 100

		/*
		 * int random_number1 = random_number % 100; System.out.println(random_number1);
		 */

		// Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của
		// chúng

		Scanner scanner = new Scanner(System.in);
		/*
		 * System.out.println("Nhập vào số a: "); float a = scanner.nextFloat();
		 * System.out.println("Nhập vào số b: "); float b = scanner.nextFloat(); float c
		 * = (a / b); System.out.println("Thương của a chia b là: " + c);
		 * System.out.println("--------------------");
		 */

		// Exercise 2 (Optional): Default value
		// Question 1:
		// Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
		// tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
		//  Email: "Email 1"
		//  Username: "User name 1"
		//  FullName: "Full name 1"
		//  CreateDate: now

		/*
		 * for (int i = 1; i <= 5; i++) { System.out.println("Account: Account " + i);
		 * System.out.println("Emai: Email " + i);
		 * System.out.println("Username: Username " + i);
		 * System.out.println("FullName: FullName " + i);
		 * System.out.println("CreateDate: " + LocalDate.now());
		 * System.out.println("--------------------");
		 * 
		 * }
		 */

		// Exercise 3(Optional): Boxing & Unboxing
		// Câu 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó
		// convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số
		// sau dấu thập phân)

		/*
		 * int salary = 5000; float salary_f = salary;
		 * System.out.printf("Lương: %.2f \n", salary_f);
		 * System.out.println("--------------------");
		 */

		// Câu 2: Khai báo 1 String có value = "1234567" Hãy convert String đó ra số int
		String value = "1234567";

		// Exercise 4: String
		// Question 1: Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các
		// từ có thể cách nhau bằng nhiều khoảng trắng );

	}
}
