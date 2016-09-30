package java76.pms;

import java.util.Scanner;

public class asdf {
  public static void main(String[] args) {
		System.out.println("진단이 뭐냐");
		String str = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("미창부 or 노동부를 입력해라 개자식아");
		str = scanner.nextLine();
		if (str.equals("미창부")) {
		} else if (str.equals("노동부")){
			System.out.println("중대 재해냐 그거냐");
			str = scanner.nextLine();
			if(str.equals("중대재해")) {
				System.out.println("How many PPL?");
				int i = scanner.nextInt();
				if(i >= 100) {
					System.out.println("산업안전 보건 위원회 운영 ing?");
				} else if(i <= 50) {
					System.out.println("dasdfads");
				}
			}
		} else {
			System.out.println("제대로 입력해라 시방새야");
		}
		scanner.close();
	}
}
