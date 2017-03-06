package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matthewhug on 3/3/17.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieActorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieactor_sequence")
    @SequenceGenerator(name="movieactor_sequence", sequenceName = "movieactor_sequence")
    private long myId;
    private long id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MACastInDTO> cast;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MACrewInDTO> crew;
    @OneToOne
    MADetailsDTO MADetails;

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myId) {
        this.myId = myId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MACastInDTO> getCast() {
        return cast;
    }

    public void setCast(List<MACastInDTO> cast) {
        this.cast = cast;
    }

    public List<MACrewInDTO> getCrew() {
        return crew;
    }

    public void setCrew(List<MACrewInDTO> crew) {
        this.crew = crew;
    }

    public MADetailsDTO getMADetails() {
        return MADetails;
    }

    public void setMADetails(MADetailsDTO MADetails) {
        this.MADetails = MADetails;
    }
}
