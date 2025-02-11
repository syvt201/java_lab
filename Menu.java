import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static Students students = new Students();
    private static Mountains mountains = new Mountains("MountainList.csv");

    public static boolean isRegisted (String ID) {
        if(ID == null || ID.length() != 8) return false;
        return students.searchById(ID) != null;
    }

    public static boolean validateID (String ID) {
        if(ID == null || ID.length() != 8) return false;
        return ID.matches("^[CcDdHhSsQq][Ee]\\d{6}$");
    }

    public static boolean validateName (String name) {
        if(name == null) return false;
        return name.matches("^.{2,20}$");
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
            if(validateID(ID) == false || isRegisted(ID) == true)
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
        if(teleComp == "vnpt" || teleComp == "viettel") totalFee = totalFee * (1 - 0.35);
        students.add(new Student(ID, name, phone, email, code, totalFee));

        System.out.println();
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
        if(teleComp == "vnpt" || teleComp == "viettel") totalFee = totalFee * (1 - 0.35);
        students.update(ID, name, phone, email, code, totalFee);
        System.out.println("Update successfully.");
        System.out.println();

    }

    public static void function_3() {
        students.showAll();
        System.out.println();

    }

    public static void function_4() {
        String ID;
        System.out.print("Student Code: ");
        ID = sc.nextLine();
        Student std = students.searchById(ID);

        if(std == null) {
            System.out.println("This student has not registered yet.");
        } else {
            String choice;
            System.out.println("Student Details:");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-10s: %s\n", "Student ID", std.getId());
            System.out.printf("%-10s: %s\n", "Name", std.getName());
            System.out.printf("%-10s: %s\n", "Phone", std.getPhone());
            System.out.printf("%-10s: %s\n", "Mountain", std.getMountainCode());
            System.out.printf("%-10s: %s\n", "Fee", (int) std.getTuitionFee());
            System.out.println("-----------------------------------------------------");
            System.out.print("Are you sure you want to delete this registration? (Y/N): ");
            choice = sc.nextLine();

            if(choice == "y" || choice == "Y") {
                students.delete(ID);
                System.out.println("\nThe registration has been successfully deleted.\n");
            }
        }
        System.out.println();

    }

    public static void function_5() {
        String name;
        System.out.print("Student name: ");
        name = sc.nextLine();
        List<Student> stds = students.searchByName(name);

        if(stds.size() == 0) {
            System.out.println("No one matches the search criteria!");
        } else {
            System.out.println("Matching Students:");
            System.out.println("----------------------------------------------------------------");
            System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", "Student ID", "Name", "Phone", "Peak Code", "Fee");
            System.out.println("----------------------------------------------------------------");
            for (Student student : stds) {
                System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", student.getId(), student.getName(), student.getPhone(),
                        student.getMountainCode(), (int) student.getTuitionFee());
            }
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();

    }

    public static String getCampus(String campus){
        if(campus.equals("CE")) return "Can Tho";
        if(campus.equals("DE")) return "Da Nang";
        if(campus.equals("HE")) return "Ha Noi";
        if(campus.equals("SE")) return "Ho Chi Minh";
        if(campus.equals("QE")) return "Quy Nhon";
        return null;
    }
    public static void function_6() {
        String campus;
        System.out.print("Campus code: ");
        campus = sc.nextLine();
        List<Student> stds = students.searchByCampus(campus);
        
        if(stds == null){
            System.out.println("No students have registered under this campus.");
        }else{
            System.out.printf("Registered Students Under %s Campus (%s):\n", getCampus(campus), campus);
            System.out.println("----------------------------------------------------------------");
            System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", "Student ID", "Name", "Phone", "Mountain", "Fee");
            System.out.println("----------------------------------------------------------------");
            for (Student student : stds) {
                System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", student.getId(), student.getName(), student.getPhone(),
                        student.getMountainCode(), (int) student.getTuitionFee());
            }
            System.out.println("----------------------------------------------------------------");
            
            
        }

    }

    public static void function_7() {
        List<String> codes = students.getMountainCode();
        System.out.println("-----------------------------------------------------------------");
        //                    "Peak Name     | Number of Participants | Total Cost"
        System.out.printf("%-14s| %-21s| %-23s\n", "Peak Name", "Number of Participants", "Total Cost");
        System.out.println("-----------------------------------------------------------------");

        for(String code : codes) {
            List<Student> stds = students.getStudentByMountainCode(code);
            if(stds.size() == 0) continue;
            int totalCost = 0;

            for(Student std : stds) totalCost += std.getTuitionFee();
            System.out.printf("%-14s| %-21s| %-23s\n", code, stds.size(), totalCost);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }

    public static void function_8() {
        System.out.print("Enter the file to save: ");
        String filename = sc.nextLine();
        try{
            students.saveToFile(filename);
            System.out.println("Save successfully to " + filename);
            System.out.println();
        } catch (Exception e) {
            
        }
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
                // e.printStackTrace();
                System.out.println("Invalid choice.");
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
                    function_4();
                    break;
                case 5:
                    function_5();
                    break;
                case 6:
                    function_6();
                    break;
                case 7:
                    function_7();
                    break;
                case 8:
                    function_8();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Option %s does not exists.\n\n", choice);
                    break;
            }
        }
    }
    public static void main (String args[]) {
        menu();
    }
}
