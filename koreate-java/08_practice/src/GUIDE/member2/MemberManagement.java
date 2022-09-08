package GUIDE.member2;

import java.util.Scanner;

public class MemberManagement {

	// 사용자 입력
	private Scanner sc = new Scanner(System.in);

	// 회원정보 저장
	private Member[] members = new Member[100];

	// 관리자 계정
	private Member master = new Member(100, "master", "root", "root");

	// 로그인한 회원
	private Member loginMember = null;

	// 프로그램 flag (true : 진행 , false : 종료)
	private boolean isRun = true;

	// 메뉴 번호 선택
	private int selectNo;

	int num;
	String name, id, pw, pc;

	// 프로그램 실행용 생성자
	public MemberManagement() {
		members[members.length - 1] = master;
		isRun();
	}

	/*
	 * 기능 관리
	 */

	// 프로그램 실행
	private void isRun() {
		while (isRun) {
			System.out.println("*\n1.가입 2.로그인 3.목록 4.수정 5.탈퇴 6.종료\n*");
			selectNo = getSelectNum("번호 입력");
			sc.nextLine();
			switch (selectNo) {
			case 1:
				join();
				break;
			case 2:
				login();
				break;
			case 3:
				select();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				terminate();
				break;
			default:
				break;
			}
		}
	}

	// 프로그램 종료
	private void terminate() {
		System.out.println("시스템 종료");
		isRun = false;
	}

	// 회원 가입
	private void join() {
		System.out.println("회원가입 >");
		id = getData("아이디 입력");
		pw = getData("비밀번호");
		pc = getData("비밀번호 확인");
		if (pw == (pc) || !memberIdCheck(id)) {
			System.out.println("아이디나 비밀번호 틀림");
			return;
		}
		name = getData("이름");
		for (int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				members[i] = new Member(i + 1, name, id, pw);
				System.out.println("회원가입 완료");
				break;
			}
		}
	}

	// 로그인
	private void login() {
		System.out.println("로그인");
		id = getData("아이디 입력 >");
		pw = getData("비밀번호 입력 >");
		Member temp = new Member(id, pw);
		loginMember = findMember(temp);
		System.out.println(loginMember);
//		call by reference(good)
		if (loginMember == master) {
			System.out.println("관리자 계정");
		}
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출
	private void select() {
		if (loginMember == master) {
			System.out.println("회원목록");
			for (Member m : members) {
				if (m != null) {
					System.out.println(m);
				}
			}
		}
		System.out.println("관리자 화면");
	}

	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	private void update() {
		System.out.println("회원정보수정");
		if (loginMember == null) {
			System.out.println("로그인 하세요");
			return;
		}
		pw = getData("비밀번호를 입력해주세요");
		if (loginMember != master && loginMember.getmPw().equals(pw)) {
			System.out.println("내 정보 수정");
			id = getData("수정할 이름 입력");
			loginMember.setmId(id);
			System.out.println("수정 완료");
			return;
		}
		if (loginMember == master) {
			System.out.println("관리자 수정");
			for (Member m : members) {
				if (m != null) {
					System.out.println(m);
				}
			}
			num = getSelectNum("수정할 회원 번호 입력");
			name = getData("수정하고 싶은 이름 입력");
			Error a = new Error("수정완료");
			a.printStackTrace();
		}
	}

	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	private void delete() {
		if (loginMember == master) {
			System.out.println("관리자 계정 ㅅㄱ");
			return;
		}
		if (loginMember != null) {
			id = getData("삭제 할래요?").toUpperCase();
			if (id.equals("Y")) {
				deleteMember();
				System.out.println("삭제 완료");
			}else {
				System.out.println("거절 했음");
			}
		}
	}

	

	// 사용자 아이디 중복 체크
	private boolean memberIdCheck(String mId) {
		for (Member m : members) {
			if (m != null && m.getmId().equals(mId)) {
				return false;
			}
		}
		return true;
	}

	// 회원 아이디와 비밀번호로 회원 찾기
	private Member findMember(Member m) {
		for (Member member : members) {
			if (member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}

	// 회원 정보 삭제
	private void deleteMember() {
		for (int i = 0; i < members.length; i++) {
			if (members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}

	String getData(String message) {
		System.out.println(message);
		return sc.nextLine();
	}

	int getSelectNum(String message) {
		System.out.println(message);
		return sc.nextInt();
	}

}
