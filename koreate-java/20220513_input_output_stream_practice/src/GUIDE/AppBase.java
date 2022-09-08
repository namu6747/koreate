package GUIDE;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class AppBase {
	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록
	List<Book> bookList;
	
	// 프로그램 실행 flag
	boolean isRun = true;
	
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	
	// 도서관리 번호
	int count = 0;	

	@SuppressWarnings("unchecked")
	public AppBase(){
		File file = new File("book.dat");
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			}
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bookList = (ArrayList<Book>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			bookList = new ArrayList<>();
		}
		
		if(!bookList.isEmpty()) {
			Collections.sort(bookList);
			count = bookList.get(0).getNum();
			System.out.println(bookList.size()+"개의 책이 등록 되어 있습니다.");
		}
		isRun = true;
		count++;
		run();
	}
	
	public void run() {
		while(isRun) {
			System.out.println("=======================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5.저장 | 6.종료");
			System.out.println("=======================================================");
			selectNo = getNum("번호를 선택하세요>");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					saveBook();
					break;
				case 6 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			}
		}
	}
	
	// 프로그램 종료
	public abstract void terminate();

	// 도서 등록
	public abstract void  registerBook();
	
	// 도서 목록 출력
	public abstract void selectBook();

	// 도서 정보 수정
	public abstract void updateBook() ;
	
	// 도서 목록에서 책 정보 삭제
	public abstract void deleteBook();
	
	// 도서 목록에서 책 정보 삭제
	public abstract void saveBook();
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(Book book : bookList) {
			if(book.getNum() == num) {
				return book;
			}
		}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getNum(String message) {
		System.out.println(message);
		if(!scanSelectnum.hasNextInt()) {
			System.out.println("숫자를 입력해주세요.");
			scanSelectnum.next();
			return 0;
		}
		return scanSelectnum.nextInt();
	}
}
