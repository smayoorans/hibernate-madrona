package com.madrona.hibernate.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private SessionFactory sessionFactory;

    protected Class clazz;

    public AbstractRepo(Class clazz) {
        this.clazz = clazz;
    }

    protected boolean save(final T object) {
        LOGGER.info("Inserting new {} to database [{}]", clazz.getSimpleName(), object);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            LOGGER.info("Successfully inserted new {} to database [{}]", clazz.getSimpleName(), object);
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while inserting {} information  [{}], [{}] ", clazz.getSimpleName(), object, ex);
            return false;
        }
    }

    protected T getById(final long id) {
        LOGGER.info("Retrieving {} details for id [{}]", clazz.getSimpleName(), id);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            @SuppressWarnings("unchecked")
//            T object = (T) session.load(clazz, id);
                    Criteria criteria = session.createCriteria(clazz).add(Restrictions.eq("id", id));
            @SuppressWarnings("unchecked")
            T object = (T) criteria.uniqueResult();
            session.getTransaction().commit();
            return object;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while retrieving {} details for id [{}], [{}]", clazz.getSimpleName(), id, ex);
            return null;
        }
    }

    protected boolean delete(final T object) {
        LOGGER.info("Deleting {} details from the database [{}]", clazz.getSimpleName(), object);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while deleting {} details from database, [{}]", clazz.getSimpleName(), ex);
            return false;
        }

    }

    protected boolean update(final T object) {
        LOGGER.info("Updating {} information with new information of [{}]", clazz.getSimpleName(), object);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            LOGGER.info("{} information with new information of [{}] has been successfully updated.", clazz.getSimpleName(), object);
            return true;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while updating the {} information [{}], [{}] ", clazz.getSimpleName(), object, ex);
            return false;
        }
    }


    protected List<T> getAll() {
        LOGGER.info("Retrieving all records of {} from  database.", clazz.getSimpleName());
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(clazz);
            @SuppressWarnings("unchecked")
            List<T> list = (List<T>) criteria.list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while retrieving records of [{}], [{}] ", clazz.getSimpleName(), ex);
            return new ArrayList<>();
        }

    }


    protected List<T> find(final String propertyName, final Object value) {
        LOGGER.info("Retrieving {} details for property [{}] and value [{}]", clazz.getSimpleName(), propertyName, value);
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(clazz).add(Restrictions.eq(propertyName, value));
            @SuppressWarnings("unchecked")
            List<T> list = (List<T>) criteria.list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException ex) {
            LOGGER.error("Error occurred while retrieving {} details for property [{}], [{}]", clazz.getSimpleName(), propertyName, ex);
            return null;
        }

    }
}
