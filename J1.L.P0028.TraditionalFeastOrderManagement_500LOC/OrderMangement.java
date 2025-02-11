import java.util.Scanner;

public class OrderMangement {
    Scanner sc = new Scanner(System.in);
    
    public void function_1() {
        System.out.print("Customer code: ");
        String code = sc.nextLine();
        System.out.print("Name");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if(Customer.validateCustomerCode(code) == false || Customer.validateName(name) == false || 
        Customer.validatePhone(phone) || Customer.validateEmail(email) == false) System.out.println("Invalid information to create new customer"); 
        // else 
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
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    
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
}