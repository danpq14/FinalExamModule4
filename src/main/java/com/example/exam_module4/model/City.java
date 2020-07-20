package com.example.exam_module4.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Min(1)
    private Long area;

    @Min(1000)
    private Long population;

    @Min(1)
    private Long gdp;

    @Column(columnDefinition = "TEXT")
    private String description;

}
