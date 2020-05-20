package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingTreeModel {
    public static void main( String[] args )
    {
        ClassLoader classLoader = ReadingTreeModel.class.getClassLoader();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("mapJson.json");
        
        try {
           // JsonNode root = objectMapper.readTree(new File(classLoader.getResource("mapJson.json").getFile()));
            JsonNode root = objectMapper.readTree(file);
            JsonNode key1 = root.get("key");
            String valueOfKey1 = key1.asText();
            System.out.println("Value of key1 is : " + valueOfKey1);
            
            JsonNode key2 = root.get("key2");
            String valueOfKey2 = key2.asText();
            System.out.println("Value of key2 is : " + valueOfKey2);
            
            JsonNode booleanTrue = root.get("booleanTrue");
            String booleanTrueValue = booleanTrue.asText();
            System.out.println("Value of booleanTrue is : " + booleanTrueValue);
            
            JsonNode array = root.get("arraystring");
            //Check if its an array
            System.out.println("Is this an array? : " + array.isArray());
            //If it is we iterate through
            for (JsonNode jsonNode : array) {
                System.out.println("Array? : " + jsonNode.asText());
            }
            
            JsonNode arrayObject = root.get("arrayObject");
            System.out.println("Is this an array? : " + arrayObject.isArray());
            
            for (JsonNode jsonNode : arrayObject) {
                System.out.println("Id is  : " + jsonNode.get("id").asText());
                System.out.println("Name is  : " + jsonNode.get("name").asText());
                System.out.println("LastName is  : " + jsonNode.get("lastName").asText());
            }
            
            JsonNode nestedObject = root.get("simpleObject");
            // Check if its an object
            System.out.println("Is this an Object? : " + nestedObject.isObject());
            
            System.out.println("Id is  : " + nestedObject.get("id").asText());
            System.out.println("Name is  : " + nestedObject.get("name").asText());
            System.out.println("LastName is  : " + nestedObject.get("lastName").asText());
            
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
