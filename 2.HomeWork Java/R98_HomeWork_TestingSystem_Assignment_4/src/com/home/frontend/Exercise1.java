package com.home.frontend;

import java.time.LocalDate;

import com.home.entity.Account;
import com.home.entity.Department;
import com.home.entity.Position;

public class Exercise1 {
	public static void main(String[] args) {
		// tạo department
		Department department1 = new Department();
		department1.showDepInfo();
		System.out.println("--------------------");
		Department department2 = new Department("Son");
		department2.showDepInfo();
		System.out.println("--------------------");

		// tạo account
		Account account1 = new Account();
		account1.showAccInfo();
		System.out.println("--------------------");
		Account account2 = new Account(2, "nguyenvana@gmail.com", "NguyenVanA", "Van A", "Nguyen");
		account2.showAccInfo();
		System.out.println("--------------------");
		Position position3 = new Position();
		Account account3 = new Account(3, "nguyenvana@gmail.com", "NguyenVanA", "Van A", "Nguyen", position3);
		account3.showAccInfo();
		System.out.println("--------------------");
		Position position4 = new Position();
		Account account4 = new Account(4, "nguyenvana@gmail.com", "NguyenVanA", "Van A", "Nguyen", position4,
				LocalDate.of(2002, 9, 8));
		account4.showAccInfo();
		System.out.println("--------------------");

	}
}
