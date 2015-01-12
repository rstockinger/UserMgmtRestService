package at.reinisoft.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.proxy.HibernateProxyHelper;


@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    /** The maximum length of discriminator. */
    public static final int DISCRIMINATOR_LENGTH = 40;

    /** The maximum length of name. */
    public static final int MAX_NAME_LENGTH = 255;

    /** The maximum length of description and descriptionInternal. (VARCHAR2 max.) */
    public static final int MAX_DESCRIPTION_LENGTH = 4000;

    /**
     * The default maximum length of strings to use for validations and columns
     * other than sidId, relationId, name, description, descriptionInternal or discriminator.
     */
    public static final int MAX_STRING_LENGTH = 255;

    /** The name for the sequence generator. */
    public static final String SEQ_ID = "seq_id";

    /** SerialVersionUid. */
    private static final long serialVersionUID = 1L;


    /** The id of the entity object. */
    private Long id; // NOPMD "id" is long enough and cannot be misunderstood.

    /**
     * @return the unique identifier of this entity
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id")
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            the unique identifier of this entity
     */
    public void setId(final Long id) { // NOPMD "id" is long enough and cannot be misunderstood.
        validateImmutableProperty("id", this.id, id);
        this.id = id;
    }

    /**
     * Equals Implementation according to the Hibernate Docu.
     * <p>
     * For all OPC-Entities the Database Id is a unique key which is immutable.
     *
     * @param other
     *            otherObject
     * @return boolean true/false
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof AbstractEntity)) {
            // it is not even a AbstractEntity
            // this check is necessary to prevent a findbug warning
            return false;
        }
        if (getId() == null) {
            // if there is no id we call super (address comparison)
            return super.equals(other);
        }
        // if the id is ones set, it is immutable (see #setId(...)).
        // So a save compare by id is possible.
        final Class<?> otherClass = HibernateProxyHelper.getClassWithoutInitializingProxy(other);
        if (otherClass != getClass()) {
            // it is not the same type
            // Two different subclasses may have the same id (because of different DB-Tables).
            return false;
        }

        final AbstractEntity castOther = (AbstractEntity) other;

        return new EqualsBuilder()//
        .append(getId(), castOther.getId()) //
        .isEquals();
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();
        }
        return new HashCodeBuilder().append(getId()).toHashCode();

    }

    @Override
    public String toString() {
        if (this.id == null) {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)//
            .toString();
        }
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)//
        .append("id", getId())//
        .toString();
    }

    /**
     * @param <T>
     *            The Type of new and old Value must be the same.
     * @param propertyName
     *            the propertyName for a nice Error Message.
     * @param oldValue
     *            old Value
     * @param newValue
     *            new Value
     */
    protected <T extends Serializable> void validateImmutableProperty(//
            final String propertyName, final T oldValue, final T newValue) {

        if (oldValue == null) {
            // set the initial Value is always ok.
            return;
        }
        if (oldValue.equals(newValue)) {
            // there is no change to the existing value.
            return;
        }

        // other cases:
        // an existing old value will be replaced by another new value which is not allowed for immutable properties.
        throw new IllegalArgumentException(String.format(//
                "The change of the immutable Property '%s.%s' from '%s' to '%s' is never allowed.", //
                getClass().getSimpleName(), propertyName, oldValue, newValue));
    }
}
