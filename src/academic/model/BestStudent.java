package academic.model;

public class BestStudent {

    private String studentId;
    private String evenGrade; // genap
    private String oddGrade; // ganjil


    public BestStudent(String _studentId) {
        this.studentId = _studentId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setEven(String _grade) {
        this.evenGrade = _grade;
    }

    public void setOdd(String _grade) {
        this.oddGrade = _grade;
    }

    public String getEven() {
        return this.evenGrade;
    }

    public String getOdd() {
        return this.oddGrade;
    }

    public String toString() {
        return getStudentId() + "|" + getOdd() + "/" + getEven();
    }

}
