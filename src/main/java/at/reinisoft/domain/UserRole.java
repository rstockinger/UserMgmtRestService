/* ***************************************************************************
 * Copyright (c) 2013 BearingPoint INFONOVA GmbH, Austria.
 *
 * This software is the confidential and proprietary information of
 * BearingPoint INFONOVA GmbH, Austria. You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with INFONOVA.
 *
 * BEARINGPOINT INFONOVA MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR
 * A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BEARINGPOINT INFONOVA SHALL
 * NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *****************************************************************************/

package at.reinisoft.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.rest.core.annotation.RestResource;


@Entity
@Table(name = "USER_ROLES")
@SequenceGenerator(name = AbstractEntity.SEQ_ID, sequenceName = "SEQ_USER_ROLES", allocationSize = 1)
public class UserRole extends AbstractEntity {

    /** SerialVersionUID. */
    private static final long serialVersionUID = -7816014282941911309L;


    private String name;

    @Length(max = MAX_DESCRIPTION_LENGTH)
    private String description;

    @Length(max = MAX_DESCRIPTION_LENGTH)
    private String descriptionInternal;

    private Set<UserRolePermission> rolePermissions = new HashSet<UserRolePermission>();

    private Set<User> users = new HashSet<User>();

    private Boolean isDefault;


    /**
     * @return name.
     */
    @Column(name = "NAME", unique = true, nullable = false)
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            the name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the description.
     */
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            the description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return the rolePermissions.
     */
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    public Set<UserRolePermission> getRolePermissions() {
        return this.rolePermissions;
    }

    /**
     * @param rolePermissions
     *            the rolePermissions to set.
     */
    public void setRolePermissions(final Set<UserRolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    /**
     * @return the users.
     */
    @ManyToMany(mappedBy = "userRoles", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return this.users;
    }

    /**
     * @param users
     *            the users to set.
     */
    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    /**
     * @return the descriptionInternal
     */
    @Column(name = "DESCRIPTION_INTERNAL", length = MAX_DESCRIPTION_LENGTH)
    public String getDescriptionInternal() {
        return this.descriptionInternal;
    }

    /**
     * @param descriptionInternal
     *            the descriptionInternal to set
     */
    public void setDescriptionInternal(final String descriptionInternal) {
        this.descriptionInternal = descriptionInternal;
    }

    /**
     * @return the isDefault
     */
    @Column(name = "IS_DEFAULT")
    public Boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * @param isDefault
     *            the isDefault to set
     */
    public void setIsDefault(final Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)//
        .appendSuper(super.toString())//
        .append("name", getName())//
        .toString();
    }
}
