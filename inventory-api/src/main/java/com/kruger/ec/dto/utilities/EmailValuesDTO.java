package com.kruger.ec.dto.utilities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailValuesDTO {

    private String mailTo;
    private String subject;
    private String userName;
    private String body;
    private String jwt;

    public EmailValuesDTO() {
    }

    public EmailValuesDTO(String mailTo, String subject, String userName, String body, String jwt) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.userName = userName;
        this.body = body;
        this.jwt = jwt;
    }


}
