package com.home.frontend;

public class Program {
	public static void main(String[] args) {
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

		System.out.printf("Lương của Account 1: %d\n", account1_i);
		System.out.printf("Lương của Account 2: %d\n", account2_i);

	}
}
