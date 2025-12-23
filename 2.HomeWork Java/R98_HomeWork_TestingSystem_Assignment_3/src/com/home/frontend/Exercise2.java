package com.home.frontend;

import java.time.LocalDate;

public class Exercise2 {
	public static void main(String[] args) {
		// Exercise 2 (Optional): Default value
		// Question 1:
		// Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
		// tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
		//  Email: "Email 1"
		//  Username: "User name 1"
		//  FullName: "Full name 1"
		//  CreateDate: now

		for (int i = 1; i <= 5; i++) {
			System.out.println("Account: Account " + i);
			System.out.println("Emai: Email " + i);
			System.out.println("Username: Username " + i);
			System.out.println("FullName: FullName " + i);
			System.out.println("CreateDate: " + LocalDate.now());
			System.out.println("--------------------");

		}

	}
}
