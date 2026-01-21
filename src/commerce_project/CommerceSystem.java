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
        int num,num1;

        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 ]");
            int i = 1;
            for (Category category : categories) {
                System.out.println(i + ". " + category.getName());
                i++;
            }
            System.out.println("0.   | 프로그램 종료");
            System.out.print("선택 <- ");

            num = sc.nextInt();

            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
                while (true) {
                    // 리스트에서 인덱스 정보 가져오기 get 사용 인덱스는 0부터 시작하므로 -1 설정
                    Category select = categories.get(num - 1);
                    List<Product> products=select.getProduct();
                    System.out.println("\n[ " + select.getName() + " 상품 목록 ]");
                    for (Product product : select.getProduct()) {
                        System.out.println(" - " + product);
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("입력 <- ");
                    num1 = sc.nextInt();
                    if (num1 == 0) {
                        System.out.println("뒤로가기.");
                        break;
                    }

                    // 리스트에서 인덱스 정보 가져오기 get 사용 인덱스는 0부터 시작하므로 -1 설정.
                  Product product=products.get(num1-1);
                    System.out.println("선택한 상품: " + product);
                    break;
                }

        }

        sc.close();
        System.out.println("커머스 프래그램을 종료합니다.");



    }
}
