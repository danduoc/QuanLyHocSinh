import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
	private List<Student> students;

	public StudentManagement() {
		students = new ArrayList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void updatePoint(String studentId, double newPoint) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				student.setPoint(newPoint);
				return;
			}
		}
		System.out.println("Không tìm thấy học sinh");
	}

	public void removeStudent(String studentId) {
		students.removeIf(student -> student.getId() == studentId);
	}

	public List<Student> getStudentsByClass(String classroom) {
		List<Student> filteredStudents = new ArrayList<>();
		for (Student student : students) {
			if (student.getClassroom().equals(classroom)) {
				filteredStudents.add(student);
			}
		}
		return filteredStudents;
	}

	public void displayStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void sortByName() {
		Collections.sort(students, Comparator.comparing(Student::getName));
	}

	public void sortByAge() {
		Collections.sort(students, Comparator.comparingInt(Student::getAge));
	}

	public void sortByPoint() {
		Collections.sort(students, Comparator.comparingDouble(Student::getPoint).reversed());
	}
}
