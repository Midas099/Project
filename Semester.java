package atl.academy.coursemanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "semester_id", length = 11)
    private int semesterid;

    @Column(name = "semester_name", length = 45)
    private String semestername;

    @Column(name = "start_date", length = 12)
    private String startdate;

    @Column(name = "end_date", length = 12)
    private String enddate;

    @OneToMany(mappedBy = "semester")
    private Set<Course> courses;

    public Semester() {
    }

    public Semester(int semesterid, String semestername, String startdate, String enddate, Set<Course> courses) {
        this.semesterid = semesterid;
        this.semestername = semestername;
        this.startdate = startdate;
        this.enddate = enddate;
        this.courses = courses;
    }

    public Semester(String semestername, String startdate, String enddate, Set<Course> courses) {
        this.semestername = semestername;
        this.startdate = startdate;
        this.enddate = enddate;
        this.courses = courses;
    }

    public Semester(String semestername, String startdate, String enddate) {
        this.semestername = semestername;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public int getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(int semesterid) {
        this.semesterid = semesterid;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterid=" + semesterid +
                ", semestername='" + semestername + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", courses=" + courses +
                '}';
    }
}