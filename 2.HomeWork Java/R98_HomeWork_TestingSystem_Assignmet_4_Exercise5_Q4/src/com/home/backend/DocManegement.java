package com.home.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.home.entity.Book;
import com.home.entity.Document;
import com.home.entity.Magazine;
import com.home.entity.Newspaper;

public class DocManegement {

	private Scanner scanner;
	private ArrayList<Document> documentArrayList;

	public DocManegement() {
		super();
		scanner = new Scanner(System.in); // sử dụng để khi nào cần dùng chương trình thì mới cần nhập vào dữ liệu
		documentArrayList = new ArrayList<Document>();
	}

	// Thêm mới tài liệu
	public void addNewDocument() {
		System.out.println("Thêm mới tài liệu");
		System.out.println("1. Sách");
		System.out.println("2. Tạp chí");
		System.out.println("3. Báo");

		int choose = scanner.nextInt();

		switch (choose) {
		case 1: {
			while (true) {
				System.out.println("Thêm mới tài liệu: Sách");
				System.out.println("1. Mã sách:");
				int docID_Book = scanner.nextInt();
				System.out.println("2. Tên nhà xuất bản:");
				String creator_Book = scanner.next();
				System.out.println("3. Số bản phát hành:");
				int releaseNumber_Book = scanner.nextInt();

				// thuộc tính riêng
				System.out.println("4. Tên tác giả:");
				String creatorName_Book = scanner.next();
				System.out.println("5. Số trang:");
				int pageNumber_Book = scanner.nextInt();

				Book book = new Book(docID_Book, creator_Book, releaseNumber_Book);
				book.setNameCreator(creatorName_Book);
				book.setPageNumber(pageNumber_Book);

				documentArrayList.add(book);

				break;

			}
			break;
		}

		case 2:
			while (true) {

				System.out.println("Thêm mới tài liệu: Tạp chí");
				System.out.println("1. Mã tạp chí:");
				int docID_Magazine = scanner.nextInt();
				System.out.println("2. Tên nhà xuất bản:");
				String creator_Magazine = scanner.next();
				System.out.println("3. Số bản phát hành:");
				int releaseNumber_Magazine = scanner.nextInt();

				// thuộc tính riêng
				System.out.println("4. Số phát hành:");
				int issueNumber_Magazine = scanner.nextInt();
				System.out.println("5. Tháng phát hành:");
				int createMonth = scanner.nextInt();

				Magazine magazine = new Magazine(docID_Magazine, creator_Magazine, releaseNumber_Magazine);
				magazine.setIssueNumber(issueNumber_Magazine);
				magazine.setcreateMonth(createMonth);

				documentArrayList.add(magazine);

				break;

			}
			break;

		case 3:
			while (true) {

				System.out.println("Thêm mới tài liệu: Báo");
				System.out.println("1. Mã báo:");
				int docID_Newspaper = scanner.nextInt();
				System.out.println("2. Tên nhà xuất bản:");
				String creator_Newspaper = scanner.next();
				System.out.println("3. Số bản phát hành:");
				int releaseNumber_Newspaper = scanner.nextInt();

				// thuộc tính riêng
				System.out.println("4. Ngày phát hành:");
				int creatorDay_Newspaper = scanner.nextInt();

				Newspaper newspaper = new Newspaper(docID_Newspaper, creator_Newspaper, releaseNumber_Newspaper);
				newspaper.setCreateDay(creatorDay_Newspaper);

				documentArrayList.add(newspaper);

				break;

			}
			break;

		default:
			break;
		}

	}

	// Xóa tài liệu theo mã tài liệu
	public void deleteDocument() {

	}

	// Hiện thị thông tin tài liệu
	public void showDocument() {
		System.out.println("Thông tin tài liệu: ");
		for (Document document : documentArrayList) {
			System.out.println(document.toString());
		}

	}

	// Tìm kiếm tài liệu theo loại
	public void findDocument() {

	}

}
