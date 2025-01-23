import java.util.Scanner;

public class Menu {
    public static void menu () {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. New Registration");
            System.out.println("2. Update Registration Information");
            System.out.println("3. Display Registered List");
            System.out.println("4. Delete Registration Information");
            System.out.println("5. Search Participants by Name");
            System.out.println("6. Filter Data by Campus");
            System.out.println("7. Statistics of Registration Numbers by Location");
            System.out.println("8. Save Data to File");
            System.out.println("9. Exit the Program");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            } 

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                
                    break;
                case 3:
                
                    break;
                case 4:
                
                    break;
                case 5:
                
                    break;
                case 6:
                
                    break;
                case 7:
                
                    break;
                case 8:
                
                    break;
                case 9:

                    break;
                default:
                    break;
            }
        }
    }
    public static void main (String args[]) {

    }
}
