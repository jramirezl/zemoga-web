package com.zamoga.portafolioweb.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
public class ZemogaProfileEntity {
    @Id
    @Column(name = "idportfolio")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String name;
    @Column(name = "imageURL")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "twitterUserName")
    private String twitterName;

}
