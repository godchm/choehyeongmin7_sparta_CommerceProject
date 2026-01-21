package commerce_project;

public class Customer {

    // 속성
    private int totalPrice;
    private String customerName;
    private String rank;
    private String email;


    // 생성자
    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }



    public void rankchange(){
        if (totalPrice < 500000) {
            rank = "브론즈";
        }
        if (totalPrice < 1000000) {
            rank = "실버";
        }
        if (totalPrice < 2000000) {
            rank = "골드";
        }
        if(totalPrice>=2000000){
            rank = "플래티넘";
        }
    }

    // 게터
    public String getRank() { return rank; }
    public int getTotalPrice() { return totalPrice; }
    public String getCustomerName() { return customerName; }
    public String getEmail() { return email;}

    // 세터
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setEmail(String email) { this.email = email; }
}
