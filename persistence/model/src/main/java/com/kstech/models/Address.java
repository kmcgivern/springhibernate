package com.kstech.models;

import javax.persistence.*;

/**
 * Created by Kieran on 22/03/2014.
 */
@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="firstLine")
    private String firstLine;

    @Column(name="secondLine")
    private String secondLine;

    @Column(name="town")
    private String town;

    @Column(name="postCode")
    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
