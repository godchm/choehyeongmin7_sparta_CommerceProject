package commerce_project;

import java.util.ArrayList;
import java.util.List;

public class CartFinal {

    // 선언과 초기화
    private List<Cart> cart=new ArrayList<Cart>();

    // 하나로 묶어서 객체로 전달. 이러면 Cart 객체를 따로 생성할필요없이. CartFinal 객체만 생성해서 Cart 객체도
    // 사용이 가능한 상태이다. 왜냐하면 CartFinal을 사용하려면 Cart 객체도 생성이 필요하지만 그럴필요가 없는 상태라고 할 수 잇다.
    public void CartData(Product product, int Amount){
        cart.add(new Cart(product,Amount));
    }

    public List<Cart>getCart (){
        return cart ;
    }


}
