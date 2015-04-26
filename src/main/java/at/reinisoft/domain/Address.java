package at.reinisoft.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by stocki on 04.01.15.
 */
@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = AbstractEntity.SEQ_ID, sequenceName = "SEQ_ADDRESS", allocationSize = 1)
public class Address extends AbstractEntity{

    /** The serial version UID. */
    private static final long serialVersionUID = 8941345488577177897L;

    /** Maximum length for ... */
    public static final int MAX_CITY_LENGTH = MAX_STRING_LENGTH;

    /** Maximum length for ... */
    public static final int MAX_STREET_LENGTH = MAX_STRING_LENGTH;

    /** Maximum length for ... */
    public static final int MAX_POSTAL_CODE_LENGTH = MAX_STRING_LENGTH;

    /** Maximum length for ... */
    public static final int MAX_STATE_OR_PROVINCE_LENGTH = MAX_STRING_LENGTH;

    @Length(max = MAX_STREET_LENGTH)
    private String street;

    private Integer streetNumber;

    @Length(max = MAX_POSTAL_CODE_LENGTH)
    private String postalCode;

    private String country;

    @Length(max = MAX_CITY_LENGTH)
    private String city;

    @Length(max = MAX_STATE_OR_PROVINCE_LENGTH)
    private String stateOrProvince;

    private String postalScheme;

    public String getPostalCode() {
        return postalCode;
    }

    public String getPostalScheme() {
        return postalScheme;
    }

    public void setPostalScheme(String postalScheme) {
        this.postalScheme = postalScheme;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postalCode;
    }

    public void setPostcode(String postcode) {
        this.postalCode = postcode;
    }

}