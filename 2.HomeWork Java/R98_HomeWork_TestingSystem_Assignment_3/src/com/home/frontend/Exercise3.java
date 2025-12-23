package com.home.frontend;

public class Exercise3 {
	public static void main(String[] args) {
		// Exercise 3(Optional): Boxing & Unboxing
		// Câu 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó
		// convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số
		// sau dấu thập phân)

		int salary = 5000;
		float salary_f = salary;
		System.out.printf("Answer1: Lương: %.2f \n", salary_f);
		System.out.println("--------------------");

		// Câu 2: Khai báo 1 String có value = "1234567" Hãy convert String đó ra số int

		String value = "1234567";
		int value_i = Integer.parseInt(value);
		System.out.println("Answer2: " + value_i);
		System.out.println("--------------------");

		// Question 3:
		// Khởi tạo 1 số Integer có value là chữ "1234567"
		// Sau đó convert số trên thành datatype int

		Integer number = 1234567;
		int number_i = number;
		System.out.println("Answer3: " + number_i);
		System.out.println("--------------------");
	}
}
