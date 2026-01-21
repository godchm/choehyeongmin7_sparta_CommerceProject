package commerce_project;

public class Product {

    // 속성
    private String name;
    private int price;
    private String description;
    private int stock;


    // 생성자
    public Product(String name,int price, String description, int stock){
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
    }

    // 장바구니 기능을 만들기 위해 게터로 정보를 얻는다.
    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return  " "+name +
                " | 가격: " + price +
                " | 설명: " + description +
                " | 재고: " + stock;
    }

}
