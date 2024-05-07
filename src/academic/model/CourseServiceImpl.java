package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseServiceImpl implements CourseService {
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private static ArrayList<CourseOpening> courseOpenings = new ArrayList<CourseOpening>();
    private ArrayList<Lecturer> lecturers = LectureServiceImpl.getLecturers();
    private ArrayList<Enrollment> enrollments = EnrollmentServiceImpl.getEnrollments();

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static ArrayList<CourseOpening> getCourseOpenings() {
        return courseOpenings;
    }

    @Override
    public void add(String _courseCode, String _courseName, int _credit, String _grade) {
        boolean found = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(_courseCode)) {
                found = true;
                break;
            }
        }

        if (!found) {
            Course course = new Course(_courseCode, _courseName, _credit, _grade);
            courses.add(course);
        }
    }

    @Override
    public void courseOpen(String _courseCode, String _year, String _semester, String _initialLecturer) {
        boolean courseExist = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(_courseCode)) {
                courseExist = true;
            }
        }

        boolean lecturerExist = false;
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getInitial().equals(_initialLecturer)) {
                lecturerExist = true;
            }
        }

        if (courseExist && lecturerExist) {
            CourseOpening courseOpening = new CourseOpening(_courseCode, _year, _semester, _initialLecturer);
            courseOpenings.add(courseOpening);
        }
    }

    @Override
    public void courseHistory(String _courseCode) {
        Collections.sort(courseOpenings, crsOpn);
        String initLect = "";
        String output = "";
        String lecturerDetail = "";
        for (int i = 0; i < courseOpenings.size(); i++) {
            if (courseOpenings.get(i).getCode().equals(_courseCode)) {
                initLect = courseOpenings.get(i).getInitialLecturer();
            }
        }

        String[] splitLect = initLect.split(",");
        for (int i = 0; i < splitLect.length; i++) {
            for (int j = 0; j < lecturers.size(); j++) {
                if (lecturers.get(j).getInitial().equals(splitLect[i])) {
                    lecturerDetail = lecturerDetail
                            .concat(String.format("%s (%s)", splitLect[i], lecturers.get(j).getEmail()));
                    if (i < splitLect.length - 1) {
                        lecturerDetail += ";";
                    }
                }
            }
        }

        for (int i = 0; i < courseOpenings.size(); i++) {
            if (courseOpenings.get(i).getCode().equals(_courseCode)) {
                for (Course course : courses) {
                    if (course.getCode().equals(_courseCode)) {
                        output = String.format("%s|%s|%d|%s|%s|%s|%s", courseOpenings.get(i).getCode(),
                                course.getName(), course.getCredits(), course.getGrade(),
                                courseOpenings.get(i).getYear(),
                                courseOpenings.get(i).getSemester(), lecturerDetail);
                        System.out.println(output);
                        for (int j = 0; j < enrollments.size(); j++) {
                            if (enrollments.get(j).getCode().equals(course.getCode())
                                    && enrollments.get(j).getYear().equals(courseOpenings.get(i).getYear())
                                    && enrollments.get(j).getSemester().equals(courseOpenings.get(i).getSemester())) {
                                System.out.println(enrollments.get(j));
                            }
                        }
                    }
                }
            }
        }
    }

    Comparator<CourseOpening> crsOpn = new Comparator<CourseOpening>() {
        @Override
        public int compare(CourseOpening c1, CourseOpening c2) {
            return c2.getSemester().compareTo(c1.getSemester());
        }
    };

    @Override
    public void print() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
