import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Blogger } from "../model/blogger";
import { User } from "../model/user";

@Injectable({
    providedIn: 'root'
})
export class UserService {

  
  signupBlogger(blogger: Blogger){
    const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(blogger);  
        console.log('---------');
        console.log(body);
         this.http.post<User>('http://localhost:8083/user/add/blogger/',body,{'headers':headers}).subscribe(
           data=>{blogger.userId=data.userId}
         );
  }
  
  signupModerator(moderator: Blogger) {
    const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(moderator);  
        console.log('---------');
        console.log(body);
         this.http.post<User>('http://localhost:8083/user/add/moderator/',body,{'headers':headers}).subscribe(
           data=>{
            let dataVal = Object.values(data);
            moderator.userId=dataVal[0];
             console.log(data);
          }
         );
  }
  // user: any;

  constructor(private http:HttpClient){
}
  login(user: any) { 

        const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(user);  
        console.log('---------');
        console.log(body);
         this.http.post('http://localhost:8083/user/signin/',body,{'headers':headers}).subscribe(
           data=>{
             let dataVal = Object.values(data);
             user.role=dataVal[2];
           }
         );


  }



}