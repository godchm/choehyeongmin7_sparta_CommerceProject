package commerce_project;

import java.util.List;
import java.util.Scanner;

public class Manger{

    private static final String password = "admin123";
    private static final int maxpassword=3;

    // 관리자 비밀번호 관리.. boolean으로 판단하자.
    public static boolean mangerpassword(Scanner sc) {
        int fail=0;
        while (fail < maxpassword) {
            System.out.println("비밀번호를 입력하세요.");
            String inputpassword = sc.nextLine();

            if (password.equals(inputpassword)) {
                System.out.println("관리자 로그인 성공!");
                return true;
            } else {
                fail++;
                System.out.println("비밀번호가 틀렸습니다. \n");
            }
        }
        System.out.println("비밀번호 3회 실패. 메인 메뉴로 돌아갑니다.");
        return false;


    }

}
