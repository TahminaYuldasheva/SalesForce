package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Contact {

    private String salutation;
    private String firstName;
    private String lastName;
    private String phone;
    private String homePhone;
    private String title;
    private String department;
    private String mobile;
    private String fax;
    private String email;
}
