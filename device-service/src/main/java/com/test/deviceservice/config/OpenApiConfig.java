package com.test.deviceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI deviceServiceOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Device Service API")
                                .description("Device Service API for Home Energy Tracker")
                                .contact(getContact())
                                .license(getLicense())
                                .version("1.0.0")
                );
    }

    private static License getLicense(){
        License license= new License();
        license.setName("Create commons attribution-non commercial 4.0 international license");
        license.setUrl("https://creativecommons.org/licenses/by-nc/4.0/");
        return license;
    }


    private static Contact getContact() {
        Contact contact = new Contact();
        contact.setUrl("https://leetjourney.com");
        contact.setName("Home Energy Tracker");
        contact.setEmail("test@test.com");
        return contact;
    }

}
