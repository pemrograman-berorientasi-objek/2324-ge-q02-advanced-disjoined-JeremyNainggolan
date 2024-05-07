package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public interface CourseService {
    void add(String _courseId, String _courseName, int _courseCredit, String _courseGrade);
    void courseOpen(String _courseId, String _courseYear, String _courseSemester, String _initialLecturer);
    void courseHistory(String _courseId);
    void print();
}
