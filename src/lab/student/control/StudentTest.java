package lab.student.control;

import lab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student sd = new Student("2025001", "��μ�", "��ǻ�Ͱ���", 3);
        System.out.println(sd.getName() + " / " + sd.getMajor() + " / " + sd.getGrade() + "�г�");

        System.out.println("5�г����� ����");
        sd.setGrade(5);
	}

}
