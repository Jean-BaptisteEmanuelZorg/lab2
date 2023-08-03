package com.shop.flowerstore.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseEntity<T> {
    private T data;

    private Map<String, String> errors;

    public static <T> CustomResponseEntity<T> ok(T data) {
        CustomResponseEntity<T> response = new CustomResponseEntity<>();
        response.setData(data);
        return response;
    }

    public static <T> CustomResponseEntity<T> badRequest(Map<String, String> errors) {
        CustomResponseEntity<T> response = new CustomResponseEntity<>();
        response.setErrors(errors);
        return response;
    }
}
