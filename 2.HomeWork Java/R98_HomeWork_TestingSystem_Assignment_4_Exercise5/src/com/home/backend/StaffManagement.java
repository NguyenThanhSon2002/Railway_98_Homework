package com.home.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.home.entity.Employee;
import com.home.entity.Engineer;
import com.home.entity.Gender;
import com.home.entity.Staff;
import com.home.entity.Worker;

public class StaffManagement {
	private Scanner scanner;
	private ArrayList<Staff> staffArrayList;

	public StaffManagement() {
		super();
		scanner = new Scanner(System.in); // sử dụng để khi nào cần dùng chương trình thì mới cần nhập vào dữ liệu
		staffArrayList = new ArrayList<Staff>(); // thay vì phải khai báo từng mảng cho từng nhóm thì chúng ta có thể
													// khai báo mảng cha của class là staff
	}

	// Thêm mới cán bộ
	public void addNewStaff() {
		System.out.println("Thêm mới cán bộ");
		System.out.println("1. Thêm Engineer");
		System.out.println("2. Thêm Worker");
		System.out.println("3. Thêm Employee");

		int choose = scanner.nextInt();

		switch (choose) {
		case 1:
			while (true) {
				// Lấy thông tin của đối tượng Engineer
				System.out.println("1. Thêm Engineer");
				System.out.println("Nhập vào tên của Engineer: ");
				String nameEngineer = scanner.next();
				System.out.println("Nhập vào tuổi của Engineer: ");
				int ageEngineer = scanner.nextInt();
				System.out.println("Nhập vào giới tính của Engineer: 1.MALE, 2.FEMALE, 3.UNKNOWN");
				int genderChoose = scanner.nextInt();
				Gender genderEngineer = null;
				switch (genderChoose) {
				case 1:
					genderEngineer = Gender.MALE;
					break;
				case 2:
					genderEngineer = Gender.FEMALE;
					break;
				case 3:
					genderEngineer = Gender.UNKNOWN;
					break;
				}

				System.out.println("Nhập vào địa chỉ của Engineer: ");
				String addressEngineer = scanner.next();

				System.out.println("Nhập vào chuyên ngành đào tạo của Engineer: ");
				String specializedEngineer = scanner.next();

				// Tạo ra đối tượng Engineer
				// Engineer engineer = new Engineer();
				// engineer.setName(nameEngineer);
				// engineer.setAge(ageEngineer);
				// engineer.setGender(genderEngineer);
				// engineer.setAddress(addressEngineer);
				// engineer.setSpecialized(specializedEngineer);
				Engineer engineer = new Engineer(nameEngineer, ageEngineer, genderEngineer, addressEngineer);
				engineer.setSpecialized(specializedEngineer);

				// Lưu trữ 1 mảng để quản lý
				staffArrayList.add(engineer);
				break;
			}
			break;

		case 2:
			while (true) {
				// nhập thông tin worker
				System.out.println("2. Thêm Worker");
				System.out.println("Nhập vào tên của Worker: ");
				String nameWorker = scanner.next();
				System.out.println("Nhập vào tuổi của Worker: ");
				int ageWorker = scanner.nextInt();
				System.out.println("Nhập vào giới tính của Engineer: 1.MALE, 2.FEMALE, 3.UNKNOWN");
				int genderChoose = scanner.nextInt();
				Gender genderWorker = null;
				switch (genderChoose) {
				case 1:
					genderWorker = Gender.MALE;
					break;
				case 2:
					genderWorker = Gender.FEMALE;
					break;
				case 3:
					genderWorker = Gender.UNKNOWN;
					break;
				}

				System.out.println("Nhập vào địa chỉ của Worker: ");
				String addressWorker = scanner.next();

				System.out.println("Nhập vào cấp bậc của Worker: ");
				int rankWorker = scanner.nextInt();

				// tạo đối tượng worker
				Worker worker = new Worker(nameWorker, ageWorker, genderWorker, addressWorker);
				worker.setRank(rankWorker);

				// Lưu trữ thông tin worker
				staffArrayList.add(worker);

				break;

			}
			break;

		case 3:
			while (true) {
				// nhập thông tin Employee
				System.out.println("3. Thêm Employee");
				System.out.println("Nhập vào tên của Employee: ");
				String nameEmployee = scanner.next();
				System.out.println("Nhập vào tuổi của Employee: ");
				int ageEmployee = scanner.nextInt();
				System.out.println("Nhập vào giới tính của Engineer: 1.MALE, 2.FEMALE, 3.UNKNOWN");
				int genderChoose = scanner.nextInt();
				Gender genderEmployee = null;
				switch (genderChoose) {
				case 1:
					genderEmployee = Gender.MALE;
					break;
				case 2:
					genderEmployee = Gender.FEMALE;
					break;
				case 3:
					genderEmployee = Gender.UNKNOWN;
					break;
				}

				System.out.println("Nhập vào địa chỉ của Employee: ");
				String addresEmployee = scanner.next();

				System.out.println("Nhập vào công việc của Employee: ");
				String tasKWorker = scanner.next();

				// tạo đối tượng employee
				Employee employee = new Employee(nameEmployee, ageEmployee, genderEmployee, addresEmployee);
				employee.setTask(tasKWorker);

				// Lưu trữ thông tin employee
				staffArrayList.add(employee);

				break;

			}
			break;
		case 4:
			break;
		}

	}

	// Tìm kiếm họ tên
	public void findByName() {
		System.out.println("Tìm kiếm theo họ tên");

	}

	// Hiển thị danh sách cán bộ
	public void showListStaff() {
		System.out.println("Hiển thị thông tin và danh sách các cán bộ đang có trên hệ thống");
		for (Staff staff : staffArrayList) {
			System.out.println(staff.toString());
		}

	}

	// Xóa cán bộ theo họ và tên
	public void deleteStaffByName() {
		System.out.println("Nhập vào tên của cán bộ và delete cán bộ đó");

	}

}
