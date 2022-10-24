package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Id;

//Sinenhlanhla Zondi

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class Secretary {

    @Id
    @NotNull
    private String secID;

    @NotNull
    private String secFirstName;

    @NotNull
    private String secLastName;

    public Secretary(String secID, String secFirstName, String secLastName) {
        this.secID = secID;
        this.secFirstName = secFirstName;
        this.secLastName = secLastName;
    }
}
