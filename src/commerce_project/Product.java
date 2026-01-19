package commerce_project;

public class Product {
    private String name;
    private int price;
    private String description;
    private int stock;


    public Product(String name,int price, String description, int stock){
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
    }

//    public int getItem(){
//
//    }
//
//    public int setItem(){
//
//    }


    @Override
    public String toString() {
        return  " "+name +
                " | 가격: " + price +
                " | 설명: " + description +
                " | 재고: " + stock;
    }

}
