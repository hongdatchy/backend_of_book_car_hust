package com.hongdatchy.bookcar.entities.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLogin {
    private String phone;
    private String token;
}
