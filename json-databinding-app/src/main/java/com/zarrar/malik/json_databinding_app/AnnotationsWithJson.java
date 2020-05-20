package com.zarrar.malik.json_databinding_app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zarrar.malik.jsondomain.Lecture;
import zarrar.malik.jsondomain.Lecture.QuizQuestions;
import zarrar.malik.jsondomain.Lecture.free_preview;

public class AnnotationsWithJson {

    public static void main( String[] args )
    {
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        Lecture lecture = new Lecture();
        lecture.setId(2);
        lecture.setDesc("Json lecture");
        lecture.setName("Json annotations");
        lecture.setNameLine2("Json 2nd line");
        lecture.setEnabled(true);
        lecture.setIgnore("");
        lecture.setIgnore2("");
        
        QuizQuestions quizQuestion = lecture.new QuizQuestions();
        quizQuestion.setId(3);
        quizQuestion.setQuestion("what is Json?");
        quizQuestion.setAnswer("Json is a simple format");
        
        lecture.getListOfQuestions().add(quizQuestion);
        
        lecture.setFree_preview(free_preview.FREE_PREVIEW_ENABLED);
        
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(lecture));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}