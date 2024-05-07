package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private static ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Course> courses = CourseServiceImpl.getCourses();
    private ArrayList<Enrollment> enrollments = EnrollmentServiceImpl.getEnrollments();

    public static ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void add(String _studentId, String _studentName, String _year, String _studyProgram) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(_studentId)) {
                found = true;
            }
        }

        if (!found) {
            Student student = new Student(_studentId, _studentName, _year, _studyProgram);
            students.add(student);
        }
    }

    @Override
    public void details(String _studentId) {
        String courseCode = "";
        String courseYear = "";
        ArrayList<Enrollment> enrs = new ArrayList<Enrollment>();
        enrs.addAll(enrollments);

        enrs.sort((e1, e2) -> e1.getCode().compareTo(e2.getCode()));
        enrs.sort((e1, e2) -> e1.getYear().compareTo(e2.getYear()));

        for (int i = 0; i < enrs.size(); i++) {
            for (int j = i + 1; j < enrs.size(); j++) {
                if (enrs.get(i).getNim().equals(_studentId) &&
                        enrs.get(j).getNim().equals(_studentId) &&
                        enrs.get(i).getCode().equals(enrs.get(j).getCode())) {
                    courseCode = enrs.get(i).getCode();
                    courseYear = enrs.get(i).getYear();
                }
            }
        }

        double totalGradePoints = 0.00;
        int totalCredits = 0;

        for (Enrollment enrollment : enrs) {
            if (enrollment.getNim().equals(_studentId)) {
                if (enrollment.getCode().equals(courseCode) && enrollment.getYear().equals(courseYear)) {
                    continue;
                } else {
                    String tempCode = enrollment.getCode();
                    int credits = 0;

                    for (Course course : courses) {
                        if (course.getCode().equals(tempCode)) {
                            totalCredits += course.getCredits();
                            credits = course.getCredits();
                        }
                    }

                    String grade = enrollment.getGrade();

                    switch (grade) {
                        case "A":
                            totalGradePoints += (credits * 4.00);
                            break;
                        case "AB":
                            totalGradePoints += (credits * 3.50);
                            break;
                        case "B":
                            totalGradePoints += (credits * 3.00);
                            break;
                        case "BC":
                            totalGradePoints += (credits * 2.50);
                            break;
                        case "C":
                            totalGradePoints += (credits * 2.00);
                            break;
                        case "D":
                            totalGradePoints += (credits * 1.00);
                            break;
                        case "E":
                            totalGradePoints += (credits * 0.00);
                            break;
                        case "None":
                            totalGradePoints += (credits * 0.00);
                            credits = 0;
                            break;
                    }
                }
            }
        }

        double IPK = totalGradePoints / totalCredits;

        for (Student student : students) {
            if (student.getId().equals(_studentId)) {
                System.out.print(student.toString() + "|");
                System.out.print(String.format("%.2f", IPK));
                System.out.println("|" + totalCredits);
            }
        }
    }

    @Override
    public void transcript(String _studentId) {
        details(_studentId);
        String courseCode = "";
        String courseYear = "";
        ArrayList<Enrollment> enrs = new ArrayList<Enrollment>();
        enrs.addAll(enrollments);

        enrs.sort((e1, e2) -> e1.getCode().compareTo(e2.getCode()));
        enrs.sort((e1, e2) -> e1.getYear().compareTo(e2.getYear()));

        for (int i = 0; i < enrs.size(); i++) {
            for (int j = i + 1; j < enrs.size(); j++) {
                if (enrs.get(i).getNim().equals(_studentId) &&
                        enrs.get(j).getNim().equals(_studentId) &&
                        enrs.get(i).getCode().equals(enrs.get(j).getCode())) {
                    courseCode = enrs.get(i).getCode();
                    courseYear = enrs.get(i).getYear();
                }
            }
        }

        for (Enrollment enrollment : enrs) {
            if (enrollment.getNim().equals(_studentId)) {
                if (!(enrollment.getCode().equals(courseCode) && enrollment.getYear().equals(courseYear))) {
                    System.out.println(enrollment.toString());
                }
            }
        }
    }

    @Override
    public void find(String _academicYear, String _semester) {
        ArrayList<String> studentId = new ArrayList<>();
        ArrayList<Integer> studentNumber = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getYear().equals(_academicYear) && enrollment.getSemester().equals(_semester)) {
                studentId.add(enrollment.getNim());
            }
        }

        for (int i = 0; i < studentId.size(); i++) {
            studentNumber.add(Integer.parseInt(studentId.get(i).substring(7)));
        }

        for (int i = 0; i < studentNumber.size(); i++) {
            if (studentNumber.get(i) % 2 != 0) {
                studentNumber.remove(i);
                studentId.remove(i);
            }
        }

        
    }

    public void bestStudent(String _bestStudent) {

    }

    @Override
    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void printBestStudent() {

    }
}
