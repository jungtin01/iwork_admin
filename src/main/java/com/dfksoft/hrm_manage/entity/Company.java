package com.dfksoft.hrm_manage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    //@JoinColumn(name = "id", insertable = false, updatable = false)
    private Set<Location> location;

//    public Location getLocation() {
//        return location;
//    }

    public Set<Location> getLocation() {
        return location;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
