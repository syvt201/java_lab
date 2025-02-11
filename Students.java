import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private String pathFile;
    private boolean isSaved;
    private ArrayList<Student> students = new ArrayList<>();

    public Students() {};

    public Students(String pathFile) {this.pathFile = pathFile;}

    public boolean isSaved() {return isSaved;}

    public int size() {
        return students.size();
    }

    public void add(Student x) {
        students.add(x);
    }

    public void update(Student x) {
        for(int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getId().equals(x.getId())) {
                students.set(i, x);
            }
        }
    }

    public void update(String ID, String name, String phone, String email, String mountainCode, double fee) {
        Student std = this.searchById(ID);
        if(std == null) return;
        std.setName(name);
        std.setPhone(phone);
        std.setEmail(email);
        std.setMountainCode(mountainCode);
        std.setTuitionFee(fee);
    }

    public void delete(String id) {
        for(int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getId().equals(id)) {
                students.remove(i);
            }
        }
    }

    public Student searchById(String id) {
        for(int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getId().equals(id)) {
                return st;
            }
        }

        return null;
    }

    public List<Student> searchByName (String name) {
        List<Student> res = new ArrayList<>();
        for(Student std : this.students) {
            if(std.getName().toLowerCase().contains(name.toLowerCase())) res.add(std);
        }

        return res;
    }

    public List<Student> searchByCampus (String campus){
        List<Student> res = new ArrayList<>();
        for(Student std : this.students){
            if(std.getId().toUpperCase().contains(campus.toUpperCase())) res.add(std);
        }
        return res;
    }

    public List<String> getMountainCode () {
        List<String> res = new ArrayList<>();
        for(Student std : this.students) {
            String mt_code = std.getMountainCode();
            if(res.contains(mt_code) == false) res.add(mt_code);
        }

        return res;
    }

    public List<Student> getStudentByMountainCode(String mountainCode) {
        List<Student> res = new ArrayList<>();
        for(Student std : this.students) {
            String mt_code = std.getMountainCode();
            if(mt_code.equals(mountainCode)) res.add(std);
        }

        return res;
    }
    
    public void saveToFile(String filename) throws FileNotFoundException, IOException {
        List<StudentSerializable> stds = new ArrayList<>();
        for (Student std : this.students) {
            stds.add(new StudentSerializable(std));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(stds);
        }
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", "Student ID", "Name", "Phone", "Peak Code", "Fee");
            System.out.println("----------------------------------------------------------------");
            for (Student student : students) {
                System.out.printf("%-12s| %-15s| %-11s| %-9s| %-10s\n", student.getId(), student.getName(), student.getPhone(),
                        student.getMountainCode(), (int) student.getTuitionFee());
            }
            System.out.println("----------------------------------------------------------------");
        }
    }

    // public List<Student> filterByCampusCode(String campusCode) {
    //     List<Student> sts = new ArrayList<>();

    //     for(int i = 0; i < students.size(); i++) {
    //         Student st = students.get(i);
    //         if(st.ge)
    //     }
    // }

}
