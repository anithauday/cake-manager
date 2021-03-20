package com.cake.manager.cakemanager.domain.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Data
public class GetCakeResponse
{

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String image;

    @NotBlank
    private ZonedDateTime createdAt;
}
