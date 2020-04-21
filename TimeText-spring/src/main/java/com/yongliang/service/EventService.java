package com.yongliang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongliang.model.Event;
import com.yongliang.model.StringNum;
import com.yongliang.repositories.EventRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	//get all events
	public List<Event> getAllEvent(){
		return eventRepo.findAll();
	}
	
	//create an event
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	

}
