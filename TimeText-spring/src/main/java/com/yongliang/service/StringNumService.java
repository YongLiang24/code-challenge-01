package com.yongliang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongliang.model.StringNum;
import com.yongliang.repositories.StringNumRepo;

@Service
public class StringNumService {
	
	@Autowired    
	private StringNumRepo stringNumRepo;  
	
	//get all students
	public List<StringNum> getStringNum(){
		
		return stringNumRepo.findAll();
	}
	
	//add a student
	public StringNum addStudent(StringNum stringNum) {
		
		return stringNumRepo.save(stringNum);
	}
	
}
