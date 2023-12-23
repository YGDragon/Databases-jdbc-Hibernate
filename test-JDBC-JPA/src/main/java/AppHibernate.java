import services.AppController;

/*
Урок 4. Базы данных и инструменты взаимодействия с ними
<br>Создайте базу данных (например, SchoolDB).
<br>В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
<br>Настройте Hibernate для работы с вашей базой данных.
<br>Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
<br>Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
<br>Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

public class AppHibernate {
    public static void main(String[] args) {
       new AppController().handlingController();
    }
}