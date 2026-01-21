package commerce_project;

import java.util.List;

public class CartFinal {

    private List<Cart> cart;

    // 하나로 묶어서 객체로 전달
    public void CartData(Product product, int Amount){
        cart.add(new Cart(product,Amount));
    }

    public List<Cart>getCart (){
        return cart ;
    }
}
