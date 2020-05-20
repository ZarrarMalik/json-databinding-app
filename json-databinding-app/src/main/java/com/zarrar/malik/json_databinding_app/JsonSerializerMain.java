package com.zarrar.malik.json_databinding_app;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.JsonData;

public class JsonSerializerMain {

    public static void main(String[] args) throws JsonProcessingException {
        JsonData jsonData = new JsonData();
        jsonData.setDate(new Date());
        jsonData.setId(1);
        jsonData.setKey1("key1");
        jsonData.setKey2("key2");
        
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData));

    }

}
