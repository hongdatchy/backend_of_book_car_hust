package com.hongdatchy.bookcar.entities.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "contract")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "distance", nullable = false)
    private String distance;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "time", nullable = false)
    private Timestamp time;


}
