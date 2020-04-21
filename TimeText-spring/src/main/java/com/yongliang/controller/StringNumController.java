package com.yongliang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yongliang.model.StringNum;

@RestController
@RequestMapping("/texts")
@CrossOrigin
public class StringNumController {
	
	StringNum textNum = new StringNum();
	List<StringNum> stringNumList = new ArrayList<StringNum>();
	public String displayTimeText="";
	
	
	
	
	@GetMapping
	public List getText(){
		
		List textList = new ArrayList();
		textNum.setResult(displayTimeText);
		textList.add(textNum);
		return textList;
	}

	@PostMapping
	public String addStringNum(@Valid @RequestBody StringNum text) {
		
		displayTimeText = timeInWords(text.getHour(), text.getMinute());
		return displayTimeText;
	}
	
	//take int input and return string for the time
	public String timeInWords(int h, int m) {
        String hour= numToWord(h);
		String minute=numToWord(m);
		String stringClock = "";
		
		final int sixtyMinutes =60;
		//this value is for minutes past 30
		int remainingMin = sixtyMinutes - m;
		String stringRemainMin = numToWord(remainingMin);      
		String hourPlusOne = numToWord(h+1);
		
		if((h>0 && h<13) && (m>=0 && m <61)){
    
		    if(m ==0) {
		        stringClock =hour+" o' clock";
		    }
		    else if(m ==1) {
		        stringClock = minute+" minute past "+hour;
		    }
		    else if(m ==15) {
		        stringClock ="quarter past "+hour;
		    }        
		    else if(m ==30) {
		        stringClock ="half past "+hour;
		    }
		       //minutes from 2 to 14 and 16 to 29
		    else if((m>1 && m <30)  && m!=15 ) {
		        stringClock = minute+" minutes past "+hour;
		    }
		    else if(m == 45) {
		        stringClock ="quarter to "+hourPlusOne;
		    }
		    else if(m == 59) {
		        stringClock =stringRemainMin +" minute to "+hourPlusOne;
		    }
		    else if(m>30 && m <59) {
		        stringClock =stringRemainMin +" minutes to "+hourPlusOne;
		    }
            
			}
			else {
			    stringClock = "invalid time input";
			}
				return stringClock;
			
			}

	//take a number and return a text
	public String numToWord(int num){

        switch(num){
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "quarter";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";
            case 21: return "twenty one";
            case 22: return "twenty two";
            case 23: return "twenty three";
            case 24: return "twenty four";
            case 25: return "twenty five";
            case 26: return "twenty six";
            case 27: return "twenty seven";
            case 28: return "twenty eight";
            case 29: return "twenty nine";
            case 30: return "half";
            default: return "";
        }
    }
}
