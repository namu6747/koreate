package ex_5_13;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;

public class BookManagement extends AppBase {

	private String title;
	private String author;
	private long regDate;
	private Book book;

	@Override
	public void registerBook() {
		int i = 1;
		int ct = 0;
		System.out.println("1. 도서등록");
		title = getData("등록할 도서의 제목을 입력해 주세요 >");
		author = getData("등록할 도서의 저자를 입력해 주세요 >");
		Outer : while (true) {
			ct = 0;
			for (Book b : bookList) {
				if (i == b.getNum()) {
					i++;
					continue Outer;
				}
				ct++;
			}
			if(ct == bookList.size()) {
				break;
			}
			i++;
		}
		book = new Book(i, title, author, System.currentTimeMillis());
		if (!bookList.contains(book)) {
			System.out.println("등록 완료");
			bookList.add(book);
			return;
		}
		System.out.println("동일 제목의 도서 존재");
	}

	@Override
	public void selectBook() {
		System.out.println("2. 도서목록");
//		System.out.println(bookList);
		bookList.stream().sorted(Comparator.comparing(Book::getNum)).forEach(s -> System.out.print(s));
	}

	@Override
	public void updateBook() {
		System.out.println("3. 도서수정");
		count = getNum("수정하실 책의 관리 번호를 입력해주세요");
		book = findBook(count);
		while (true) {
			System.out.println("=============================");
			System.out.println("1.제목수정 | 2.저자수정 | 3.수정롼료");
			System.out.println("=============================");
			selectNo = getNum("번호를 선택하세요>");
			switch (selectNo) {
			case 1:
				System.out.println("제목 수정");
				title = getData("제목 입력>");
				book.setTitle(title);
				System.out.println("제목 수정 완료");
				break;
			case 2:
				System.out.println("저자 수정");
				author = getData("저자 입력>");
				book.setAuthor(author);
				System.out.println("저자 수정 완료");
				break;
			case 3:
				System.out.println("수정 완료");
				return;
			default:
				break;

			}
		}
	}

	@Override
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		count = getNum("삭제할 도서의 관리번호 입력");
		book = findBook(count);
		if (book != null) {
			bookList.remove(book);
			System.out.println("삭제 완료");
		}
	}

	@Override
	public void saveBook() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

			oos.writeObject(bookList);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
	}

	public static void main(String[] args) {
		new BookManagement();

	}

}
