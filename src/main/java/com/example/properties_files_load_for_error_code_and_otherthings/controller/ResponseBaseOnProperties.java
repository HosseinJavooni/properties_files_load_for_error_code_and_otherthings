package com.example.properties_files_load_for_error_code_and_otherthings.controller;

import com.example.properties_files_load_for_error_code_and_otherthings.SampleComponentForLoadingProperties;
import com.example.properties_files_load_for_error_code_and_otherthings.model.ResponseError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ResponseBaseOnProperties {

    // curl -v -X GET "http://localhost:8080/1" -H "language:fa" | json_reformat
    @GetMapping("/{errorCode}")
    public ResponseError returnBaseOnProperties(@RequestHeader Map<String, String> header, @PathVariable String errorCode){
        String headerLanguage = header.get("language");
        String message;
        if(headerLanguage != null && headerLanguage.equals("fa")) {
             message = SampleComponentForLoadingProperties.propertiesMap.get("fa").getProperty(errorCode);
        } else {
             message = SampleComponentForLoadingProperties.propertiesMap.get("US").getProperty(errorCode);
        }
        return new ResponseError(Integer.parseInt(errorCode), message);
    }
}
