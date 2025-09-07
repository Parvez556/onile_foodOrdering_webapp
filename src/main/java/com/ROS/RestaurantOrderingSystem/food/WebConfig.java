package com.ROS.RestaurantOrderingSystem.food;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class WebConfig implements WebMvcConfigurer {


@Value("${file.upload-dir}")
private String uploadDir;


// @Override
// public void addResourceHandlers(ResourceHandlerRegistry registry) {
// // Make the uploads folder accessible under /images/**
// Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
// String resourceLocation = "file:" + uploadPath.toString() + File.separator;
// registry.addResourceHandler("/images/**")
// .addResourceLocations(resourceLocation);
// }
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
    String resourceLocation = "file:" + uploadPath.toString() + "/"; // Use / instead of File.separator
    registry.addResourceHandler("/images/**")
            .addResourceLocations(resourceLocation);
}

}