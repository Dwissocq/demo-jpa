package org.bernardhugueney.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "user_monument")
public class UserMonumentRelation implements Serializable {

    @Id
    @Column(name = "fk_user", insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "fk_monument", insertable = false, updatable = false)
    private Long monumentId;

    String rating; // TERRIBLE, OK, GOOD, GREAT, AWESOME
}
