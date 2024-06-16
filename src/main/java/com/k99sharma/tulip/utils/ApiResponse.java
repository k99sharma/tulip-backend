package com.k99sharma.tulip.utils;

import lombok.*;

/**
 * Api Response class to send data back to client.
 * @param <T> data to be sent back in response.
 */
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
