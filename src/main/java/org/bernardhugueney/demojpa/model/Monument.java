package org.bernardhugueney.demojpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "monuments")
public class Monument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city")
    @JsonBackReference
    private City city;

    @JsonIgnore
    @ManyToMany(mappedBy="monuments")
    private Set<User> users = new HashSet<User>();

    public Monument(String name) {
        super();
        this.name = name;
    }
    public Monument() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    /*
        public City getCity() {
        return city;
        }

        public void setCity(City city) {
        this.city = city;
        }
        ,*/
    @Override
    public String toString() {
        return "Monument [id=" + id + ", name=" + name
                + ", city=" /*+ city */+ "]";
    }


}
