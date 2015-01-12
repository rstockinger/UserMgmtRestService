package at.reinisoft.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.ForeignKey;
import org.springframework.data.rest.core.annotation.RestResource;


@Entity
@Table(name = "USER_ROLE_PERMS")
@SequenceGenerator(name = AbstractEntity.SEQ_ID, sequenceName = "SEQ_USER_ROLE_PERMS", allocationSize = 1)
public class UserRolePermission extends AbstractEntity {

    private static final long serialVersionUID = -7309478009830124129L;


    @NotNull
    private UserRole userRole;

    @NotNull
    private UserPermission permission;


    /**
     * @return the userRole
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    @ForeignKey(name = "FK_USER_ROLE_ID")
    public UserRole getUserRole() {
        return this.userRole;
    }

    /**
     * @param userRole
     *            the userRole to set
     */
    public void setUserRole(final UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the permission
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "PERMISSION")
    public UserPermission getPermission() {
        return this.permission;
    }

    /**
     * @param permission
     *            the permission to set
     */
    public void setPermission(final UserPermission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)//
                .appendSuper(super.toString())//
                .append("permission", getPermission())//
                .toString();
    }
}
