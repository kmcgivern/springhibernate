package uk.co.kstech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KMcGivern on 24/03/2014.
 */
public abstract class DomainObject implements Serializable {

    @Id
    protected Long id;

    public abstract Long getId();

    public abstract void setId(Long id);
}
