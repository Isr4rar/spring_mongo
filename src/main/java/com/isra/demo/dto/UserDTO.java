package com.isra.demo.dto;

import com.isra.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private String cpf;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        cpf = obj.getCpf();
    }

}
