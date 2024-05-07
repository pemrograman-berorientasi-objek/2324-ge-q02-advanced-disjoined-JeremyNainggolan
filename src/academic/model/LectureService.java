package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public interface LectureService {
    void add(String _lectureId, String _lectureName, String _lectureInitial, String _lectureEmail, String _lectureStudyProgram);
    void print();
}
