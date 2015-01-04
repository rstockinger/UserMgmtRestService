package at.reinisoft.domain;

import javax.persistence.*;

/**
 * Created by stocki on 04.01.15.
 */
@Entity
public class User {

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Title title;

    public String getFirstName() {
        return firstName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
