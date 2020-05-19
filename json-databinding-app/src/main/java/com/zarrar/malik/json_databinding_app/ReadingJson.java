package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.Student;

public class ReadingJson {

    public static void main(String[] args) {
        ObjectMapper objectmapper = new ObjectMapper();
        String jsonString = "{\"id\":\"1\", \"name\":\"22\", \"lastName\":\"test\"}";
        try {
            Student student = objectmapper.readValue(jsonString, Student.class);
            System.out.println("Student id is" + student.getId());
            System.out.println("Student name is" + student.getName());
            System.out.println("Student lastName is" + student.getLastName());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("mapJson.json");
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
        };

        HashMap<String, Object> objectMap;
        try {
            objectMap = mapper.readValue(file, typeRef);
            System.out.println("Got " + objectMap);
            for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
