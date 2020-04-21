import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventServiceService {

  constructor(private http: HttpClient) { }

   //get all events
   getAllEvents(){
    return this.http.get("http://localhost:8080/events");
  }

  //create an event
  addEvent(event){
		return this.http.post("http://localhost:8080/events", event, {observe: 'response'})
	}
}
