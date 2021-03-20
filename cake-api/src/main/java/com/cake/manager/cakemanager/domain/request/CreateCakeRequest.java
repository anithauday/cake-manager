package com.cake.manager.cakemanager.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCakeRequest
{

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String image;
}
