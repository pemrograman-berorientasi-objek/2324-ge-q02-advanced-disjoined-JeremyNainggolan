package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public interface EnrollmentService {
    void add(String _codeCourse, String _studentId, String _year, String _semester);
    void grade(String _courseCode, String _studentId, String _year, String _semester, String _grade);
    void remedial(String _courseCode, String _studentId, String _year, String _semester, String _grade);
    void print();
}
