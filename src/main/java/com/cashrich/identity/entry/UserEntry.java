package com.cashrich.identity.entry;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntry implements Serializable {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    private String sessionToken;

}
