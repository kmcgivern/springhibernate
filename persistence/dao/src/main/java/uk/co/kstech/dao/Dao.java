package uk.co.kstech.dao;

import java.io.Serializable;

/**
 * Created by Kieran on 23/03/2014.
 */
public interface Dao<T, ID extends Serializable> {

    void saveOrUpdate(T t);

    T load(ID id);

    void delete(T t);

}
