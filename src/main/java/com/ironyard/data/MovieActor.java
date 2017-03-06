package com.ironyard.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matthewhug on 3/3/17.
 */
//@Entity
public class MovieActor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieactor_sequence")
//    @SequenceGenerator(name="movieactor_sequence", sequenceName = "movieactor_sequence")
    private long myId;
    private long id;
//    @ManyToMany
    private List<MACrewIn> crew;
//    @ManyToMany
    private List<MACastIn> cast;


}
