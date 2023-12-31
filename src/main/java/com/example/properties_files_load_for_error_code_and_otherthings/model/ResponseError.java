package com.example.properties_files_load_for_error_code_and_otherthings.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    private int errorCode;
    private String message;
}
