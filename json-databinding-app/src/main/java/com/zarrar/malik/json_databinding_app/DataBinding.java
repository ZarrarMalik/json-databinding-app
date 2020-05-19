package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.Student;

/**
 * Hello world!
 *
 */
public class DataBinding 
{
    public static void main( String[] args )
    {
        ObjectMapper objectmapper = new ObjectMapper();
        
        Student student = new Student();
        student.setId(1);
        student.setLastName("test");
        student.setLastName("testaswell");
        
        Student student1 = new Student();
        student1.setId(1);
        student1.setLastName("2ndtest");
        student1.setLastName("2ndtest");
        
        try {
           System.out.println(objectmapper.writeValueAsString(student));
           System.out.println(objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(student1));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Map<String, Object> mapJson = new LinkedHashMap<>();
        mapJson.put("key", "value1");
        mapJson.put("key2", "value2");
        mapJson.put("booleanTrue", true);
        mapJson.put("booleanFalse", false);
        mapJson.put("arraystring", new String[] {"1", "2", "3"});
        mapJson.put("arrayObject", new Student[] {student, student1});
        mapJson.put("simpleObject", student);
        mapJson.put("Integer", 1);
        mapJson.put("nullValues", null);
        mapJson.put("arraylist", Arrays.asList("l","i", "k"));
        mapJson.put("Date", LocalDate.now());
        
        try {
            System.out.println(objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapJson));
            objectmapper.writerWithDefaultPrettyPrinter().writeValue(new File("mapJson.json"), mapJson);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
