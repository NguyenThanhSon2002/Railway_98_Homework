package com.home.frontend;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {

		// Exercise 1 (Optional): Datatype Casting
		// Câu 1:
		// Khai báo 2 số lương có kiểu dữ liệu là float.
		// Khởi tạo Lương của Account 1 là 5240.5 $
		// Khởi tạo Lương của Account 2 là 10970.055$
		// Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
		// Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

		float account1 = 5240.5f;
		float account2 = 10970.055f;

		int account1_i = (int) account1;
		int account2_i = (int) account2;

		System.out.printf("Answer1: Lương của Account 1: %d\n", account1_i);
		System.out.printf("Answer1: Lương của Account 2: %d\n", account2_i);
		System.out.println("--------------------");

		// Câu 2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có
		// số 0 ở đầu cho đủ 5 chữ số)

		Random random = new Random();
		int random_number = (int) (Math.random() * 100000); // 0 - 99999
		if (random_number >= 1000 && random_number <= 9999) {
			System.out.println("Answer2: 0" + random_number);
		} else if (random_number >= 100 && random_number <= 999) {
			System.out.println("Answer2: 00" + random_number);
		} else if (random_number >= 10 && random_number <= 99) {
			System.out.println("Answer2: 000" + random_number);
		} else if (random_number >= 0 && random_number <= 9) {
			System.out.println(" Answer2: 0000" + random_number);
		} else {
			System.out.println("Answer2:" + random_number);
		}
		System.out.println("--------------------");

		// Câu 3: Lấy 2 số cuối của số ở Question 2 và in ra.
		// Gợi ý:
		// Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
		// Cách 2: chia lấy dư số đó cho 100

		int random_number1 = random_number % 100;
		System.out.println("Answer3: " + random_number1);

		// Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của
		// chúng

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào số a: ");
		float a = scanner.nextFloat();
		System.out.println("Nhập vào số b: ");
		float b = scanner.nextFloat();
		float c = (a / b);
		System.out.println("Answer4: Thương của a chia b là: " + c);
		System.out.println("--------------------");

	}
}
