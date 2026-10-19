package Student;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController(scanner);
        int choice;
        while(true){
            System.out.println("-------------------------------------------------");
            System.out.println("        HỆ THỐNG QUẢN LÝ SINH VIÊN");
            System.out.println("-------------------------------------------------");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Cập nhật điểm GPA theo mã sinh viên");
            System.out.println("5. Xóa sinh viên theo mã sinh viên");
            System.out.println("6. Sắp xếp danh sách sinh viên theo GPA giảm dần");
            System.out.println("7. Thoát chương trình");
            System.out.println("-------------------------------------------------");
            System.out.print("Vui lòng chọn chức năng (1-7): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                choice = 0;
            }
            scanner.nextLine();

            switch(choice){
                case 1:
                    controller.addStudent();
                    break;
                 case 2:
                    controller.printStudentList();
                    break;
                 case 3:
                    controller.searchStudentByName();
                    break;
                 case 4:
                    controller.updateStudentGpa();
                    break;
                 case 5:
                    controller.deleteStudent();
                    break;
                case 6:
                    controller.sortStudentsByGpaDescending();
                    break;
                case 7:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số từ 1 đến 7");
                    break;
            }

            if(choice == 7){
                break;
            }
        }
        scanner.close();
    }
}
