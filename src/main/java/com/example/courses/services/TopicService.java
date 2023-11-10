package com.example.courses.services;

import com.example.courses.models.Topic;
import com.example.courses.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TopicService {
    private  TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAlltopics(){
        Iterable<Topic> topics =  topicRepository.findAll();
        return StreamSupport.stream(topics.spliterator(),false).collect(Collectors.toList());
    }
}
