package commerce_project;

import java.util.List;

public class Manger{
    private  List<Category> categories;
    private  CartFinal cartFinal;
    private static final String password = "admin123";

    public Manger(List<Category> categories, CartFinal cartFinal) {
        this.categories = categories;
        this.cartFinal = cartFinal;
    }

    public boolean mangerpassword(String input) {
        return "admin123".equals(input);
    }

    public void deleteService(Product product){



    }
}
