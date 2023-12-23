package services;

import models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class MySQLServiceImplement implements DatabaseService {

    protected SessionFactory sessionFactory;

    public MySQLServiceImplement() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * C - добавить
     */
    public void addData(Session session, AppView view, Course course) throws SQLException {
        session.beginTransaction();
        session.persist(course);
        session.getTransaction().commit();
    }

    /**
     * R - получить по ID
     */
    @Override
    public Course readDataID(Session session, AppView view) throws SQLException {
        session.beginTransaction();
        Course course = session.get(Course.class, view.inputID());
        session.getTransaction().commit();
        return course;
    }

    /**
     * R_all - получить всё
     */
    @Override
    public List<Course> readDataAll(Session session, AppView view) throws SQLException {
        List<Course> courseList = session.createQuery("SELECT data FROM Course data", Course.class).getResultList();
        if (courseList.size() == 0) {
            view.emptyMessage();
        }
        return courseList;
    }

    /**
     * U - обновить по ID
     */
    @Override
    public void updateData(Session session, Course course) throws SQLException {
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
    }

    /**
     * D - удалить по ID
     */
    @Override
    public void deleteDataID(Session session, Course course) throws SQLException {
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
    }

    /**
     * D_all - удалить всё
     */
    @Override
    public void deleteDataAll(Session session, AppView view) throws SQLException {
        session.beginTransaction();
        List<Course> courseList = readDataAll(session, view);
        for (Course course : courseList) {
            session.delete(course);
        }
        session.getTransaction().commit();
    }
}