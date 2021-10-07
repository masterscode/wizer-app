package com.library.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest implements Serializable {
    @NotBlank(message = "This field should not be empty")
    private String name;
}
