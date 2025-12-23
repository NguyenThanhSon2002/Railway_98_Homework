package com.home.frontend;

import java.time.LocalDate;

import com.home.entity.Account;
import com.home.entity.CategoryQuestion;
import com.home.entity.Department;
import com.home.entity.Group;
import com.home.entity.Position;
import com.home.entity.Position_Name;
import com.home.entity.TypeQuestion;
import com.home.entity.TypeQuestion_Name;

public class Exercise1 {
	public static void main(String[] args) {

		// Tạo ra các phòng ban
		// Phòng ban 1
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentName = "Phòng giám đốc";

		// Phòng ban 2
		Department department2 = new Department();
		department2.DepartmentID = 2;
		department2.DepartmentName = "Phòng phó giám đốc";

		// Phòng ban 3
		Department department3 = new Department();
		department3.DepartmentID = 2;
		department3.DepartmentName = "Phòng Sale";

		// Phòng ban 4
		Department department4 = new Department();
		department4.DepartmentID = 4;
		department4.DepartmentName = "Phòng IT";

		// Phòng ban 5
		Department department5 = new Department();
		department5.DepartmentID = 5;
		department5.DepartmentName = "Phòng kế toán";

		/*
		 * System.out.println("toString(): " + department1.toString());
		 * System.out.println("toString(): " + department2.toString());
		 * System.out.println("toString(): " + department3.toString());
		 * System.out.println("toString(): " + department4.toString());
		 * System.out.println("toString(): " + department5.toString());
		 * System.out.println("--------------------");
		 */

		// Tạo ra các vị trí
		// Vị trí số 1
		Position position1 = new Position();
		position1.PositionID = 1;
		position1.PositionName = Position_Name.Dev;

		// Vị trí số 2
		Position position2 = new Position();
		position2.PositionID = 2;
		position2.PositionName = Position_Name.Test;

		// Vị trí số 3
		Position position3 = new Position();
		position3.PositionID = 3;
		position3.PositionName = Position_Name.Scrum_Master;

		// Vị trí số 4
		Position position4 = new Position();
		position4.PositionID = 4;
		position4.PositionName = Position_Name.PM;

		/*
		 * System.out.println("toString(): " + position1.toString());
		 * System.out.println("toString(): " + position2.toString());
		 * System.out.println("toString(): " + position3.toString());
		 * System.out.println("toString(): " + position4.toString());
		 * System.out.println("--------------------");
		 */

		// Tạo ra các account
		// Thành viên số 1
		Account account1 = new Account();
		account1.AccoutID = 1;
		account1.Email = "nguyenvana@gmail.com";
		account1.UserName = "NguyenVanA01";
		account1.FullName = "Nguyễn Văn A";
		account1.Department = department1;
		account1.Position = position1;
		// account1.createDate = LocalDate.of(2020, 9, 23); - đưa dữ liệu ngày vào
		account1.createDate = LocalDate.now();

		// Thành viên số 2
		Account account2 = new Account();
		account2.AccoutID = 2;
		account2.Email = "trananh@gmail.com";
		account2.UserName = "TranAnh02";
		account2.FullName = "Trần Anh";
		account2.Department = department2;
		account2.Position = position2;
		account2.createDate = LocalDate.now();

		// Thành viên số 3
		Account account3 = new Account();
		account3.AccoutID = 3;
		account3.Email = "leminh@gmail.com";
		account3.UserName = "LeMinh03";
		account3.FullName = "Lê Minh";
		account3.Department = department3;
		account3.Position = position1;
		account3.createDate = LocalDate.now();

		// Thành viên số 4
		Account account4 = new Account();
		account4.AccoutID = 4;
		account4.Email = "phuongnt@gmail.com";
		account4.UserName = "PhuongNT04";
		account4.FullName = "Nguyễn Thị Phương";
		account4.Department = department4;
		account4.Position = position4;
		account4.createDate = LocalDate.now();

		// Thành viên số 5
		Account account5 = new Account();
		account5.AccoutID = 5;
		account5.Email = "nguyenvanc@gmail.com";
		account5.UserName = "NguyenVanC05";
		account5.FullName = "Nguyễn Văn C";
		account5.Department = department5;
		account5.Position = position3;
		account5.createDate = LocalDate.now();

		/*
		 * System.out.println("toString(): " + account1.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + account2.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + account3.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + account4.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + account5.toString());
		 * System.out.println("--------------------");
		 */

		// Tạo ra các nhóm
		// Nhóm số 1
		Group group1 = new Group();
		group1.GroupID = 1;
		group1.GroupName = "Nhóm công ty";
		group1.CreatorID = account1;
		group1.CreateDate = LocalDate.now();

		// Nhóm số 2
		Group group2 = new Group();
		group2.GroupID = 2;
		group2.GroupName = "Nhóm Sale";
		group2.CreatorID = account2;
		group2.CreateDate = LocalDate.now();

		// Nhóm số 3
		Group group3 = new Group();
		group3.GroupID = 3;
		group3.GroupName = "Nhóm Kỹ thuật";
		group3.CreatorID = account3;
		group3.CreateDate = LocalDate.now();

		// Nhóm số 4
		Group group4 = new Group();
		group4.GroupID = 4;
		group4.GroupName = "Nhóm Quản lý dự án";
		group4.CreatorID = account4;
		group4.CreateDate = LocalDate.now();

		// Nhóm số 5
		Group group5 = new Group();
		group5.GroupID = 5;
		group5.GroupName = "Nhóm chăm sóc khách hàng";
		group5.CreatorID = account4;
		group5.CreateDate = LocalDate.now();

		// khai báo group mà account tham gia
		Group[] groups_Account1 = { group1, group2 };
		account1.groups = groups_Account1;

		// Group[] groups_Account2 = null;
		Group[] groups_Account2 = { group2, group3, group1 };
		account2.groups = groups_Account2;

		Group[] groups_Account3 = { group3, group4 };
		account3.groups = groups_Account3;

		Group[] groups_Account4 = { group4, group5 };
		account4.groups = groups_Account4;

		/*
		 * System.out.println("toString(): " + group1.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + group2.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + group3.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + group4.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + group5.toString());
		 * System.out.println("--------------------");
		 */

		// Kiểu câu hỏi số 1
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeID = 1;
		typeQuestion1.typeName = TypeQuestion_Name.Essay;

		// Kiểu câu hỏi số 2
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeID = 2;
		typeQuestion2.typeName = TypeQuestion_Name.MultipleChoice;

		/*
		 * System.out.println("toString: " + typeQuestion1.toString());
		 * System.out.println("toString: " + typeQuestion2.toString());
		 * System.out.println("--------------------");
		 */

		// Câu hỏi 1
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryID = 1;
		categoryQuestion1.categoryNameString = "Câu hỏi về Java";

		// Câu hỏi 2
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryID = 2;
		categoryQuestion2.categoryNameString = "Câu hỏi về NET";

		// Câu hỏi 3
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryID = 3;
		categoryQuestion3.categoryNameString = "Câu hỏi về SQL";

		// Câu hỏi 4
		CategoryQuestion categoryQuestion4 = new CategoryQuestion();
		categoryQuestion4.categoryID = 4;
		categoryQuestion4.categoryNameString = "Câu hỏi về Postman";

		// Câu hỏi 5
		CategoryQuestion categoryQuestion5 = new CategoryQuestion();
		categoryQuestion5.categoryID = 5;
		categoryQuestion5.categoryNameString = "Câu hỏi về Ruby";

		/*
		 * System.out.println("toString: " + categoryQuestion1.toString());
		 * System.out.println("toString: " + categoryQuestion2.toString());
		 * System.out.println("toString: " + categoryQuestion3.toString());
		 * System.out.println("toString: " + categoryQuestion4.toString());
		 * System.out.println("toString: " + categoryQuestion5.toString());
		 * System.out.println("--------------------");
		 */

		// Exercise 1 (Optional): Flow Control
		// if
		/*
		 * Câu 1: Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department ==
		 * null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" Nếu không thì sẽ in
		 * ra text "Phòng ban của nhân viên này là ..."
		 */
		/*
		 * if (account2.Department == null) {
		 * System.out.println("Answer1: Nhân viên chưa có phòng ban"); } else {
		 * System.out.println("Answer1: Phòng ban của nhân viên này là: " +
		 * account2.Department); } System.out.println("--------------------");
		 */

		/*
		 * Câu 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
		 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
		 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
		 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
		 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
		 * người hóng chuyện, tham gia tất cả các group"
		 */

		/*
		 * if (account2.groups == null) {
		 * System.out.println("Answer2: Nhân viên chưa có group"); } else { int
		 * total_group_account2_join = account2.groups.length; if
		 * (total_group_account2_join == 1 || total_group_account2_join == 2) {
		 * System.out.
		 * println("Answer2: Group của nhân viên này là Java Fresher, C# Fresher"); }
		 * else if (total_group_account2_join == 3) { System.out.
		 * println("Answer2: Nhân viên này là người quan trọng, tham gia nhiều group");
		 * } else if (total_group_account2_join >= 4) { System.out.
		 * println("Answer2: Nhân viên này là người hóng chuyện, tham gia tất cả các group"
		 * ); } } System.out.println("--------------------");
		 */

		// Câu 3: Sử dụng toán tử ternary để làm Question 1
		/*
		 * String department_member = (account2.Department == null) ?
		 * "Answer3: Nhân viên chưa có phòng ban" :
		 * "Answer3: Phòng ban của nhân viên này là: " + account2.Department;
		 * System.out.println(department_member);
		 * System.out.println("--------------------");
		 */
		/*
		 * Câu 4: Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của
		 * account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không
		 * phải thì in ra text "Người này không phải là Developer"
		 * System.out.println("--------------------");
		 */

		/*
		 * String account1_position = (account1.Position == position1) ?
		 * "Answer4: Đây là Developer" : "Answer4: Người này không phải là Developer";
		 * System.out.println(account1_position);
		 * System.out.println("--------------------");
		 */

		// switch-case
		// Câu 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
		// Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
		// Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
		// Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
		// Còn lại in ra "Nhóm có nhiều thành viên"

		/*
		 * Question 6: Sử dụng switch case để làm lại Question 2
		 */

		/*
		 * if (account2.groups == null) {
		 * System.out.println("Answer2: Nhân viên chưa có group"); } else { int
		 * total_group_account2_join = account2.groups.length; switch
		 * (total_group_account2_join) { case 1: System.out.
		 * println("Answer6: Group của nhân viên này là Java Fresher, C# Fresher");
		 * break; case 2: System.out.
		 * println("Answer6: Group của nhân viên này là Java Fresher, C# Fresher");
		 * break; case 3: System.out.
		 * println("Answer6: Nhân viên này là người quan trọng, tham gia nhiều group");
		 * break; case 4: System.out.
		 * println("Answer6: Nhân viên này là người hóng chuyện, tham gia tất cả các group"
		 * ); break; default: System.out.
		 * println("Answer6: Nhân viên này là người hóng chuyện, tham gia tất cả các group"
		 * ); break; } } System.out.println("--------------------");
		 */

		/*
		 * Question 7: Sử dụng switch case để làm lại Question 4
		 */

		/*
		 * int position_account1 = account1.Position.PositionID;
		 * 
		 * switch (position_account1) { case 1:
		 * System.out.println("Answer7: Đây là Developer"); break; default:
		 * System.out.println("Answer7: Người này không phải là Developer"); break; }
		 * System.out.println("--------------------");
		 */

		// for-each
		// Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng
		// ban của họ
		Account[] account_array = { account1, account2, account3, account4, account5 };

		/*
		 * for (Account account_1 : account_array) {
		 * System.out.println("Answer8: AccountID: " + account_1.AccoutID + " Email: " +
		 * account_1.Email + " Name: " + account_1.FullName); }
		 * System.out.println("--------------------");
		 */

		// Question 9: In ra thông tin các phòng ban bao gồm: id và name
		Department[] department_array = { department1, department2, department3, department4, department5 };

		/*
		 * for (Department department_1 : department_array) {
		 * System.out.println("Answer9: DepartmentID: " + department_1.DepartmentID +
		 * " DepartmentName: " + department_1.DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// For
		// Question 10:
		// In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
		// họ theo định dạng như sau:
		// Thông tin account thứ 1 là:
		// Email: NguyenVanA@gmail.com
		// Full name: Nguyễn Văn A
		// Phòng ban: Sale
		// Thông tin account thứ 2 là:
		// Email: NguyenVanB@gmail.com
		// Full name: Nguyễn Văn B
		// Phòng ban: Marketting

		/*
		 * for (int i = 0; i < account_array.length; i++) {
		 * System.out.printf("Answer10: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// Question 11:
		// In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
		// Thông tin department thứ 1 là:
		// Id: 1
		// Name: Sale
		// Thông tin department thứ 2 là:
		// Id: 2
		// Name: Marketing

		/*
		 * for (int i = 0; i < department_array.length; i++) {
		 * System.out.printf("Answer11: DepartmentID: %d \n", (i + 1));
		 * System.out.printf("DepartmentName: %s \n",
		 * department_array[i].DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// Question 12: Chỉ in ra thông tin 2 account đầu tiên theo định dạng như
		// Question 10

		/*
		 * for (int i = 0; i < account_array.length; i++) { if (i >= 2) { break; }
		 * System.out.printf("Answer12: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2

		/*
		 * for (int i = 0; i < account_array.length; i++) { if (i == 1) { continue; }
		 * System.out.printf("Answer13: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// Question 14: In ra thông tin tất cả các account có id < 4

		/*
		 * for (int i = 0; i < account_array.length; i++) { if (i == 3) { break; }
		 * System.out.printf("Answer14: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); }
		 * System.out.println("--------------------");
		 */

		// Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
		/*
		 * for (int i = 0; i <= 20; i = i + 2) {
		 * System.out.println("Answer15: Các số chẵn nhỏ hơn hoặc bảng 20: " + i); }
		 * System.out.println("--------------------");
		 */

		// while
		// Question 16:Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp
		// với lệnh break, continue

		/*
		 * int i = 0; while (i <= account_array.length) { if (i == 5) { break; }
		 * System.out.printf("Answer16.10: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); i++; }
		 * System.out.println("--------------------");
		 */

		/*
		 * int j = 0; while (j <= department_array.length) { if (j == 5) { break; }
		 * System.out.printf("Answer16.11: DepartmentID: %d \n", (j + 1));
		 * System.out.printf("DepartmentName: %s \n",
		 * department_array[j].DepartmentName); j++; }
		 * System.out.println("--------------------");
		 */

		/*
		 * int k = 0; while (k <= account_array.length) { if (k >= 2) { break; }
		 * System.out.printf("Answer16.12: Thông tin account thứ %d là: \n", (k + 1));
		 * System.out.printf("Email: %s \n", account_array[k].Email);
		 * System.out.printf("Full name: %s \n", account_array[k].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[k].Department.DepartmentName); k++; }
		 * System.out.println("--------------------");
		 */

		/*
		 * int h = 0; while (h <= account_array.length) { if (h == 1) { h++; // điều
		 * kiện để tránh lặp vô hạn continue; } if (h == 5) { break; }
		 * System.out.printf("Answer16.13: Thông tin account thứ %d là: \n", (h + 1));
		 * System.out.printf("Email: %s \n", account_array[h].Email);
		 * System.out.printf("Full name: %s \n", account_array[h].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[h].Department.DepartmentName); h++; }
		 * System.out.println("--------------------");
		 */

		/*
		 * int l = 0; while (l <= account_array.length) { if (l == 4) { break; }
		 * System.out.printf("Answer16.14: Thông tin account thứ %d là: \n", (l + 1));
		 * System.out.printf("Email: %s \n", account_array[l].Email);
		 * System.out.printf("Full name: %s \n", account_array[l].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[l].Department.DepartmentName); l++; }
		 * System.out.println("--------------------");
		 */

		/*
		 * int m = 0; while (m <= 20) {
		 * System.out.println("Answer16.15: Các số chẵn nhỏ hơn hoặc bảng 20: " + m); m
		 * += 2; } System.out.println("--------------------");
		 */

		// do-while
		// Question 17:Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết
		// hợp với lệnh break, continue

		/*
		 * int i = 0; do { if (i == 5) { break; }
		 * System.out.printf("Answer17.10: Thông tin account thứ %d là: \n", (i + 1));
		 * System.out.printf("Email: %s \n", account_array[i].Email);
		 * System.out.printf("Full name: %s \n", account_array[i].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[i].Department.DepartmentName); i++; } while (i <=
		 * account_array.length); System.out.println("--------------------");
		 */

		/*
		 * int j = 0; do { if (j == 5) { break; }
		 * System.out.printf("Answer17.11: DepartmentID: %d \n", (j + 1));
		 * System.out.printf("DepartmentName: %s \n",
		 * department_array[j].DepartmentName); j++; } while (j <=
		 * department_array.length); System.out.println("--------------------");
		 */

		/*
		 * int h = 0; do { if (h == 1) { h++; continue; } if (h == 5) { break; }
		 * System.out.printf("Answer17.13: Thông tin account thứ %d là: \n", (h + 1));
		 * System.out.printf("Email: %s \n", account_array[h].Email);
		 * System.out.printf("Full name: %s \n", account_array[h].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[h].Department.DepartmentName); h++; } while (h <=
		 * account_array.length); System.out.println("--------------------");
		 */

		/*
		 * int l = 0; do { if (l == 4) { break; }
		 * System.out.printf("Answer17.14: Thông tin account thứ %d là: \n", (l + 1));
		 * System.out.printf("Email: %s \n", account_array[l].Email);
		 * System.out.printf("Full name: %s \n", account_array[l].FullName);
		 * System.out.printf("Phòng ban: %s \n",
		 * account_array[l].Department.DepartmentName); l++; } while (l <=
		 * account_array.length); System.out.println("--------------------");
		 */

		/*
		 * int m = 0; do {
		 * System.out.println("Answer17.15: Các số chẵn nhỏ hơn hoặc bảng 20: " + m); m
		 * += 2; } while (m <= 20); System.out.println("--------------------");
		 */
	}
}
