public class Order {
    private int ID; // static variable: có thể được truy cập thông qua class name và share giữa các object của class Order
    static int idCount = 1;
    private String customerCode;
    private String setMenuCode;
    private int numberOfTable;
    private String preferedEventDate;
    private double totalCost;

    public Order() {
    }

    public Order(String customerCode, String setMenuCode, int numberOfTable, String preferedEventDate) {
        this.ID = idCount;
        this.customerCode = customerCode;
        this.setMenuCode = setMenuCode;
        this.numberOfTable = numberOfTable;
        this.preferedEventDate = preferedEventDate;
        idCount++;
    }

    public void setTotalCost(FeastMenu f) {
        this.totalCost = numberOfTable * f.getPrice();
    }

    public void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public int getID() {
        return ID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSetMenuCode() {
        return setMenuCode;
    }

    public void setSetMenuCode(String setMenuCode) {
        this.setMenuCode = setMenuCode;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public String getPreferedEventDate() {
        return preferedEventDate;
    }

    public void setPreferedEventDate(String preferedEventDate) {
        this.preferedEventDate = preferedEventDate;
    }
}
