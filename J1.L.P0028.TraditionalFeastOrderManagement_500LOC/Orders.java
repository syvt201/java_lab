import java.util.ArrayList;
import java.util.List;

public class Orders {
    List<Order> orders = new ArrayList<>();
    
    public Orders() {

    }

    public void addOrder(Order od) {
        orders.add(od);
    }

    boolean isDuplicate(String customerCode, String setMenuCode, String preferedEventDate) {
        for(Order od : orders) {
            if(od.getCustomerCode().equals(customerCode) && od.getSetMenuCode().equals(setMenuCode) && od.getPreferedEventDate().equals(preferedEventDate)) return false;
        }
        return true;
    }
}
