package com.zarrar.malik.json_databinding_app;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.Student;

public class Streaming_Api_Generator {

    public static void main(String[] args) throws IOException {
       ObjectMapper objectMapper = new ObjectMapper();
       
       JsonFactory jsonFactory = new JsonFactory();
       
       JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out);
       jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
       jsonGenerator.setCodec(objectMapper);
       
       jsonGenerator.writeStartObject();
       
       jsonGenerator.writeFieldName("id");
       jsonGenerator.writeString("34");
       
       jsonGenerator.writeFieldName("id1");
       jsonGenerator.writeString("1234");
       
       jsonGenerator.writeStringField("name", "Json");
       
       Student student = new Student();
       student.setId(2);
       student.setName("Mark");
       student.setLastName("lasting");
       
       jsonGenerator.writeFieldName("Object");
       jsonGenerator.writeObject(student);

       jsonGenerator.writeFieldName("array");
       jsonGenerator.writeStartArray();
       jsonGenerator.writeString("1");
       jsonGenerator.writeString("2");
       jsonGenerator.writeString("3");
       jsonGenerator.writeString("4");
       jsonGenerator.writeEndArray();
       
       jsonGenerator.writeEndObject();
       jsonGenerator.close();

    }

}
