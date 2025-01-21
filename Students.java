import java.util.ArrayList;
import java.util.List;

public class Students {
    private String pathFile;
    private boolean isSaved;
    private ArrayList<Student> students = new ArrayList<>();

    public Students() {};

    public Students(String pathFile) {this.pathFile = pathFile;}

    public boolean isSaved() {return isSaved;}

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

    public void searchByName(String name) {
        for(int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getName().equals(name)) {
                System.out.println(st);
            }
        }
    }

    public void showAll() {
        for(int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            System.out.println(st);
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
