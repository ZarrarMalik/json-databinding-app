package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class WritingTreeModel {
    
    public static void main( String[] args ) throws JsonProcessingException, IOException
    {
        ClassLoader classLoader = ReadingTreeModel.class.getClassLoader();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("mapJson.json");
        
       
            JsonNode root = objectMapper.readTree(file);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            // This will remove the node from the file
            ((ObjectNode)root).remove("booleanFalse");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            
            ((ObjectNode)root).put("New Field", 14);
            ((ObjectNode)root).put("New Field2", "New field");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            
            ((ObjectNode)root).putArray("newArray");
            ((ObjectNode)root).withArray("newArray").add("1");
            ((ObjectNode)root).withArray("newArray").add("2");
            ((ObjectNode)root).withArray("newArray").add("3");
            
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
            
            
            ArrayNode arrayList = ((ObjectNode)root).withArray("arraylist");
            // Only prints the elements of list in json file
            System.out.println(arrayList);
            
            ((ObjectNode)root).withArray("newArray").removeAll();
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
    }

}
