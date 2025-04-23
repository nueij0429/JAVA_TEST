package lab.student.control;

import lab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student sd = new Student("2025001", "김민수", "컴퓨터공학", 3);
        System.out.println(sd.getName() + " / " + sd.getMajor() + " / " + sd.getGrade() + "학년");

        System.out.println("5학년으로 변경");
        sd.setGrade(5);
	}

}
