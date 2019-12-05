package com.isra.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isra.demo.dto.AuthorDTO;
import com.isra.demo.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document
public class Post implements Serializable {

    @Id
    private String id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
