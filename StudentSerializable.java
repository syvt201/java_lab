import java.io.Serializable;

public class StudentSerializable implements Serializable{
    private String id;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tuitionFee;

    public StudentSerializable() {
    }

    public StudentSerializable(String id, String name, String phone, String email, String mountainCode, double tuitionFee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public StudentSerializable(Student std) {
        this.id = std.getId();
        this.name = std.getName();
        this.phone = std.getPhone();
        this.email = std.getEmail();
        this.mountainCode = std.getMountainCode();
        this.tuitionFee = std.getTuitionFee();
    }

    @Override
    public String toString() { 
        return String.format("Student[id=%s, name=%s, phone=%s, email=%s, mountainCode=%s, tuitionFee=%.2f]", id, name, phone, email, mountainCode, tuitionFee); }
}
