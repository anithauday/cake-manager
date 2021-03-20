package com.cake.manager.cakemanager.service;

import com.cake.manager.cakemanager.domain.entity.Cake;
import com.cake.manager.cakemanager.domain.request.CreateCakeRequest;
import com.cake.manager.cakemanager.domain.response.GetCakeResponse;

import java.util.List;

public interface CakeService
{
    List<GetCakeResponse> getCakes( );

    Cake createCake( CreateCakeRequest createCakeRequest );
}
