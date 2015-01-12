package at.reinisoft.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by stocki on 04.01.15.
 */
@Entity
public class UserLite {

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

    @OneToOne @MapsId
    private Address userAddress;

    @OneToMany(orphanRemoval=true) @MapsId
    private List<Address> shippingAddresses;

    public List<Address> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<Address> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public Address getUserAddress() {
        return userAddress;

    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

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
