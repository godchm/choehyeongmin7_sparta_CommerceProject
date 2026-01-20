package commerce_project;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
     private List<Product> products;

    // 생성자
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }


//    메서드
    public void start(){

        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        while (true) {
            int i = 1;
            for (Product product : products) {
                System.out.println(i + ". " + product);
                i++;
            }
            System.out.println("0. 종료");

            num = sc.nextInt();
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        sc.close();


    }
}
