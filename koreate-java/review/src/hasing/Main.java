package hasing;

/**
 * 
 *	@author		st-lab.tistory.com
 *
 *	@param		Scanner in	각 메소드에서 입력받을 수 있도록
 *							정적타입으로 생
 *				user		user와 데이터 송수신을 위한 정적 객체 
 * 
 *	
 *	
 * 		 	
 * 	해당 파일은 UTF-8 로 인코딩 되어있습니다.
 *	윈도우의 경우 대개 MS949를 쓰기 때문에 한글이 깨질 수 있습니다.
 *	
 *	<setting 방법>
 *	Package explorer -> DB.java 우클릭 -> properties
 *  -> resource -> text file encoding -> UTF-8 로 변경 
 *  
 */
	
import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	static User user = new User();
	public static void main(String[] args) throws Exception {
		
		
		
		while(true) {
			System.out.println("1 : 회원가입 \t 2 : 로그인 \t 3 : 종료 ");
			System.out.print(">>>>>>  ");
			
			String n = in.nextLine();
			
			if(n.equals("1")) {
				make_user();
			}
			else if(n.equals("2")) {
				longin();
			}
			else if(n.equals("3")) {
				break;
			}
			else if(n.equals("st-lab")) {
				System.out.println("관리자 접근");
				user.get_DB();
			}
			else {
				System.out.println("잘못 입력");
			}
			System.out.println();
		}
	}
	
	static void make_user() throws Exception {
		System.out.print("아이디 입력\n>>>>>>  ");
		String id = in.nextLine();
		System.out.print("비밀번호 입력\n>>>>>>  ");
		String pass = in.nextLine();
		user.set_User(id, pass.getBytes());
	}

	static void longin() throws Exception {
		System.out.print("아이디 입력\n>>>>>>  ");
		String id = in.nextLine();
		System.out.print("비밀번호 입력\n>>>>>>  ");
		String pass = in.nextLine();
		
		user.get_User(id, pass.getBytes());
		
	}
	
}
