package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/**
 * Created by matthewhug on 3/3/17.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class MACastInDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "macastin_sequence")
    @SequenceGenerator(name="macastin_sequence", sequenceName = "macastin_sequence")
    private long myId;
    private boolean adult;
    private String character;
    private String credit_id;
    private long id;
    private String original_title;
    private String poster_path;
    private String release_date;
    private String title;

    public MACastInDTO() {
    }

    public MACastInDTO(long myId) {
        this.myId = myId;
    }

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myId) {
        this.myId = myId;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
