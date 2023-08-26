import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentManagement management = new StudentManagement();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Quản lý học sinh");
			System.out.println("1. Thêm học sinh");
			System.out.println("2. Cập nhật điểm");
			System.out.println("3. Xóa học sinh");
			System.out.println("4. Xem danh sách theo lớp");
			System.out.println("5. Xem danh sách học sinh");
			System.out.println("6. Sắp xếp theo tên");
			System.out.println("7. Sắp xếp theo tuổi");
			System.out.println("8. Sắp xếp theo điểm");
			System.out.println("9. Thoát");
			System.out.print("Mời nhập lựa chọn: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.print("Nhập id: ");
				String id = scanner.nextLine();
				scanner.nextLine();
				System.out.print("Nhập tên: ");
				String name = scanner.nextLine();
				System.out.print("Nhập tuổi: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Nhập địa chỉ: ");
				String address = scanner.nextLine();
				System.out.print("Nhập điểm: ");
				double point = scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Nhập lớp: ");
				String classroom = scanner.nextLine();
				management.addStudent(new Student(id, name, age, address, point, classroom));
				System.out.println("Đã thêm thông tin học sinh.");
				break;
			case 2:
				System.out.print("Nhập id của học sinh cần cập nhật điểm: ");
				String studentId = scanner.nextLine();
				System.out.print("Nhập điểm: ");
				double newPoint = scanner.nextDouble();
				management.updatePoint(studentId, newPoint);
				System.out.println("Điểm đã được cập nhật.");
				break;
			case 3:
				System.out.print("Nhập id của học sinh cần xóa: ");
				String studentToRemove = scanner.nextLine();
				management.removeStudent(studentToRemove);
				System.out.println("Đã xóa thông tin học sinh.");
				break;
			case 4:
				System.out.print("Nhập lớp: ");
				String classToView = scanner.nextLine();
				List<Student> classStudents = management.getStudentsByClass(classToView);
				for (Student student : classStudents) {
					System.out.println(student);
				}
				break;
			case 5:
				management.displayStudents();
				break;
			case 6:
				management.sortByName();
				System.out.println("Sắp xếp theo tên.");
				break;
			case 7:
				management.sortByAge();
				System.out.println("Sắp xếp theo tuổi.");
				break;
			case 8:
				management.sortByPoint();
				System.out.println("Sắp xếp theo điểm.");
				break;
			case 9:
				System.out.println("Đang thoát ... ");
				System.exit(0);
				break;
			default:
				System.out.println("Lựa chọn không phù hợp. Mời bạn chọn lại");
			}
		}
	}
}