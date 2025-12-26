package com.home.frontend;

import java.util.Scanner;

import com.home.backend.DocManegement;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DocManegement docManegement = new DocManegement();

		while (true) {
			System.out.println("================================================");
			System.out.println("======Lựa chọn chức năng muốn sử dụng===========");
			System.out.println("===    1.Thêm mới tài liệu                   ===");
			System.out.println("===    2. Xóa tài liệu theo mã tài liệu      ===");
			System.out.println("===    3. Hiển thị thông tin về tài liệu     ===");
			System.out.println("===    4. Tìm kiếm tài liệu theo loại        ===");
			System.out.println("===    5. Thoát khỏi chương trình            ===");
			System.out.println("================================================");

			int menuChoose = scanner.nextInt();

			switch (menuChoose) {
			case 1:
				docManegement.addNewDocument();
				break;
			case 2:
				docManegement.deleteDocument();
				break;
			case 3:
				docManegement.showDocument();
				break;
			case 4:
				docManegement.findDocument();
				break;
			case 5:
				System.out.println("5. Thoát khỏi chương trình ");
				return;
			default:
				System.out.println("Lựa chọn không đúng, mời bạn nhập lại");
				break;

			}
		}

	}

}
