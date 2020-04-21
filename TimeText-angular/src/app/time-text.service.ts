import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Time} from './model/time';

@Injectable({
  providedIn: 'root'
})
export class TimeTextService {
  timeText:Time = new Time();
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }
  
  //get time in string
  getTime(){
    return this.http.get("http://localhost:8080/texts");
  }

  //post time
  addTime(time :Time): Observable<any>{
    return this.http.post<any>("http://localhost:8080/texts", time , {headers: this.headers})

  }

  addTime1(time){

		return this.http.post("http://localhost:8080/texts", time, {observe: 'response'})
	}

}
