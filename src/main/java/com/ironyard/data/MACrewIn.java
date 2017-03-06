package com.ironyard.data;

import javax.persistence.*;

/**
 * Created by matthewhug on 3/3/17.
 */
//@Entity
public class MACrewIn {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieactor_sequence")
//    @SequenceGenerator(name="movieactor_sequence", sequenceName = "movieactor_sequence")
    private long myId;
    private boolean adult;
    private String credit_id;
    private String department;
    private long id;
    private String job;
    private String original_title;
    private String poster_path;
    private String release_date;
    private String title;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
