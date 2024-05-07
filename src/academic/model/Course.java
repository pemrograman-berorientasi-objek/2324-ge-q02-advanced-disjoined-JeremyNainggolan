package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class Course extends Parent{
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private int credits;
    private String grade;

    public Course(String _code, String _name, int _credits, String _grade) {
        super(_code, _name);
        this.credits = _credits;
        this.grade = _grade;
    }

    public String getCode() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public int getCredits() {
        return this.credits;
    }

    public String getGrade() {
        return this.grade;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + getCredits() + "|" + getGrade();
    }
}
