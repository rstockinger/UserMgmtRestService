/* ***************************************************************************
 * Copyright (c) 2012 BearingPoint INFONOVA GmbH, Austria.
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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Embeddable
public class LastChange implements Serializable {

    /** Serial version UID. */
    private static final long serialVersionUID = 213592348756129L;

    /** The date and time of the last change. */
    private Date date;

    /** The user who did the last change. */
    private String user;

    /**
     * @return the date
     */
    @Column(name = "LAST_CHANGE_DATE", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getDate() {
        return this.date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * @return the user
     */
    @Column(name = "LAST_CHANGE_USER", nullable = false, length = User.MAX_USERNAME_LENGTH)
    public String getUser() {
        return this.user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(final String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)//
                .appendSuper(super.toString())//
                .append("date", getDate())
                .append("user", getUser())//
                .toString();
    }
}
