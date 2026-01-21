package commerce_project;

public class Cart {

    // 속성
    private Product product;
    private int Amount;

    // 생성자
    public Cart(Product product,int Amount){
        this.product=product;
        this.Amount=Amount;
    }

    // 상품의 정보
    public Product getProduct(){
        return product;
    }

    // 재고
    public int getAmount(){
        return Amount;
    }

    // 총 상품 가격
    public int getTotalPrice() {
        return product.getPrice() * Amount;
    }

}
