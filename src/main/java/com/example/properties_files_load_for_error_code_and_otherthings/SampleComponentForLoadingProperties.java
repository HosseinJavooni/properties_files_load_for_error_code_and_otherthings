package com.example.properties_files_load_for_error_code_and_otherthings;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class SampleComponentForLoadingProperties {
    public static final Map<String , Properties> propertiesMap = new HashMap<>();
    @PostConstruct
    public void loadProperties() throws IOException {
        try (InputStreamReader faProperties = new InputStreamReader(new FileInputStream("src/main/resources/config-fa.properties"), StandardCharsets.UTF_8);
             InputStreamReader USProperties = new InputStreamReader(new FileInputStream("src/main/resources/config-US.properties"), StandardCharsets.UTF_8)) {

            Properties propFa = new Properties();
            Properties propUS = new Properties();

            propertiesMap.put("fa", propFa);
            propertiesMap.put("US", propUS);

            // load a properties file
            propFa.load(faProperties);
            propUS.load(USProperties);

            // get the property value and print it out
            System.out.println(propFa.getProperty("1"));
            System.out.println(propUS.getProperty("1"));
            System.out.println(propFa.getProperty("4"));
            System.out.println(propUS.getProperty("4"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
