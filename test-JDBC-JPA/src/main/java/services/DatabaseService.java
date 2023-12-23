package services;

import models.Course;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

public interface DatabaseService {

    // C - добавление данных в таблицу
    void addData(Session session, AppView view, Course course) throws SQLException;

    Course readDataID(Session session, AppView view) throws SQLException;

    Collection<Course> readDataAll(Session session, AppView view) throws SQLException;

    void updateData(Session session, Course course) throws SQLException;

    void deleteDataID(Session session, Course course) throws SQLException;

    void deleteDataAll(Session session, AppView view) throws SQLException;
}