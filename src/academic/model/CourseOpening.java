package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class CourseOpening extends Parent {
    private static ArrayList<CourseOpening> courseOpenings = new ArrayList<CourseOpening>();
    private String year;
    private String semester;
    private String initialLecturer;

    public CourseOpening(String _code, String _year, String _semester, String _initialLecturer) {
        super(_code);
        this.year = _year;
        this.semester = _semester;
        this.initialLecturer = _initialLecturer;
        courseOpenings.add(this);
    }

    public String getCode() {
        return super.getId();
    }

    public String getYear() {
        return this.year;
    }

    public String getSemester() {
        return this.semester;
    }

    public static ArrayList<CourseOpening> getCourseOpenings() {
        return courseOpenings;
    }

    public String getInitialLecturer() {
        return this.initialLecturer;
    }
}