import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static Students students = new Students();
    private static Mountains mountains = new Mountains("MountainList.csv");

    public static boolean validateID (String ID) {
        if(ID == null || ID.length() != 8) return false;
        if(students.searchById(ID) != null) return false;
        return ID.matches("^[CcDdHhSsQq][Ee]\\\\d{6}$");
    }

    public static boolean validateName (String name) {
        if(name == null) return false;
        return name.matches("^.{2,20}$");
    }

    public static boolean validatePhone (String phone) {
        if(phone == null) return false;
        return phone.matches("^(081|082|083|084|085|088|091|094)\\\\d{7}$");
    }

    public static boolean validateEmail(String email) {
        if (email == null) return false;
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // regex: regular expression
        return email.matches(emailRegex);
    }

    public static boolean validateMountainCode(String code) {
        if(mountains.isValidMountainCode(code) == false) return false;
        return mountains.searchMountain(code) != null;
    }

    public static String telecomCompany (String phone) {
        String viettel[] = {"086", "096", "097", "098", "032", "032", "033", "034", "035", "036", "037", "038", "039"};
        String vnpt[] = {"091", "094", "081", "082", "083", "084", "085", "088"};

        for(String p : viettel) if(phone.startsWith(p)) return "viettel";

        for(String p : vnpt) if(phone.startsWith(p)) return "vnpt";

        return null;
    }

    public static void function_1 () {
        String ID, name, phone, email, code;
        double fee = 6000000.0;
        double totalFee = fee;
        while(true) {
            System.out.print("Student ID: ");
            ID = sc.nextLine();
            if(validateID(ID) == false)
                System.out.println("Invalid ID, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Name: ");
            name = sc.nextLine();
            if(validateName(name) == false)
                System.out.println("Invalid name, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Phone Number: ");
            phone = sc.nextLine();
            if(validatePhone(phone) == false)
                System.out.println("Invalid phone number, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Email: ");
            email = sc.nextLine();
            if(validateEmail(email) == false)
                System.out.println("Invalid email, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Mountain Code: ");
            code = sc.nextLine();
            if(validateMountainCode(code) == false)
                System.out.println("Invalid mountain code, enter again.");
            else break;
        }

        String teleComp = telecomCompany(phone);
        if(teleComp == "vnpt" || teleComp == "viettel") totalFee = totalFee * (1 + 0.35);
        students.add(new Student(ID, name, phone, email, code, totalFee));
    }

    public static void function_2 () {
        String ID, name, phone, email, code;
        while(true) {
            System.out.print("Student Code: ");
            ID = sc.nextLine();
            if(validateID(ID) == false)
                System.out.println("Invalid ID, enter again.");
            else if (students.searchById(ID) == null) {
                System.out.println("This student has not registered yet.");
                return;
            } else break;
        }

        while(true) {
            System.out.print("Name: ");
            name = sc.nextLine();
            if(validateName(name) == false)
                System.out.println("Invalid name, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Phone Number: ");
            phone = sc.nextLine();
            if(validatePhone(phone) == false)
                System.out.println("Invalid phone number, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Email: ");
            email = sc.nextLine();
            if(validateEmail(email) == false)
                System.out.println("Invalid email, enter again.");
            else break;
        }

        while(true) {
            System.out.print("Mountain Code: ");
            code = sc.nextLine();
            if(validateMountainCode(code) == false)
                System.out.println("Invalid mountain code, enter again.");
            else break;
        }

        String teleComp = telecomCompany(phone);
        double totalFee = 6000000;
        if(teleComp == "vnpt" || teleComp == "viettel") totalFee = totalFee * (1 + 0.35);
        students.update(ID, name, phone, email, code, totalFee);
        System.out.println("Update successfully.");
    }

    public static void function_3() {
        students.showAll();
    }

    public static void menu () {
        int choice = 0;
        
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
                    function_1();
                    break;
                case 2:
                    function_2();
                    break;
                case 3:
                    function_3();
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
