package com.isra.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isra.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class CommentDTO implements Serializable {

    private String text;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private AuthorDTO author;


}
