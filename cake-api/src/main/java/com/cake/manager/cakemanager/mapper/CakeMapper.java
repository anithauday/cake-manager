package com.cake.manager.cakemanager.mapper;


import com.cake.manager.cakemanager.domain.entity.Cake;
import com.cake.manager.cakemanager.domain.request.CreateCakeRequest;
import com.cake.manager.cakemanager.domain.response.GetCakeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface CakeMapper
{

  Cake toCreateCakeRequest( CreateCakeRequest createCakeRequest );

  @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  GetCakeResponse toGetCakeResponse( Cake cake );

}