package commerce_project;

import java.util.List;

public class Category {

    // 속성
    private String name;
    private List<Product> products;

    // 생성자
    public Category(String name, List<Product> products){
        this.name=name;
        this.products=products;
    }

    // 게터
    public String getName() {
        return name;
    }

    public void setName(String name){this.name=name;};

    // 게터 결국에는 상품들을 묶는 상위 개념의 이름이 필요
    public List<Product> getProduct() {
        return products;
    }
    public void  setProduct(List<Product> products){this.products=products;};

}
