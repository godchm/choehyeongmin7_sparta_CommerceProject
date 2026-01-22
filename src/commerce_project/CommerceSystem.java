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

    // 장바구니 내역을 만들기 위해 선언. cart.add 메서드를 통해 반환되는것을 게터로해서 사용.
    // 객체로 선언했기 때문에 가능하다.
    List<Cart> cartSelect = cartfinal.getCart();



//    메서드
    public void start(){

        Scanner sc = new Scanner(System.in);
        int num,num1,num2;

        // 장바구니 재구 수량 변수
        int num3;

        // 장바구니가 있을때 조건문.
        int num4;
        // 주문 확정 변수
        int num5;

        //
        int totalprice=0;

        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 ]");
            int i = 1;

            //categories 리스트에 들어 있는 Category 객체를 category라는 변수에 담아 반복
            for (Category category : categories) {
                System.out.println(i + ". " + category.getName());
                i++;
            }
            System.out.println("0.   | 프로그램 종료");

            if(!cartfinal.getCart().isEmpty()) {
                System.out.println("[ 주문 관리 ]\n" +
                        "4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.\n" +
                        "5. 주문 취소       | 진행중인 주문을 취소합니다.\n");

                System.out.print("주문 관리 선택<- ");
                num4 = sc.nextInt();
                if (num4 == 4) {
                    System.out.println("[ 장바구니 내역 ]");
                    for(Cart cart:cartSelect){
                        int price = cart.getTotalPrice();
                        System.out.println(cart.getProduct().getName() +" | "+price+"원 "+" | "+cart.getProduct().getDescription()+
                                " | " + cart.getAmount() +"개"

                        );
                        totalprice+=price;
                    }

                    System.out.println("[ 총 주문 금액 ]");
                    System.out.println(totalprice + "원");

                    System.out.println("1. 주문확정        2. 메인으로 돌아가기");
                    System.out.print("선택 <- ");
                    num5 = sc.nextInt();
                    if (num5 == 1) {
                        System.out.println("주문이 완료되었습니다!   총 금액:" + totalprice);
                        for (Cart cart:cartSelect){
                        System.out.println(cart.getProduct().getName()+" 재고가 "+cart.getProduct().getStock()+"개 "+"("+(cart.getProduct().getStock()-cart.getAmount())+")"
                        +"개로 업데이트되었습니다.");
                        }
                        break;
                    } else {
                        continue;
                    }

                }
            }

            System.out.print("컴머스 플랫폼 선택 <- ");
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
                        }else{
                            System.out.println(product.getName()+"가 "+num3+"개(수량) 장바구니에 추가되었습니다.");
                            cartfinal.CartData(product,num3);
                            break;
                            // 총 가격
//                            int price=cartfinal.getCart().get(0).getTotalPrice();
//                            System.out.println(product.getName()+" "+(product.getStock()+num3)+price);

                        }
                    }

                }

        }

        // 닫아줘야 한다.
        sc.close();
        System.out.println("커머스 프래그램을 종료합니다.");



    }
}
