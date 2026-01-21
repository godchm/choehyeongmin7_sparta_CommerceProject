package commerce_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> sunderproducts=List.of(
                new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50),
                new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 40),
                new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 30),
                new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20)
        );
        List<Product> foodproducts=List.of(
                new Product("사과", 100000, "달다", 50),
                new Product("포도", 1350, "보라색", 45),
                new Product("딸기", 24000, "달콤", 20),
                new Product("수박", 35000, "당이 높다", 10)
        );
        List<Product> clothesproducts=List.of(
                new Product("후드티", 120000, "따듯", 50),
                new Product("패딩", 135000, "따듯", 45),
                new Product("바지", 24000, "따듯", 15),
                new Product("후리스", 150000, "따듯", 10)
        );

        Category sunder=new Category("전자제품",sunderproducts);
        Category food=new Category("식품",foodproducts);
        Category clthoes=new Category("의류",clothesproducts);

        CommerceSystem commercesystem = new CommerceSystem(List.of(sunder, food, clthoes));


        commercesystem.start();
        }

    }

