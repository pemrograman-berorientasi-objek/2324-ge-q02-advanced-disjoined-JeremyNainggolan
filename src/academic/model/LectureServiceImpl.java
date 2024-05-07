package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class LectureServiceImpl implements LectureService {
    private static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

    public static ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public void add(String _lectureId, String _lectureName, String _lectureInitial, String _lectureEmail, String _lectureStudyProgram) {
        boolean found = false;
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getId().equals(_lectureId)) {
                found = true;
                break;
            }
        }

        if (!found) {
            Lecturer lecturer = new Lecturer(_lectureId, _lectureName, _lectureInitial, _lectureEmail, _lectureStudyProgram);
            lecturers.add(lecturer);
        }
    }

    @Override
    public void print() {
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }
}
