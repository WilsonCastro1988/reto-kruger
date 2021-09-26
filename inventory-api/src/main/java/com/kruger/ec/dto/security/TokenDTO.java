package com.kruger.ec.dto.security;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenDTO implements Serializable {

    String value;

}
