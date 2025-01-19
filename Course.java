package atl.academy.coursemanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", length = 11)
    private int courseid;

    @Column(name = "course_name", length = 45)
    private String coursename;

    @Column(name = "syllabus", length = 60)
    private String syllabus;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    public Course() {
    }

    public Course(int courseid, String coursename, String syllabus, Semester semester) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.semester = semester;
    }

    public Course(String coursename, String syllabus, Semester semester) {
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.semester = semester;
    }

    public Course(String coursename, String syllabus) {
        this.coursename = coursename;
        this.syllabus = syllabus;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", semester=" + semester +
                '}';
    }
}
