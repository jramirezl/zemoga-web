package com.zamoga.portafolioweb.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZemogaProfileVO implements Serializable {
    private Long id;
    private String name;
    private String image;
    private String description;
    private String twitterName;
    List<String> twitts;
}


