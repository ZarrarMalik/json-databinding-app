package com.zarrar.malik.json_databinding_app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import zarrar.malik.jsondomain.LectureSchema;

public class JsonSchemaValidator {

    public static void main(String[] args) throws JsonProcessingException, IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        LectureSchema lectureSchema = new LectureSchema();
        lectureSchema.setId(4);
        lectureSchema.setName("test");
        lectureSchema.setNameLine2("test2");
        lectureSchema.setDesc("This is not a test");
        lectureSchema.setEnabled(true);
        
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(lectureSchema));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        File file = new File("mapJson.json");
        JsonNode schema = objectMapper.readTree(file);
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().freeze();
        
        JsonSchema jsonSchema = jsonSchemaFactory.getJsonSchema(schema);

        File validateFile = new File("mapJson.json");
        JsonNode validate = objectMapper.readTree(validateFile);
        
        System.out.println(jsonSchema.validate(validate));
        
    }

}
