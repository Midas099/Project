package atl.academy.coursemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "login_id", length = 11)
    private int loginid;

    @Column(name = "role_id", length = 11)
    private int roleid;

    @Column(name = "username", length = 45)
    private String username;

    @Column(name = "password", length = 45)
    private String password;

    public Login() {
    }

    public Login(int loginid, int roleid, String username, String password) {
        this.loginid = loginid;
        this.roleid = roleid;
        this.username = username;
        this.password = password;
    }

    public Login(int roleid, String username, String password) {
        this.roleid = roleid;
        this.username = username;
        this.password = password;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginid=" + loginid +
                ", roleid=" + roleid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
