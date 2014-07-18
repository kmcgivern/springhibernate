package uk.co.kstech.dto.person;

import org.hibernate.annotations.Type;
import uk.co.kstech.dto.BaseDTO;
import uk.co.kstech.dto.address.AddressDTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by KMcGivern on 7/17/2014.
 */
public class PersonDTO extends BaseDTO {

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "birthDate")
    @Type(type="date")
    private Date birthDate;

    private List<AddressDTO> addresses = new ArrayList<>(0);

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
