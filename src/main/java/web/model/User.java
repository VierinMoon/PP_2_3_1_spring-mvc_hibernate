package web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surmane;

    @Column(name="age")
    private Integer age;

    public User() {
    }

    public User(String name, String surmane, Integer age) {
        this.name = name;
        this.surmane = surmane;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setSurmane(String surmane) {
        this.surmane = surmane;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surmane, user.surmane) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surmane, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surmane='" + surmane + '\'' +
                ", age=" + age +
                '}';
    }
}