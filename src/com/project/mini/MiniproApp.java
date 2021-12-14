package com.project.mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniproApp {

	public static void main(String[] args) throws IOException {
		// ArrayList로 관리합니다
		String name;
		String ph;
		String company;

		// 시작화면
		System.out.println("##################################");
		System.out.println("#        전화번호 관리 프로그램        #");
		System.out.println("##################################");

		// Scanner,List 생성
		Scanner sc = new Scanner(System.in);
		List<Mini> mList = new ArrayList<Mini>();

		// 파일 읽어올 준비(모든 파일용)
		InputStream is = new FileInputStream("C:\\javaStudy\\workspace\\미니프로젝트\\phoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 파일 읽어오기
		while (true) {

			// 정보 읽어오기
			String pline = br.readLine();
			if (pline == null) {
				break;
			}
			// 나눠서 배열에 넣기
			String[] dataArray = pline.split(",");
			name = dataArray[0];
			ph = dataArray[1];
			company = dataArray[2];

			// 리스트에 추가
			Mini mini = new Mini(name, ph, company);
			mList.add(mini);

		}
		boolean action = true;
		while (action) {
			System.out.println();
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------");
			System.out.print(">메뉴번호:");
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1: // 리스트 출력 (화면 출력)
				System.out.println("<1.리스트>");
				for (int i = 0; i < mList.size(); i++) {
					System.out.print((i + 1) + ". ");
					mList.get(i).showinfo();
				}
				break;

			case 2: //리스트 추가 등록
				System.out.println("<2.등록>");
				
				System.out.print(">이름: ");
				String nameAdd = sc.next();
				System.out.print(">휴대전화: ");
				String phAdd = sc.next();
				System.out.print(">회사전화: ");
				String companyAdd = sc.next();

				name = nameAdd;
				ph = phAdd;
				company = companyAdd;

				Mini miniAdd = new Mini(name, ph, company);
				mList.add(miniAdd);
				System.out.println("[등록되었습니다.]");
				break;

			case 3: //선택 제거
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int removeInput = sc.nextInt();
				sc.nextLine();

				mList.remove(mList.get(removeInput - 1));
				System.out.println("[삭제되었습니다.]");
				break;

			case 4: // 포함된 이름 검색
				System.out.print(">이름검색:");
				String search = sc.next();
				
				for (int i = 0; i < mList.size(); i++) {

					int findName = mList.get(i).getName().indexOf(search);

					if (findName >= 0) {
						System.out.print(i + 1 + ". ");
						mList.get(i).showinfo();
					}

				}
				break;

			case 5: //종료 (탈출)
				action=false;
				System.out.println("[종료되었습니다]");
				break;
				
			default://그 외 메뉴 작성시
				System.out.println("!다시 입력해 주세요!");
				break;
				
			}// ---------switch문 종료-------------------

			OutputStream ow = new FileOutputStream("C:\\javaStudy\\workspace\\미니프로젝트\\phoneDB.txt");
			OutputStreamWriter osw = new OutputStreamWriter(ow, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			// 파일로 출력
			for (Mini m : mList) {
				bw.write(m.printout());
				bw.newLine();
			}

			br.close();
			bw.close();
			

		} // -------------while문 종료---------------------

		sc.close();
	}
}
