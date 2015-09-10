package com.madrona.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for all Data Access Object Operations
 *
 * @param <T>
 * @author Mayooran
 */


public abstract class AbstractRepo<T extends Serializable> implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(AbstractRepo.class);


    protected T object;
    protected Class clazz;

    public AbstractRepo(Class clazz) {
        this.clazz = clazz;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(builder.build());
    }

    public static Employee findByID(Integer id) {
        Session session = getSessionFactory().openSession();
        Employee e = (Employee) session.load(Employee.class, id);
        session.close();
        return e;
    }

    private Session getHibernateSession() {
        return getSessionFactory().openSession();
    }

    protected boolean save(final T object) {
        LOGGER.info("Inserting new {} to database [{}]", clazz.getSimpleName(), object);
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            LOGGER.info("Successfully inserted new {} to database [{}]", clazz.getSimpleName(), object);
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while inserting {} information  [{}], [{}] ", clazz.getSimpleName(), object, ex);
            return false;
        } finally {
            session.close();
        }
    }

    protected T getById(final long id) {
        Session session = getSessionFactory().openSession();

        LOGGER.info("Retrieving {} details for id [{}]", clazz.getSimpleName(), id);
        try {
            @SuppressWarnings("unchecked")
            T object = (T) session.load(clazz, id);
            return object;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while retrieving {} details for id [{}], [{}]", clazz.getSimpleName(), id, ex);
            return null;
        }
    }

    protected boolean delete(final T object) {
        LOGGER.info("Deleting {} details from the database [{}]", clazz.getSimpleName(), object);
        try {
            getHibernateSession().delete(object);
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while deleting {} details from database, [{}]", clazz.getSimpleName(), ex);
            return false;
        }

    }

    protected boolean update(final T object) {
        LOGGER.info("Updating {} information with new information of [{}]", clazz.getSimpleName(), object);
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            getHibernateSession().update(object);
            session.getTransaction().commit();
            LOGGER.info("{} information with new information of [{}] has been successfully updated.", clazz.getSimpleName(), object);
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while updating the {} information [{}], [{}] ", clazz.getSimpleName(), object, ex);
            return false;
        } finally {
            session.close();
        }
    }


    protected List<T> getAll() {
        LOGGER.info("Retrieving all records of {} from  database.", clazz.getSimpleName());
        Session session = getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(clazz);
            return (List<T>) criteria.list();
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while retrieving records of [{}], [{}] ", clazz.getSimpleName(), ex);
            return new ArrayList<>();
        } finally {
            session.close();
        }

    }


    protected List<T> find(final String propertyName, final Object value) {
        Criteria criteria = getHibernateSession().createCriteria(clazz)
                .add(Restrictions.eq(propertyName, value));
        return criteria.list();
    }
}
