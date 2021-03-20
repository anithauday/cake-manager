package com.cake.manager.cakemanager.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@Entity
@Table ( name = "cakes" )
public class Cake
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String image;

    private ZonedDateTime createdAt = ZonedDateTime.now();



}
