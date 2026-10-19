package Student;
public class Student {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private double gpa;
    
    public Student() {
    }

    public Student (String id, String fullName, String email, String phone, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void displayData() {
        System.out.println("ID: " + id + " | Họ tên: " + fullName + " | Email: " + email + " | SĐT: " + phone + " | GPA: " + gpa);
    }
}
