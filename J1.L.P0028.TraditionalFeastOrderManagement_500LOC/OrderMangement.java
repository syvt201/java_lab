import java.io.File;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OrderMangement {
    Scanner sc = new Scanner(System.in);
    Customers customers = new Customers();
    FeastMenus feastMenus;
    Orders orders = new Orders();

    public void function_1() {
        System.out.print("Customer code: ");
        String code = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if(Customer.validateCustomerCode(code) == false || Customer.validateName(name) == false || 
        Customer.validatePhone(phone) == false || Customer.validateEmail(email) == false) System.out.println("Invalid information to create new customer"); 
        else {
            if(customers.searchBycode(code) != null) System.out.println("Customer with code " + code + " already exists"); 
            else {
                Customer newCustomer = new Customer(code, name, phone, email);
                customers.addCustomer(newCustomer);
            }
        }
    }

    public void function_3(){
        String name;
        System.out.println("Customer name: ");
        name = sc.nextLine();
        List<Customer> cus = customers.searchByName(name);
        if(cus.size() == 0){
            System.out.println("No one matches the search criteria!");
        }else{
            System.out.println("Matching Customers: " + name);
            System.out.println("------------------------------------------------------------------");
            System.out.printf("%-8s| %-24s| %-12s| %-22s\n", "Code", "Customer name", "Phone", "email");
            System.out.println("------------------------------------------------------------------");
            for (Customer customer : cus){
                String[] nameComps = customer.getName().split(" ");
                String lastName = nameComps[nameComps.length-1];
                String otherComps = String.join(" ", (String[]) Arrays.copyOfRange(nameComps, 0, nameComps.length-1));

                System.out.printf("%-8s| %-24s| %-12s| %-22s\n", customer.getCode(), lastName + ", " + otherComps, customer.getPhone(), customer.getEmail());
            }
            System.out.println("------------------------------------------------------------------");
        }
    }

    void function_4() {
        String filename = "D:/HuyTrung/J1.L.P0028.TraditionalFeastOrderManagement_500LOC/FeastMenu.csv";
        File f = new File(filename);
        if(f.exists() && !f.isDirectory()) { 
            feastMenus = new FeastMenus(filename);
            List<FeastMenu> menu = feastMenus.getFeastMenus();

            menu.sort((FeastMenu f1, FeastMenu f2) -> {
                if(f1.getPrice() < f2.getPrice()) return -1;
                else if(f1.getPrice() == f2.getPrice()) return 0;
                else return 1;
            });

            System.out.println("------------------------------------------------------------\n");
            System.out.println("List of Set Menus for ordering party: ");
            System.out.println("------------------------------------------------------------\n");

            for(FeastMenu m : menu) {
                System.out.printf("%-11s:%s\n", "Code", m.getCode());
                System.out.printf("$-11s:%s\n", "Name", m.getName());
                System.out.printf("$-11s:%s\n", "Price", m.getPrice());
                System.out.printf("$-11s:\n", "Ingredients");
                System.out.println(m.getIngredients().replace('#', '\n'));
                System.out.println("------------------------------------------------------------\n");
            }

            System.out.println();

        } else {
           System.out.printf("Cannot read data from \"%s\". Please check it.\n\n", filename); 
        }
    }

    public void function_5(){
        System.out.print("Customer code: ");
        String code = sc.nextLine();
        System.out.print("Code of setMenu: ");
        String menuCode = sc.nextLine();
        System.out.print("Number of tables: ");
        
        int numberOfTable = Integer.parseInt(sc.nextLine());
        System.out.print("Preferred event date: ");
        String eventDate = sc.nextLine();
        if(Customer.validateCustomerCode(code) == false)
            System.out.println("Invalid customer code.");
        else{
            Customer ct = customers.searchBycode(code);
            FeastMenu fm = feastMenus.getByCode(code);
            if(fm == null) System.out.println("Invalid feast menu code."); 
            else if(numberOfTable < 0) System.out.println("Invalid number of tables");
            else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(eventDate, formatter);

                // 2. Check if the date is in the future
                LocalDate today = LocalDate.now();

                if(date.isAfter(today)) {
                    if(orders.isDuplicate(code, menuCode, eventDate)) System.out.println("Dupplicate data !");
                    else {
                        Order newOrder = new Order(code, menuCode, numberOfTable, eventDate, fm.getPrice() * numberOfTable);
                        orders.addOrder(newOrder);
                        System.out.println("Case 1: Order successful");
                        System.out.println("----------------------------------------------------------------");
                        System.out.printf("Customer order information [Order ID: %s]\n", newOrder.getID());
                        System.out.println("----------------------------------------------------------------");
                        // continue

                    }
                } else System.out.println("Invalid event date");
            }
        }
        
    }


    public void menu() {
        String choice;
            
        while(true) {
            System.out.println("1. Register customers");
            System.out.println("2. Update customer information");
            System.out.println("3. Search for customer information by name");
            System.out.println("4. Display feast menus");
            System.out.println("5. Place a feast order");
            System.out.println("6. Update order information. ");
            System.out.println("7. Save data to file. ");
            System.out.println("8. Display Customer or Order lists");
            System.out.println("Others- Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    function_1();
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    function_4();
                    break;
                case "5":
                
                    break;
                case "6":
                    
                    break;
                case "7":
                    
                    break;
                case "8":
                    
                    break;
                case "9":
                    
                    break;

                default:
                    System.exit(0);
                    break;
                
            }
        }
    }

    public static void main(String[] args) {
        OrderMangement OM = new OrderMangement();
        OM.menu();
    }
}