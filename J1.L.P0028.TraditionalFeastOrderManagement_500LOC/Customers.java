import java.util.ArrayList;
import java.util.List;

public class Customers {
    private List<Customer> customers;

    /*
     * 1. constructor
     * 2. add customer
     * 3. search customer by code
     * 4. search customer by name
     * 5. remove customer by code
     * 6. update customer
     */
    public Customers() {
        this.customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public Customer searchBycode(String code) {
        for(int i = 0; i < customers.size(); i++) {
            Customer cu = customers.get(i);
            if(cu.getCode().equals(code)) {
                return cu;
            }
        }

        return null;
    }
    
    public List<Customer> searchByName (String name) {
        List<Customer> res = new ArrayList<>();
        for(Customer cus : this.customers) {
            if(cus.getName().toLowerCase().contains(name.toLowerCase())) res.add(cus);
        }

        return res;
    }
    
    public void delete(String id) {
        for(int i = 0; i < customers.size(); i++) {
            Customer cu = customers.get(i);
            if(cu.getCode().equals(id)) {
                customers.remove(i);
            }
        }
    }
    
    public void update(Customer x) {
        for(int i = 0; i < customers.size(); i++) {
            Customer cu = customers.get(i);
            if(cu.getCode().equals(x.getCode())) {
                customers.set(i, x);
            }
        }
    }

    public void update(String code, String name, String phone, String email) {
        Customer cus = this.searchBycode(code);
        if(cus == null) return;
        cus.setName(name);
        cus.setPhone(phone);
        cus.setEmail(email);
        
    }

}

