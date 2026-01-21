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

    CartFinal cartfinal=new CartFinal();

//    메서드
    public void start(){

        Scanner sc = new Scanner(System.in);
        int num,num1,num2;

        // 장바구니 재구 수량 변수
        int num3;

        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 ]");
            int i = 1;

            //categories 리스트에 들어 있는 Category 객체를 category라는 변수에 담아 반복
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
                    // List<Product> 타입으로 변환하기때문에 써준다.
                    List<Product> products=select.getProduct();
                    System.out.println("\n[ " + select.getName() + " 상품 목록 ]");
                    int i1=1;
                    for (Product product : select.getProduct()) {
                        System.out.println(i1+". "+product);
                        i1++;
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
                    System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인          2.취소");
                    num2=sc.nextInt();
                    if (num2==1){
                        System.out.println("담을 수량을 입력해주세요.");
                        System.out.print("수량 :");
                        num3= sc.nextInt();
                        if(num3> product.getStock()){
                            System.out.println("재고가 부족합니다.");
                            break;
                        }
                    }

                }

        }

        // 닫아줘야 한다.
        sc.close();
        System.out.println("커머스 프래그램을 종료합니다.");



    }
}
