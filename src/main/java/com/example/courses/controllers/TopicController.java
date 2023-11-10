package com.example.courses.controllers;

import com.example.courses.models.Topic;
import com.example.courses.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {


    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Topic>> getAllTopics(){
        List<Topic> topics = topicService.getAlltopics();
        if (topics.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topics);
    }
}
