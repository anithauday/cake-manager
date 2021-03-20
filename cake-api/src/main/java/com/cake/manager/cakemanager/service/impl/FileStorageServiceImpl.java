package com.cake.manager.cakemanager.service.impl;

import com.cake.manager.cakemanager.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService
{

    private final ResourceLoader resourceLoader;

    @Value ( "${download-file-path}" )
    private String filePath;

    @Override
    public Resource loadFileAsResource( )
    {
        return resourceLoader.getResource( filePath );
    }
}