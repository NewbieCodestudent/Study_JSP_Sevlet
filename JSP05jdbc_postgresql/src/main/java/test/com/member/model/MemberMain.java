package test.com.member.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello Member");
		
		MemberDAO dao = new MemberDAOimpl();
		Reader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		boolean bool = true;
		String menu = "y";
		
		do {
			System.out.println("===========================");
			System.out.println("1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색");
			System.out.println("종료시 x입력[계속하려면 아무키]:");
			System.out.println("===========================");
			System.out.println("메뉴를 선택하세요:");
			menu = br.readLine();
			
			if (menu.equals("1")) {
				System.out.println("=================================");
				System.out.println("1.회원입력");
				System.out.println("=================================");
				System.out.println("회원 ID : ");
				String id = br.readLine();
				System.out.println("회원 PW : ");
				String pw = br.readLine();
				System.out.println("회원이름 : ");
				String name = br.readLine();
				System.out.println("전화번호 : ");
				String tel = br.readLine();
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setTel(tel);
				int result = dao.insert(vo);
				System.out.println("result : " + result);
				if (result == 1)
					System.out.println("입력성공");
				else
					System.out.println("입력실패");
			} else if (menu.equals("2")) {
				System.out.println("=================================");
				System.out.println("2.회원정보수정");
				System.out.println("=================================");
				System.out.println("회원번호 : ");
				String num = br.readLine();
				int num2 = Integer.parseInt(num);
				System.out.println("회원 ID : ");
				String id = br.readLine();
				System.out.println("회원 PW : ");
				String pw = br.readLine();
				System.out.println("회원이름 : ");
				String name = br.readLine();
				System.out.println("전화번호 : ");
				String tel = br.readLine();
				MemberVO vo = new MemberVO();
				vo.setNum(num2);
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setTel(tel);
				int result = dao.update(vo);
				System.out.println("result : " + result);
				if(result ==1) {
					System.out.println("수정성공");
				} else {
					System.out.println("수정실패");
				}
			} else if (menu.equals("3")) {
				System.out.println("=================================");
				System.out.println("3.회원정보삭제");
				System.out.println("=================================");
				System.out.println("회원번호 : ");
				String num = br.readLine();
				int num2 = Integer.parseInt(num);
				MemberVO vo = new MemberVO();
				vo.setNum(num2);
				int result = dao.delete(vo);
				System.out.println("result : " + result);
				if(result ==1) {
					System.out.println("삭제성공");
				} else {
					System.out.println("삭제실패");
				}
			} else if (menu.equals("4")) {
				System.out.println("=================================");
				System.out.println("4.회원정보검색");
				System.out.println("=================================");
				System.out.println("회원번호 : ");
				String num = br.readLine();
				int num2 = Integer.parseInt(num);
				MemberVO vo = new MemberVO();
				if (vo.getNum() == 0) {
					System.out.println("해당번호글 없음.");
				} else {
					System.out.println(vo.getNum() + "|");
					System.out.println(vo.getId() + "|");
					System.out.println(vo.getPw() + "|");
					System.out.println(vo.getName() + "|");
					System.out.println(vo.getTel() + "|");
				}
			} else if(menu.equals("5")) {
				System.out.println("=================================");
				System.out.println("5.전체회원정보");
				System.out.println("-----------------------------------");
				System.out.println("회원번호 | ID | PW | 이름 | 전화번호");
				System.out.println("-----------------------------------");
				List<MemberVO> vos = dao.selectAll();
				for (MemberVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getId() + " | ");
					System.out.print(x.getPw() + " | ");
					System.out.print(x.getName() + " | ");
					System.out.println(x.getTel() + " | ");
				}
			} else if(menu.equals("6")) {
				System.out.println("=================================");
				System.out.println("6.검색어 검색");
				System.out.println("=================================");
				System.out.println("검색키를 입력하세요.");
				String searchKey = br.readLine();
				System.out.println("검색어를 입력하세요.");
				String searchWord = br.readLine();
				System.out.println("-----------------------------------");
				System.out.println("회원번호 | ID | PW | 이름 | 전화번호");
				System.out.println("-----------------------------------");
				List<MemberVO> vos = dao.searchList(searchKey, searchWord);
				for (MemberVO x : vos) {
					System.out.print(x.getNum() + " | ");
					System.out.print(x.getId() + " | ");
					System.out.print(x.getPw() + " | ");
					System.out.print(x.getName() + " | ");
					System.out.println(x.getTel() + " | ");
					}
			}
			if (menu.equals("x")) break;
		} while (bool);
		
		System.out.println("종료");
	}

}// end class