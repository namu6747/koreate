package GUIDE.book2;

import java.util.Scanner;

public class BookManagement {
	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectnum = new Scanner(System.in);

	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count = 1;

	public BookManagement() {
		run();
	}

	public void run() {
		while (isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요>");
			if (selectNo < 1 || selectNo > 5)
				continue;
			switch (selectNo) {
			case 1:
				registerBook();
				break;
			case 2:
				selectBook();
				break;
			case 3:
				updateBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				terminate();
				break;
			default:
				System.out.println("등록된 메뉴가 아닙니다.");

			}
		}
	}

	// 프로그램 종료
	public void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
	}

	// 도서 등록
	int i, num;
	String title, author;

	public void registerBook() {
		System.out.println("1. 도서등록");
		title = getData("책 제목 입력");
		author = getData("저자 입력");
		for (i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = new Book(i + 1, title, author);
				break;
			}
		}
		System.out.println("등록 완료");
	}

	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for (Book book : books) {
			if (book != null)
				printBookInfo(book);
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		num = getSelectNum("수정할 책의 도서관리번호 입력") - 1;
		if (findBook(num) == null) {
			System.out.println("존재하지 않는 관리 번호");
			return;
		}
		printBookInfo(books[num]);
		boolean isRun2 = true;
		while (isRun2) {
			System.out.println("\n1. 제목수정 | 2. 저자 수정 | 3. 수정완료\n");
			selectNo = getSelectNum("번호 입력");
			switch (selectNo) {
			case 1:
				System.out.println("제목 수정");
				title = getData("제목 입력");
				books[num].setTitle(title);
				System.out.println("제목 수정 완료");
				break;
			case 2:
				System.out.println("저자 수정");
				author = getData("저자 입력");
				books[num].setAuthor(author);
				System.out.println("저자 수정 완료");
				break;
			case 3:
				System.out.println("수정 완료");
				isRun2 = false;
			default:
				break;
			}
		}
	}

	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		num = getSelectNum("삭제할 책의 도서관리번호 입력") - 1;
		if (findBook(num) != null) {
			books[num] = null;
			System.out.println("삭제 완료");
		}
	}

	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}

	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		if (books[num].getNum() == num + 1) {
			return books[num];
		}
		return null;
	}

	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}

	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectnum.nextInt();
	}

	public static void main(String[] args) {
		new BookManagement();
	}

}
