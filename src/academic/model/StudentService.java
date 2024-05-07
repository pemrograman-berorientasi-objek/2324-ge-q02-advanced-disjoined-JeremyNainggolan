package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public interface StudentService {
    void add(String _studentId, String _studentName, String _studentYear, String _studentStudyProgram);
    void details(String _studentId);
    void transcript(String _studentId);
    void find(String _academicYear, String _semester);
    void bestStudent(String _bestStudent);
    void print();
    void printBestStudent();
}
