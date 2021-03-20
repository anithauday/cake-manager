package com.cake.manager.cakemanager.service.impl;

import com.cake.manager.cakemanager.domain.entity.Cake;
import com.cake.manager.cakemanager.domain.request.CreateCakeRequest;
import com.cake.manager.cakemanager.domain.response.GetCakeResponse;
import com.cake.manager.cakemanager.mapper.CakeMapper;
import com.cake.manager.cakemanager.repository.CakeRepository;
import com.cake.manager.cakemanager.service.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CakeServiceImpl
    implements CakeService
{
    private final CakeMapper cakeMapper;
    private final CakeRepository cakeRepository;

    @Override
    public List<GetCakeResponse> getCakes( )
    {
        return cakeRepository
            .findAll( )
            .stream( )
            .map( cakeMapper::toGetCakeResponse )
            .collect( Collectors.toList( ) );
    }

    @Override
    public Cake createCake( final CreateCakeRequest createCakeRequest )
    {
        return cakeRepository.save( cakeMapper.toCreateCakeRequest( createCakeRequest ) );
    }
}
