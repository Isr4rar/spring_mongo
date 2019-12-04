package com.isra.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isra.demo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Document
public class Post implements Serializable {

    @Id
    private String id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

}
