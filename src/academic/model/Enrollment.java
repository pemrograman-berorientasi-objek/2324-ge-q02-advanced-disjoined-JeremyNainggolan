package academic.model;

import java.util.ArrayList;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class Enrollment extends Parent{
    private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    private String year;
    private String semester;
    private String grade = "None";
    private String tempGrade = "None";

    public Enrollment(String _code, String _nim, String _year, String _semester) {
        super(_code, _nim);
        this.year = _year;
        this.semester = _semester;
        enrollments.add(this);
    }

    public String getCode() {
        return super.getId();
    }

    public String getNim() {
        return super.getName();
    }

    public String getYear() {
        return this.year;
    }

    public String getSemester() {
        return this.semester;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getTempGrade() {
        return this.tempGrade;
    }

    public void setGrade(String _grade) {
        this.grade = _grade;
    }

    public void setTempGrade(String _tempGrade) {
        this.tempGrade = _tempGrade;
    }

    public static ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    @Override
    public String toString() {
        if (getTempGrade() == "None"){
            return super.toString() + "|" + getYear() + "|" + getSemester() + "|" + getGrade();
        } else {
            return super.toString() + "|" + getYear() + "|" + getSemester() + "|" + getGrade() + "(" + getTempGrade() + ")";
        }
    }
}