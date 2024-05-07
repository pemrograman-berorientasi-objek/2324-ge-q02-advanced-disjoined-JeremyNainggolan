package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

import java.util.ArrayList;

public class Lecturer extends Parent{
    private static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
    private String initial;
    private String email;
    private String studyProgram;


    public Lecturer(String _nidn, String _name, String _initial, String _email, String _studyProgram) {
        super(_nidn, _name);
        this.initial = _initial;
        this.email = _email;
        this.studyProgram = _studyProgram;
        lecturers.add(this);
    }

    public String getNidn() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getInitial() {
        return this.initial;
    }

    public String getEmail() {
        return this.email;
    }

    public String getStudyProgram() {
        return this.studyProgram;
    }

    public static ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + getInitial() + "|" + getEmail() + "|" + getStudyProgram();
    }
}
