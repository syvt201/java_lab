public class FeastMenu {
    private String code;
    private String name;
    private double price;
    private String ingredients;

    public FeastMenu() {
    }

    public FeastMenu(String code, String name, double price, String ingredients) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return String.format("FeatMenu[code=%s, name=%s, price=%s, ingredients=%f]", code, name, price, ingredients); 
    }
    
}