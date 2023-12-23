package services;

import models.Course;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class AppController {
    MySQLServiceImplement connector;
    AppView view;

    public AppController() {
        this.connector = new MySQLServiceImplement();
        view = new AppView();
    }

    public void handlingController() {
        try (Session session = connector.getSessionFactory().openSession()) {
            boolean flag = true;
            while (flag) {
                view.viewMenu();
                switch (view.inputItem()) {
                    case "1" -> { //добавление новой записи
                        connector.addData(session, view, new Course().createRandomCourse());
                        view.writeMessage();
                    }
                    case "2" -> { //получение записи по ID
                        view.addMessage(
                                connector.readDataID(session, view)
                        );
                    }
                    case "3" -> { // обновление записи по ID
                        Course course = connector.readDataID(session, view);
                        if (course == null) {
                            view.emptyMessage();
                            break;
                        }
                        course = course.createRandomCourse();
                        connector.updateData(session, course);
                    }
                    case "4" -> { // получение всех записей
                        List<Course> courseList = connector.readDataAll(session, view);
                        courseList.forEach(System.out::println);
                    }
                    case "5" -> { // удаление записи по ID
                        Course course = connector.readDataID(session, view);
                        if (course == null) {
                            view.emptyMessage();
                            break;
                        }
                        connector.deleteDataID(session, course);
                    }
                    case "6" -> { // удаление всех записей
                        connector.deleteDataAll(session, view);
                    }
                    case "0", default -> { //завершение приложения
                        view.exitMessage();
                        connector.getSessionFactory().close();
                        flag = false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}