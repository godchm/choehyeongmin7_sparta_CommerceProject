package commerce_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products=List.of(
                new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50),
                new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 40),
                new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 30),
                new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20)
        );

        Scanner sc=new Scanner(System.in);
        int num;

            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            while (true) {
                int i = 1;
                for (Product product : products) {
                    System.out.println(i + "." + product);
                    i++;
                }
                System.out.println("0. 종료");
                num=sc.nextInt();
                if (num==0) {
                    break;
                }

            }
      sc.close();
        System.out.println("프로그램 종료");
        }

    }

