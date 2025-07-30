package com.springg.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StanderResponse {
    private int code;
    private String message;
    private Object data;

}
