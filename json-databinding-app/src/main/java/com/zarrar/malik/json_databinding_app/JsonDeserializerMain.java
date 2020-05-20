package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.JsonData;

public class JsonDeserializerMain {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("customJson.json");
       JsonData jsonData = objectMapper.readValue(file, JsonData.class);
       
//        ClassLoader classLoader = ReadingTreeModel.class.getClassLoader();
//        JsonData jsonData = objectMapper.readValue(new File(classLoader.getResource("customJson.json").getFile()), JsonData.class);
        
       System.out.println("id + " + jsonData.getId());
       System.out.println("id + " + jsonData.getKey1());
       System.out.println("id + " + jsonData.getKey2());
    }

}
