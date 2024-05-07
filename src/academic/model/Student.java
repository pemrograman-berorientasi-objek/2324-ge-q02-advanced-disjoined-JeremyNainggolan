package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class Student extends Parent {
    private static ArrayList<Student> students = new ArrayList<Student>();
    private String year;
    private String studyProgram;

    public Student(String _nim, String _name, String _year, String _studyProgram) {
        super(_nim, _name);
        this.year = _year;
        this.studyProgram = _studyProgram;
        students.add(this);
    }

    public String getNim() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getYear() {
        return this.year;
    }

    public String getStudyProgram() {
        return this.studyProgram;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + getYear() + "|" + getStudyProgram();
    }
}