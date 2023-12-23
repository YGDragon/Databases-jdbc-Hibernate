package models;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    private static final String[] TITLES =
            {
                    "C# developer",
                    "Java developer",
                    "JavaScript developer",
                    "BigData analytic"
            };

    private static final int[] DURATIONS = {6, 12, 18, 24};

    //region Methods
    public Course createRandomCourse() {
        this.setTitle(TITLES[new Random().nextInt(TITLES.length)]);
        this.setDuration(DURATIONS[new Random().nextInt(DURATIONS.length)]);
        return this;
}

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
    //endregion

    //region Constructors
    public Course() {
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    //endregion

    // region Getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    //endregion

    //region Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //endregion

}