package com.library.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest implements Serializable {

    @NotBlank(message = "This field should not be empty")
    private String title;
    @NotBlank(message = "This field should not be empty")
    private String isbn;

    @NotBlank(message = "This field should not be empty")
    private String author;

    @NotBlank(message = "This field should not be empty")
    private String language;

    @NotBlank(message = "This field should not be empty")
    private Double price;

}
