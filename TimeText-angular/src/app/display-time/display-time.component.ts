import { Component, OnInit } from '@angular/core';
import {TimeTextService} from '../time-text.service';
import {EventServiceService} from '../event-service.service';
import {Time} from '../model/time';
import {Event} from '../model/event';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-display-time',
  templateUrl: './display-time.component.html',
  styleUrls: ['./display-time.component.css']
})
export class DisplayTimeComponent implements OnInit {

  timeText:Time = new Time();
  eventObj:Event = new Event();
  displayTimeText: String;
  eventMessage:String;
  allEventObj;
  constructor(private timeService: TimeTextService, private http: HttpClient, private eventService: EventServiceService) { }

  ngOnInit(): void {
    
    
  }

  onSubmitEvent(ev){
    ev.preventDefault();
    //console.log(ev.target.eventName.value) //eventLocation eventDate
   //console.log(ev.target.hour.value)
   this.eventMessage ="";
   this.eventObj.eventName=ev.target.eventName.value;
   this.eventObj.eventLocation=ev.target.eventLocation.value;
   this.eventObj.eventDate=ev.target.eventDate.value;
   this.eventObj.timeResult
  //  this.eventService.addEvent(this.eventObj).subscribe(data=>{
  //    //console.log(data);
  //    this.eventMessage ="Event created successfully";
  //  },error=>{
  //   this.eventMessage="error occurred, event wasn't created"
  //  })
  this.timeText.hour =ev.target.hour.value;
  this.timeText.minute=ev.target.minute.value;

  this.timeService.addTime1(this.timeText).subscribe(res=>{    
    console.log("hitting this call?")
  }, error=>{
    this.timeService.getTime().subscribe(res=>{
      //console.log(res[0].result);
      this.eventObj.timeResult = res[0].result;

      this.eventService.addEvent(this.eventObj).subscribe(data=>{
      //console.log(data);
      this.eventMessage ="Event created successfully";
      },error=>{
      this.eventMessage="error occurred, event wasn't created"
    })

    })
  })
  }

  onViewEvent(){
    //console.log("clicking here event")
    this.eventService.getAllEvents().subscribe(res=>{
      //console.log(res);
      this.allEventObj = res;
    })
  }


  
    // onSubmit(ev){
  //   ev.preventDefault();
  //   //console.log("hour value: "+ev.target.hour.value + " minute value: "+ ev.target.minute.value)
  //   this.timeText.hour =ev.target.hour.value;
  //   this.timeText.minute=ev.target.minute.value;

  //   this.timeService.addTime1(this.timeText).subscribe(res=>{    
  //     console.log("hitting this call?")
  //   }, error=>{
  //     this.timeService.getTime().subscribe(res=>{
  //       //console.log(res[0].result);
  //       this.displayTimeText = res[0].result;
  //     })
  //   })
  // }

}
