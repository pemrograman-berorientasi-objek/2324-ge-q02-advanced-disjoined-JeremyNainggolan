package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class EnrollmentServiceImpl implements EnrollmentService {
    private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    private ArrayList<Course> courses = CourseServiceImpl.getCourses();
    private ArrayList<Student> students = StudentServiceImpl.getStudents();

    public static ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    @Override
    public void add(String _codeCourse, String _studentId, String _year, String _semester) {
        boolean courseExist = false;
        boolean studentExist = false;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(_codeCourse)) {
                courseExist = true;
                break;
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(_studentId)) {
                studentExist = true;
                break;
            }
        }

        boolean found = false;
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getCode().equals(_codeCourse) && enrollments.get(i).getId().equals(_studentId)
                    && enrollments.get(i).getYear().equals(_year)
                    && enrollments.get(i).getSemester().equals(_semester)) {
                found = true;
                break;
            }
        }

        if (courseExist && studentExist && !found) {
            Enrollment enrollment = new Enrollment(_codeCourse, _studentId, _year, _semester);
            enrollments.add(enrollment);
        }
    }

    @Override
    public void grade(String _courseCode, String _studentId, String _year, String _semester, String _grade) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getCode().equals(_courseCode) && enrollments.get(i).getNim().equals(_studentId)
                    && enrollments.get(i).getYear().equals(_year)
                    && enrollments.get(i).getSemester().equals(_semester)) {
                enrollments.get(i).setGrade(_grade);
            }
        }
    }

    @Override
    public void remedial(String _courseCode, String _studentId, String _year, String _semester, String _grade) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getCode().equals(_courseCode) && enrollments.get(i).getNim().equals(_studentId)
                    && enrollments.get(i).getYear().equals(_year)
                    && enrollments.get(i).getSemester().equals(_semester)) {
                if (enrollments.get(i).getGrade() != "None" && enrollments.get(i).getTempGrade() == "None") {
                    enrollments.get(i).setTempGrade(enrollments.get(i).getGrade());
                    enrollments.get(i).setGrade(_grade);
                }
            }
        }
    }

    @Override
    public void print() {
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}
