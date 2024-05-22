package com.k99sharma.tulip.utils;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}