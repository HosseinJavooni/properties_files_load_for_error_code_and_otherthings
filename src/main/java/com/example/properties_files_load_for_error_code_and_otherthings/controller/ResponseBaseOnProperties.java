package com.example.properties_files_load_for_error_code_and_otherthings.controller;

import com.example.properties_files_load_for_error_code_and_otherthings.SampleComponentForLoadingProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
public class ResponseBaseOnProperties {
    @GetMapping("/{id}")
    public String returnFromProperties(@RequestHeader Map<String, String> header, @PathVariable String id){
        String language = header.get("language");
        if(language.equals("fa")) {
            return new String(SampleComponentForLoadingProperties.propertiesMap.get("fa").getProperty(id).getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        } else {
            return SampleComponentForLoadingProperties.propertiesMap.get("US").getProperty(id);
        }
    }
}
