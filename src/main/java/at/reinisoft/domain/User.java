package at.reinisoft.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "USERS")
@SequenceGenerator(name = AbstractEntity.SEQ_ID, sequenceName = "SEQ_USERS", allocationSize = 1)
public class User extends AbstractEntity {

    /** The serial version UID. */
    private static final long serialVersionUID = 8941345488577177897L;

    /** Maximum length for ... */
    public static final int MAX_FIRSTNAME_LENGTH = MAX_STRING_LENGTH;

    /** Maximum length for ... */
    public static final int MAX_LASTNAME_LENGTH = MAX_STRING_LENGTH;

    /** Maximum length for ... */
    public static final int MAX_USERNAME_LENGTH = MAX_STRING_LENGTH;


    private Set<UserRole> userRoles = new HashSet<UserRole>();

    @NotBlank
    @Length(max = MAX_USERNAME_LENGTH)
    private String username;

    @Length(max = MAX_STRING_LENGTH)
    private String password;

    @Length(max = MAX_FIRSTNAME_LENGTH)
    private String firstname;

    @Length(max = MAX_LASTNAME_LENGTH)
    private String lastname;

    @Email
    @Length(max = MAX_STRING_LENGTH)
    private String email;

    @NotNull
    private AuthenticationType authenticationType = AuthenticationType.LDAP;


    private LastChange lastChange;

    private boolean activated;

    private boolean internalUser;

    private Date lastLogin;

    @Length(max = MAX_DESCRIPTION_LENGTH)
    private String descriptionInternal;


    /**
     * @return the descriptionInternal.
     */
    @Column(name = "DESCRIPTION_INTERNAL", length = MAX_DESCRIPTION_LENGTH)
    public String getDescriptionInternal() {
        return this.descriptionInternal;
    }

    /**
     * @param descriptionInternal
     *            the descriptionInternal to set.
     */
    public void setDescriptionInternal(final String descriptionInternal) {
        this.descriptionInternal = descriptionInternal;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName="ID"), inverseJoinColumns = @JoinColumn(name = "USER_ROLE_ID", referencedColumnName="ID"))
    @ForeignKey(name = "FK_USER_ROLES_USER_ID", inverseName = "FK_USER_ROLES_USR_ROLE_ID")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }


    public void setUserRoles(final Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * @return the authorizationType
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "AUTHORIZATION_TYPE")
    public AuthenticationType getAuthenticationType() {
        return this.authenticationType;
    }

    /**
     * @param authenticationType
     *            the authorizationType to set
     */
    public void setAuthenticationType(final AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * @return the username
     */
    @Column(name = "USERNAME", unique = true)
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    @Column(name = "PASSWORD")
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the firstname
     */
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * @param firstname
     *            the firstname to set
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    @Column(name = "LASTNAME")
    public String getLastname() {
        return this.lastname;
    }

    /**
     * @param lastname
     *            the lastname to set
     */
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the email
     */
    @Column(name = "EMAIL")
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return lastChange
     */
    @Embedded
    public LastChange getLastChange() {
        if (this.lastChange == null) {
            this.lastChange = new LastChange();
        }
        return this.lastChange;
    }

    /**
     * @param lastChange
     *            lastChange
     */
    public void setLastChange(final LastChange lastChange) {
        this.lastChange = lastChange;
    }

    /**
     * @return the activated
     */
    @Column(name = "ACTIVATED")
    public boolean isActivated() {
        return this.activated;
    }

    /**
     * @param activated
     *            the activated to set
     */
    public void setActivated(final boolean activated) {
        this.activated = activated;
    }

    /**
     * @return the internalUser
     */
    @Column(name = "INTERNAL_USER", nullable = false)
    public boolean isInternalUser() {
        return this.internalUser;
    }

    /**
     * @param internalUser
     *            the internalUser to set
     */
    public void setInternalUser(final boolean internalUser) {
        this.internalUser = internalUser;
    }

    /**
     * @return the lastLogin.
     */
    @Column(name = "LAST_LOGIN")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getLastLogin() {
        return this.lastLogin;
    }

    /**
     * @param lastLogin
     *            the lastLogin to set.
     */
    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * The full name is the firstname followed by a space followed by the lastname. If one of these two is {@code null}
     * only the other one is returned. If both are {@code null} an empty string is returned.
     *
     * @return the full name of the user.
     */
    @Transient
    public String getFullname() {
        if (this.firstname == null && this.lastname == null) {
            return StringUtils.EMPTY;
        }

        if (this.firstname == null) {
            return this.lastname;
        } else if (this.lastname == null) {
            return this.firstname;
        }

        return new StringBuilder()//
                .append(this.firstname)//
                .append(" ")//
                .append(this.lastname)//
                .toString();
    }
}
