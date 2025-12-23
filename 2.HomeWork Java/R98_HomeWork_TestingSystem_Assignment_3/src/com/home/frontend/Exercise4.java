package com.home.frontend;

import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {

		// Exercise 4: String
		// Question 1: Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các
		// từ có thể cách nhau bằng nhiều khoảng trắng );

		String name = "Nguyen Thanh Son";
		System.out.println("Số lượng các từ trong xâu kí tự: " + name.length());
		System.out.println("--------------------");

		// Question 2:
		// Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		String s1 = "VTI ";
		String s2 = s1.concat(name);
		System.out.println("Nối 2 sâu kí tự name và s1: " + s2);
		System.out.println("--------------------");

		// Question 3:
		// Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
		// viết hoa chữ cái đầu thì viết hoa lên

		Scanner scanner = new Scanner(System.in);
		/*
		 * System.out.println("Nhập vào tên của bạn: "); String name1 =
		 * scanner.nextLine(); if (name1.charAt(0) >= 97 & name1.charAt(0) <= 122) {
		 * String firstCharacter = name1.substring(0, 1).toUpperCase(); String
		 * leftCharacter = name1.substring(1); System.out.println("char at:" +
		 * name1.charAt(1)); name1 = firstCharacter + leftCharacter;
		 * System.out.println(name1); scanner.close(); } else {
		 * System.out.println(name1); } System.out.println("--------------------");
		 */

		// Question 4:
		// Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
		// của người dùng ra
		// VD:
		// Người dùng nhập vào "Nam", hệ thống sẽ in ra
		// "Ký tự thứ 1 là: N"
		// "Ký tự thứ 1 là: A"
		// "Ký tự thứ 1 là: M"
		/*
		 * System.out.println("Nhập vào tên của bạn: "); String name2 =
		 * scanner.nextLine(); for (int i = 0; i <= name2.length() - 1; i++) {
		 * System.out.println(name2.charAt(i)); } System.out.println(name1); }
		 * System.out.println("--------------------");
		 */

		// Question 5:
		// Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
		// dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ

		/*
		 * System.out.println("Nhập vào họ của bạn: "); String lastName =
		 * scanner.nextLine(); System.out.println("Nhập vào tên của bạn: "); String
		 * firstName = scanner.nextLine(); System.out.println("Tên đầy đủ của bạn là: "
		 * + lastName + " " + firstName); System.out.println("--------------------");
		 */

		// Question 6:
		// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
		// sau đó hệ thống sẽ tách ra họ, tên , tên đệm
		// VD:
		// Người dùng nhập vào "Nguyễn Văn Nam"
		// Hệ thống sẽ in ra
		// "Họ là: Nguyễn"
		// "Tên đệm là: Văn"
		// "Tên là: Nam"

		/*
		 * System.out.println("Nhập vào họ của bạn: "); String lastName1 =
		 * scanner.nextLine(); System.out.println("Nhập vào tên đệm của bạn: "); String
		 * tendem = scanner.nextLine(); System.out.println("Nhập vào tên của bạn: ");
		 * String firstName1 = scanner.nextLine(); System.out.println("Họ là: " +
		 * lastName1); System.out.println("Tên đệm là: " + tendem);
		 * System.out.println("Tên là: " + firstName1);
		 * System.out.println("--------------------");
		 */

		// Question 7:
		// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
		// chuẩn hóa họ và tên của họ như sau:
		// a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
		// vào
		// VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
		// chuẩn hóa thành "nguyễn văn nam"
		// b) Viết hoa chữ cái mỗi từ của người dùng
		// VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
		// chuẩn hóa thành "Nguyễn Văn Nam"

		System.out.println("Nhập vào tên của bạn: ");
		String fullName = scanner.nextLine();
		System.out.println("Tên của bạn là: " + fullName.trim());

		String name1 = scanner.nextLine();
		if (name1.charAt(0) >= 97 & name1.charAt(0) <= 122) {
			String firstCharacter = name1.substring(0, 1).toUpperCase();
			String leftCharacter = name1.substring(1);
			System.out.println("char at:" + name1.charAt(1));
			name1 = firstCharacter + leftCharacter;
			System.out.println(name1);
			scanner.close();
		} else {
			System.out.println(name1);
		}
		System.out.println("--------------------");

		// Question 10 (Optional):
		// Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
		// Nếu có xuất ra “OK” ngược lại “KO”.
		// Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.

	}
}
