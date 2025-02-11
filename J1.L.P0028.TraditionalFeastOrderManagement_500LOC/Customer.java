public class Customer {
    private String code;
    private String name;
    private String phone;
    private String email;

    public Customer() {
    }

    public static boolean validateCustomerCode (String code) {  // static: make method to be class member --> can access via class name
        String pattern = "^[CGK]\\d{4}$";
        return code.matches(pattern);
    }

    public static boolean validateName (String name) {
        if(name == null) return false;
        int length = name.length();

        return 2 <= length && length <= 25;
    }

    public static boolean validatePhone (String phone) {
        if(phone == null) return false;
        return phone.matches("^(08|03|09)\\d{8}$");
    }

    public static boolean validateEmail(String email) {
        if (email == null) return false;
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // regex: regular expression
        return email.matches(emailRegex);
    }

    public Customer(String code, String name, String phone, String email) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return String.format("Customers[code=%s, name=%s, phone=%s, email=%s]", code, name, phone, email); }
    
}
