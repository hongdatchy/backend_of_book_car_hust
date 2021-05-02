package com.hongdatchy.bookcar.entities.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPayload {
    private String distance;
    private Integer cost;
}
