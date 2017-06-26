package user.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Transactional
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Basic
    private String name;

    @Basic
    private int age;

    @Basic
    private Boolean isAdmin = false;

    @Basic
    private Date createdDate = Calendar.getInstance().getTime();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean done) {
        this.isAdmin = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
