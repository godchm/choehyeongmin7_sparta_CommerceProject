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


    CartFinal cartfinal = new CartFinal();

    // 장바구니 내역을 만들기 위해 선언. cart.add 메서드를 통해 반환되는것을 게터로해서 사용.
    // 객체로 선언했기 때문에 가능하다.
    List<Cart> cartSelect = cartfinal.getCart();


    //    메서드
    public void start() {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        int num1, num2;

        // 장바구니 재구 수량 변수
        int num3;

        // 장바구니가 있을때 조건문.
        int num4;
        // 주문 확정 변수
        int num5;

        // 총 금액 변수
        int totalprice = 0;

        // 관리자 모드 변수
        int num6;

        // 관리자 내의 변수
        int num7;

        // 관리자내 카테고리 변수
        int num8;
        // 관리자 내 추가 변수
        int num9;

        // 가격 수정 변수
        int newprice;
        String newdesc;
        int newstock;

        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 ]");
            int i = 1;

            // 향상된 for문 categories 리스트에 들어 있는 Category 객체를 category라는 변수에 담아 반복
            // 카테고리는 List<Product>를 갖고 있다. 즉, 상품의 목록을 갖고 있는 것이다. main에서 객체를 생성했으니 사용할 수 있다.
            for (Category category : categories) {
                System.out.println(i + ". " + category.getName());
                i++;
            }
            System.out.println("0.   | 프로그램 종료");
            System.out.println("6. 관리자 모드");

            if (!cartfinal.getCart().isEmpty()) {
                System.out.println("[ 주문 관리 ]\n" +
                        "4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.\n" +
                        "5. 주문 취소       | 진행중인 주문을 취소합니다.\n");

                System.out.print("주문 관리 선택<- ");
                num4 = sc.nextInt();
                if (num4 == 4) {
                    System.out.println("[ 장바구니 내역 ]");
//                    향상된 for문 Cart객체 안에 cartSelect를 하나씩 꺼내서 cart변수에 넣고 하나씩 돌린다.
                    for (Cart cart : cartSelect) {
                        int price = cart.getTotalPrice();
                        System.out.println(cart.getProduct().getName() + " | " + price + "원 " + " | " + cart.getProduct().getDescription() +
                                " | " + cart.getAmount() + "개"

                        );
                        totalprice += price;
                    }

                    System.out.println("[ 총 주문 금액 ]");
                    System.out.println(totalprice + "원");

                    System.out.println("1. 주문확정        2. 메인으로 돌아가기");
                    System.out.print("선택 <- ");
                    num5 = sc.nextInt();
                    if (num5 == 1) {
                        System.out.println("주문이 완료되었습니다!   총 금액:" + totalprice+"원 입니다.");
                        for (Cart cart : cartSelect) {
                            System.out.println(cart.getProduct().getName() + " 재고가 " + cart.getProduct().getStock() + "개 " + "(" + (cart.getProduct().getStock() - cart.getAmount()) + ")"
                                    + "개로 업데이트되었습니다.");
                        }
                        break;
                    } else {
                        continue;
                    }

                }
            }

            System.out.print("컴머스 플랫폼 선택 <- ");
            num = sc.nextInt();
            num6 = num;
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


            if (num6 == 6) {
                sc.nextLine();
//                System.out.println("관리자 비밀번호를 입력해주세요:");
//                String inputpassword = sc.nextLine();
                // 입력 넘겨주기
                if (!Manger.mangerpassword(sc)) {
                    System.out.println("관리자가 아니다.");
                    continue;
                }

                while (true) {
                    System.out.println("\n관리자 모드로 진입합니다.");
                    System.out.println("[ 관리자 모드 ]\n" +
                            "1. 상품 추가\n" +
                            "2. 상품 수정\n" +
                            "3. 상품 삭제\n" +
                            "4. 전체 상품 현황\n" +
                            "0. 메인으로 돌아가기");
                    System.out.print("<-");
                    num7 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\n");
                    if (num7 == 0) {
                        break;
                    }
                    if (num7 == 1) {
                        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
                        int j = 1;
                        for (Category category : categories) {
                            System.out.println(j + ". " + category.getName());
                            j++;
                        }
                        System.out.print("<-");
                        num8 = sc.nextInt();
                        Category select1 = categories.get(num8 - 1);
                        System.out.println("\n");
                        System.out.println("[" + select1.getName() + " 카테고리에 상품 추가 ]");
                        System.out.print("상품명을 입력해주세요: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("가격을 입력해주세요: ");
                        int price = sc.nextInt();
                        System.out.print("상품 설명을 입력해주세요: ");
                        sc.nextLine();
                        String description = sc.nextLine();
                        System.out.print("재고수량을 입력해주세요: ");
                        int stock = sc.nextInt();
                        Product product = new Product(name, price, description, stock);
                        select1.addProduct(product);

                        System.out.println("[ 현재 " + select1.getName() + " 카테고리 상품 목록 ]");
                        System.out.println(
                                product.getName() + " | " +
                                        product.getPrice() + " | " +
                                        product.getDescription() + " | " +
                                        product.getStock()
                        );
//                    System.out.println(product.getName()+""+ product.getPrice()+""+product.getDescription()+""+product.getStock());

                        System.out.println("\n위 정보로 상품을 추가하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        System.out.print("<-");
                        num9 = sc.nextInt();
                        if (num9 == 1) {
                            System.out.println("\n상품이 성공적으로 추가되었습니다!\n");
                            select1.getProduct().add(product);
                        } else {
                            select1.getProduct().remove(product);
                            break;
                        }
                    } else if (num7 == 2) {
                        System.out.print("수정할 상품명을 입력해주세요:");
                        String name1 = sc.nextLine();

                        Product p1 = null;

                        // 카테고리 List<Product> products 객체 정보 갖고 있음. 메인에서 리스로 데이터를 전달할때 잘못했다..
                        // 카테고리는 전자제품, 식품, 의류 정보를 담고 있다.
                        // Product는 세세한 상품 정보들을 갖고있다.
                        // Main에서 복잡하게 데이터를 전달했다.
                        // 리스트를 선언한다는거는 향상된 for문에서 사용.
                        for (Category c : categories) {
                            for (Product p : c.getProduct()) {
                                if (p.getName().equals(name1)) {
                                    p1 = p;
                                    break;
                                }
                            }
                            if (p1 != null) break;
                        }
                        if (p1 == null) {
                            System.out.println("해당 상품이 존재하지 않습니다.");
                            continue;
                        }

                        System.out.println("현재 상품 정보: " + p1);

                        System.out.println("수정할 항목을 선택해주세요:");
                        int num10 = sc.nextInt();
                        if (num10 == 1) {
                            System.out.println("현재 가격:" + p1.getPrice());
                            System.out.print("새로운 가격을 입력해주세요: ");
                            newprice = sc.nextInt();
                            System.out.println(p1.getName() + "의" + "가격이 " + p1.getPrice() + "->" + newprice + " 원으로 수정되었습니다.");
                            p1.setPrice(newprice);
                        }
                        if (num10 == 2) {
                            System.out.println("현재 설명 :" + p1.getStock());
                            System.out.print("새로운 설명 입력 : ");
                            newdesc = sc.nextLine();
                            System.out.println(p1.getName() + "의" + "설명이 " + p1.getDescription() + "->" + newdesc + " 으로 수정되었습니다.");
                            p1.setDescription(newdesc);
                        }
                        if (num10 == 3) {
                            System.out.println("현재 재고 :" + p1.getDescription());
                            System.out.print("새로운 재고 입력 : ");
                            newstock = sc.nextInt();
                            System.out.println(p1.getName() + "의" + " 재고가 " + p1.getPrice() + "->" + newstock + " 개로 수정되었습니다.");
                            p1.setStock(newstock);
                        }


                    } else if (num7 == 3) {
                        System.out.print("삭제할 상품명을 입력해주세요:");
                        String name2 = sc.nextLine();

                        Product p2 = null;
                        Category targetC = null;

                        for (Category c : categories) {
                            for (Product p : c.getProduct()) {
                                if (p.getName().equals(name2)) {
                                    p2 = p;
                                    // 카테고리 상위 개념 활용
                                    // 전자제품: 갤렉시, 아이폰. 즉 전자제품이 상위 개념.
                                    targetC = c;
                                    break;
                                }
                            }
                            if (p2 != null) {
                                break;
                            }
                        }
                        if (p2 == null) {
                            System.out.println("해당 상품이 존재하지 않습니다.");
                            continue;
                        }
                        System.out.println("현재 상품 정보: " + p2);

                        System.out.println("삭제 하시겠습니까?");
                        System.out.println("1. 네         2. 아니오");
                        int num11 = sc.nextInt();

                        if (num11 == 1) {
                            targetC.getProduct().remove(p2);
                            System.out.println("상품이 삭제되었습니다.");
                        }
                        if (num11 == 2) {
                            break;
                        }
                    } else if(num7==4){
                        System.out.println("전체 상품 현황");

                        for(Category c: categories) {
                            System.out.println("[ " + c.getName() + " ]");
                            for (Product p : c.getProduct()) {
                                System.out.println("- " + p);
                            }
                        }
                        while (true) {
                            System.out.println("0. 뒤로 가기");
                            int num12 = sc.nextInt();
                            if (num12 == 0) {
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다.");
                            }
                        }
                    }

                }
                continue;
            }
            while (true) {
                // 리스트에서 인덱스 정보 가져오기 get 사용 인덱스는 0부터 시작하므로 -1 설정
                Category select = categories.get(num - 1);
                // List<Product> 타입으로 변환하기때문에 써준다.
                List<Product> products = select.getProduct();
                System.out.println("\n[ " + select.getName() + " 상품 목록 ]");
                int i1 = 1;
                for (Product product : select.getProduct()) {
                    System.out.println(i1 + ". " + product);
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
                Product product = products.get(num1 - 1);
                System.out.println("선택한 상품: " + product);
                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인          2.취소");
                num2 = sc.nextInt();
                if (num2 == 1) {
                    System.out.println("담을 수량을 입력해주세요.");
                    System.out.print("수량 :");
                    num3 = sc.nextInt();
                    if (num3 > product.getStock()) {
                        System.out.println("재고가 부족합니다.");
                        break;
                    } else {
                        System.out.println(product.getName() + "가 " + num3 + "개(수량) 장바구니에 추가되었습니다.");
                        cartfinal.CartData(product, num3);
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
