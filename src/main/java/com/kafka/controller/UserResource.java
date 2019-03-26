package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	//private static final String TOPIC = "test123";
	private static final String TOPIC_JSON = "kafka_example";
	@Autowired
	public KafkaTemplate<String, User> kafkaTemplate; 
	@GetMapping("publish/{msg}")
	public String post(@PathVariable("msg") String msg){
		User user = new User();
		user.setId(1);
		user.setName(msg);
		user.setDescription("Love you!");
		
			kafkaTemplate.send(TOPIC_JSON,user);
				return "Msg Published successfylly....";
	}
}
