package uk.co.kstech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/**
 * Created by Kieran on 23/03/2014.
 */
public abstract class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {

    private Class<T> classType;

    private SessionFactory sessionFactory;

    public AbstractDao(final Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public void saveOrUpdate(final T t) {
        getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public T load(ID id) {
        return (T) getCurrentSession().load(classType, id);
    }

    @Override
    public void delete(final T t) {
        getCurrentSession().delete(t);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
