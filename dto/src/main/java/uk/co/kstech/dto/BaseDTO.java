package uk.co.kstech.dto;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Created by KMcGivern on 24/04/2014.
 */
public abstract class BaseDTO {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        BaseDTO rhs = (BaseDTO) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(id, rhs.id)
                .isEquals();
    }

}
