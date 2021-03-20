package com.cake.integration;

import com.intuit.karate.junit5.Karate;

public class CakeManagerITTest {

    @Karate.Test
    Karate testAuthLoginCreateCake() {
        return Karate.run("auth-login-create-cake").relativeTo(getClass());
    }

    @Karate.Test
    Karate testAuthLoginCreateCakeGetCakes() {
        return Karate.run("auth-login-create-cake-get-cakes").relativeTo(getClass());
    }

    @Karate.Test
    Karate testDownloadCakeList() {
        return Karate.run("download-cake-list").relativeTo(getClass());
    }

}
