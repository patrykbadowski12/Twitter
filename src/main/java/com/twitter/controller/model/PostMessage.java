package com.twitter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMessage implements Serializable {

    @Size(max = 160)
    private String message;
    private String username;
}
