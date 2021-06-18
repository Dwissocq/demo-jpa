package org.bernardhugueney.demojpa.model;


import org.hibernate.annotations.WhereJoinTable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToMany
    @JoinTable(name= "user_monument",
            joinColumns = {@JoinColumn(name = "fk_user", referencedColumnName= "id" ) },
            inverseJoinColumns = { @JoinColumn(name = "fk_monument", referencedColumnName= "id") })
    private Set<Monument> monuments = new HashSet<Monument>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setFavoriteMonuments(Set<Monument> favoriteMonuments) {
        this.favoriteMonuments = favoriteMonuments;
    }

    @WhereJoinTable(clause = "rating= 'AWESOME'")
    @ManyToMany
    @JoinTable(name= "user_monument",
            joinColumns = {@JoinColumn(name = "fk_user", referencedColumnName= "id" ) },
            inverseJoinColumns = { @JoinColumn(name = "fk_monument", referencedColumnName= "id") })
    private Set<Monument> favoriteMonuments = new HashSet<>();

    public User() {
    }
    public User(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void addMonument(Monument m){
        monuments.add(m);
        m.getUsers().add(this);
    }
    public Set<Monument> getMonuments(){
        return monuments;
    }
    public void setMonuments(Set<Monument> monuments) {
        this.monuments= monuments;
    }
    public String toString() {
        return "User :{ id= "+id+"\n name= "+name+"\n nb momunents"+ monuments.size()+"\n}";
    }

    public Set<Monument> getFavoriteMonuments() {
        return favoriteMonuments;
    }
}
