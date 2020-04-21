package com.yongliang.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yongliang.model.Event;
import com.yongliang.service.EventService;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	//get all events
	@GetMapping
	public List<Event> getAllEvents(){
			
		return eventService.getAllEvent();
	}
	
	//create an event
	@PostMapping
	public Event addEvent(@Valid @RequestBody Event event) {
		return eventService.addEvent(event);
	}

}
