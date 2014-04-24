package uk.co.kstech.dto.address;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import uk.co.kstech.dto.BaseDTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by KMcGivern on 24/04/2014.
 */
public class AddressDTO extends BaseDTO {

    @NotNull
    @NotEmpty
    private String firstLine;

    private String secondLine;

    @NotNull
    @NotEmpty
    private String town;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([A-PR-UWYZ0-9][A-HK-Y0-9][AEHMNPRTVXY0-9]?[ABEHMNPRVWXY0-9]? {1,2}[0-9][ABD-HJLN-UW-Z]{2}|GIR 0AA)$")
    private String postCode;

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(final String firstLine) {
        this.firstLine = firstLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(final String postCode) {
        this.postCode = postCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(final String secondLine) {
        this.secondLine = secondLine;
    }

    public boolean equals(final Object obj) {
        AddressDTO rhs = (AddressDTO) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(firstLine, rhs.firstLine)
                .append(secondLine, rhs.secondLine)
                .append(town, rhs.town)
                .append(postCode, rhs.postCode)
                .isEquals();
    }
}
