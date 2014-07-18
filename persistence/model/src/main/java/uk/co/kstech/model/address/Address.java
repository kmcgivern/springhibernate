package uk.co.kstech.model.address;

import uk.co.kstech.model.DomainObject;
import uk.co.kstech.model.person.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kieran on 22/03/2014.
 */
@Entity(name = "ADDRESS")
public class Address extends DomainObject {

    @NotNull
    @Column(name = "firstLine")
    private String firstLine;

    @Column(name = "secondLine")
    private String secondLine;

    @NotNull
    @Column(name = "town")
    private String town;

    @NotNull
    @Pattern(regexp = "^([A-PR-UWYZ0-9][A-HK-Y0-9][AEHMNPRTVXY0-9]?[ABEHMNPRVWXY0-9]? {1,2}[0-9][ABD-HJLN-UW-Z]{2}|GIR 0AA)$")
    @Column(name = "postCode")
    private String postCode;

    private List<Person> people = new ArrayList<>();

    //these annotations need to be on the getter.
    @ManyToMany
    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
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
