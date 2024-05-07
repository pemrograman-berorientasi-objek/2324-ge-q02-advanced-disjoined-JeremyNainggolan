package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class AcademicSimulator {
    private CourseServiceImpl courseService = new CourseServiceImpl();
    private StudentServiceImpl studentService = new StudentServiceImpl();
    private EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl();
    private LectureServiceImpl lectureService = new LectureServiceImpl();

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            String input = Input.input();
            String[] inputArray = input.split("#");
            String command = inputArray[0];
            switch (command) {
                case "---":
                    lecturePrint();
                    coursePrint();
                    studentPrint();
                    enrollmentPrint();
                    bestStudentPrint();
                    isRunning = false;
                    break;
                case "course-add":
                    courseAdd(input);
                    break;
                case "course-open":
                    courseOpen(input);
                    break;
                case "course-history":
                    courseHistory(input);
                    break;
                case "student-add":
                    studentAdd(input);
                    break;
                case "student-details":
                    studentDetails(input);
                    break;
                case "student-transcript":
                    studentTranscript(input);
                    break;
                case "find-the-best-student":
                    findStudent(input);
                    break;
                case "add-best-student":
                    addBestStudent(input);
                    break;
                case "lecturer-add":
                    lecturerAdd(input);
                    break;
                case "enrollment-add":
                    enrollmentAdd(input);
                    break;
                case "enrollment-grade":
                    enrollmentGrade(input);
                    break;
                case "enrollment-remedial":
                    enrollmentRemedial(input);
                    break;
            }
        }
    }

    public void courseAdd(String _input) {
        String[] inputArray = _input.split("#");
        courseService.add(inputArray[1], inputArray[2], Integer.parseInt(inputArray[3]), inputArray[4]);
    }

    public void courseOpen(String _input) {
        String[] inputArray = _input.split("#");
        courseService.courseOpen(inputArray[1], inputArray[2], inputArray[3], inputArray[4]);
    }

    public void courseHistory(String _input) {
        String[] inputArray = _input.split("#");
        courseService.courseHistory(inputArray[1]);
    }

    public void coursePrint() {
        courseService.print();
    }    

    public void studentAdd(String _input) {
        String[] inputArray = _input.split("#");
        studentService.add(inputArray[1], inputArray[2], inputArray[3], inputArray[4]);
    }

    public void studentDetails(String _input) {
        String[] inputArray = _input.split("#");
        studentService.details(inputArray[1]);
    }

    public void studentTranscript(String _input) {
        String[] inputArray = _input.split("#");
        studentService.transcript(inputArray[1]);
    }

    public void findStudent(String _input) {
        String[] inputArray = _input.split("#");
        studentService.find(inputArray[1], inputArray[2]);
    }

    public void addBestStudent(String _input) {
        String[] inputArray = _input.split("#");
        studentService.bestStudent(inputArray[1]); 
    }

    public void studentPrint() {
        studentService.print();
    }

    public void bestStudentPrint() {
        studentService.printBestStudent();
    }

    public void lecturerAdd(String _input) {
        String[] inputArray = _input.split("#");
        lectureService.add(inputArray[1], inputArray[2], inputArray[3], inputArray[4], inputArray[5]);
    }

    public void lecturePrint() {
        lectureService.print();
    }

    public void enrollmentAdd(String _input) {
        String[] inputArray = _input.split("#");
        enrollmentService.add(inputArray[1], inputArray[2], inputArray[3], inputArray[4]);
    }

    public void enrollmentGrade(String _input) {
        String[] inputArray = _input.split("#");
        enrollmentService.grade(inputArray[1], inputArray[2], inputArray[3], inputArray[4], inputArray[5]);
    }

    public void enrollmentRemedial(String _input) {
        String[] inputArray = _input.split("#");
        enrollmentService.remedial(inputArray[1], inputArray[2], inputArray[3], inputArray[4], inputArray[5]);
    }

    public void enrollmentPrint() {
        enrollmentService.print();
    }
}
