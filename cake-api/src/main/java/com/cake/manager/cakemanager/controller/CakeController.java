package com.cake.manager.cakemanager.controller;

import com.cake.manager.cakemanager.domain.request.CreateCakeRequest;
import com.cake.manager.cakemanager.domain.response.GetCakeResponse;
import com.cake.manager.cakemanager.service.CakeService;
import com.cake.manager.cakemanager.service.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.cake.manager.cakemanager.configuration.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RestController
@RequestMapping ( "/api/v1/" )
@RequiredArgsConstructor
public class CakeController
{

    private final CakeService cakeService;

    private final FileStorageService fileStorageService;

    @Operation ( security = { @SecurityRequirement ( name = BEARER_KEY_SECURITY_SCHEME ) } )
    @ResponseStatus ( HttpStatus.CREATED )
    @PostMapping ( value = "/cake" )
    public void createCake( @Valid @RequestBody CreateCakeRequest createOrderRequest )
    {
        cakeService.createCake( createOrderRequest );
    }

    @Operation ( security = { @SecurityRequirement ( name = BEARER_KEY_SECURITY_SCHEME ) } )
    @ResponseStatus ( HttpStatus.OK )
    @GetMapping
    public List<GetCakeResponse> getCakes( )
    {
        return cakeService.getCakes( );
    }

    @GetMapping ( "/cakes" )
    public ResponseEntity<Resource> downloadFile(
                                                  HttpServletRequest request )
    {
        Resource resource = fileStorageService.loadFileAsResource(  );

        String contentType = null;
        try
        {
            contentType = request
                .getServletContext( )
                .getMimeType( resource
                                  .getFile( )
                                  .getAbsolutePath( ) );
        }
        catch ( IOException ex )
        {

        }

        // Fallback to the default content type if type could not be determined
        if ( contentType == null )
        {
            contentType = "application/octet-stream";
        }

        return ResponseEntity
            .ok( )
            .contentType( MediaType.parseMediaType( contentType ) )
            .header( HttpHeaders.CONTENT_DISPOSITION,
                     "attachment; filename=\"" + resource.getFilename( ) + "\"" )
            .body( resource );
    }
}
