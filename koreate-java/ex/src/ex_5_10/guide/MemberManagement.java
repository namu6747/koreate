package ex_5_10.guide;

import java.text.SimpleDateFormat;

public class MemberManagement extends AppBase {

	int num;
	String name;
	String id;
	String pw;
	long reg;
	
	@Override
	protected void isRun() {
		while (isRun) {
			System.out.println("=============================================================");
			System.out.println("1.회원가입|2.로그인|3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램종료");
			System.out.println("=============================================================");
			System.out.println("메뉴 선택");
			selectNo = sc.nextInt();
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
			default:
				break;
			}
		}
	}

	@Override
	protected void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
	}

	@Override
	protected void join() {
		System.out.println("회원 가입");
		System.out.println("아이디 입력");
		id = sc.next();
		System.out.println("비밀번호 입력");
		pw = sc.next();
		System.out.println("비밀번호 한번 더 입력");
		
		String pwc;
		pwc = sc.next();
		if(!pw.equals(pwc) || !memberIdCheck(id)) {
			System.err.println("사용할 수 없는 아이디거나 비번 불일치");
		}
		System.out.println("이름 입력");
		name = sc.next();
		memberList.add(new Member(memberList.size(),name,id,pw,System.currentTimeMillis()));
		System.err.println("회원가입 완료");
	}

	@Override
	protected void login() {
		System.out.println("로그인 화면");
		System.out.println("아이디 입력");
		id = sc.next();
		System.out.println("비밀번호 입력");
		pw = sc.next();
		Member member = new Member(id,pw);
		member = findMember(member);
		if(member == null) {
			System.err.println("일치하는 회원 정보가 없다");
			return;
		}
		loginMember = member;
		if(member == master) {
			System.err.println("정상 로그인\n관리자 계정");
			System.out.println(master);
		}
	}

	@Override
	protected void select() {
		if(loginMember == master) {
			System.out.println("회원 정보");
			for(Member m : memberList) {
				System.out.println(m);
			}
			System.out.println("=============================================================");
			return;
		}
		System.out.println("회원 정보");
		System.err.println(loginMember);
		
	}

	@Override
	protected void update() {
		if(loginMember == master) {
			System.err.println("관리자 계정");
			System.out.println("회원 정보 수정");
			System.out.println("관리자 회원정보 수정");
			for(Member m : memberList) {
				System.out.println(m);
			}
			System.out.println("수정할 회원 번호를 입력해 주세요");
			num = sc.nextInt();
			System.out.println("수정할 회원의 이름을 입력");
			name = sc.next();
			memberList.get(num).setmName(name);
			
		}
		System.out.println("회원 정보 수정");
		System.out.println("내 정보 수정");
		System.out.println("비밀번호를 한번 더 입력해 주세요");
		pw = sc.next();
		if(!loginMember.getmPw().equals(pw)) {
			System.out.println("비밀번호 틀림");
			return;
		}
		System.out.println("수정 할 이름을 입력해주세요");
		name = sc.next();
		loginMember.setmName(name);
		System.err.println(loginMember);
	}

	@Override
	protected void delete() {
		System.out.println("회원 탈퇴");
		if(loginMember == master) {
			System.err.println("회원 정보를 삭제할 수 없습니다.");
			return;
		}
		deleteMember();
	}

	@Override
	protected void deleteMember() {
		System.err.println("정말로 삭제하시나요 y/n");
		name = sc.next().toUpperCase();
		if(name.equals("Y")) {
			num = memberList.indexOf(loginMember);
			memberList.remove(num);
			loginMember = null;
			System.out.println("회원 탈퇴 완료");
		}else if(name.equals("N")) {
			System.out.println("취소");
		}
		return;
		
	}

}
