package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner sc;

    public StudentController(Scanner sc) {
        this.sc = sc;
    }

    private Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    private double inputGpa() {
        double gpa = -1;
        while (gpa < 0 || gpa > 4) {
            System.out.print("Nhập GPA (0 - 4): ");
            if (sc.hasNextDouble()) {
                gpa = sc.nextDouble();
            } else {
                System.out.println("Vui lòng nhập số!");
            }
            sc.nextLine();
        }
        return gpa;
    }
    
    public void addStudent() {
        System.out.print("Nhập mã sinh viên: ");
        String id = sc.nextLine();
        if (findById(id) != null) {
            System.out.println("Mã sinh viên đã tồn tại!");
            return;
        }
        System.out.print("Nhập họ tên: ");
        String fullName = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        double gpa = inputGpa();
        
        studentList.add(new Student(id, fullName, email, phone, gpa));
        System.out.println("Thêm sinh viên thành công!");
    }

    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        for (Student s : studentList) {
            s.displayData();
        }
    }

    public void searchStudentByName() {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                s.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào!");
        }
    }

    public void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        Student s = findById(sc.nextLine());
        if (s == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        studentList.remove(s);
        System.out.println("Xóa sinh viên thành công!");
    }

    public void updateStudentGpa() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        Student s = findById(sc.nextLine());
        if (s == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        s.setGpa(inputGpa());
        System.out.println("Cập nhật GPA thành công!");
    }

    public void sortStudentsByGpaDescending() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                if (studentList.get(j).getGpa() < studentList.get(j + 1).getGpa()) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp theo GPA giảm dần!");
        printStudentList();
    }
}