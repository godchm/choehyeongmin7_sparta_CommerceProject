package commerce_project;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
     private List<Category> categories;

    // 생성자
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }


//    메서드
    public void start(){

        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 ]");
            int i = 1;
            for (Category category : categories) {
                System.out.println(i + ". " + category.getName());
                i++;
            }

            System.out.println("0. 프로그램 종료");
            System.out.print("선택 <- ");

            num = sc.nextInt();
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            Category select=categories.get(num-1);
            System.out.println("\n[ " + select.getName() + " 상품 목록 ]");
            for (Product product : select.getProduct()) {
                System.out.println(" - " + product);
            }



        }

        sc.close();


    }
}
