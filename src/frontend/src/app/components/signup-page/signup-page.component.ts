

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Blogger } from 'src/app/model/blogger';
import { UserService } from 'src/app/service/user-service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {
  // id:any;
  blogger:any;
  // moderator:any;
  userServ:UserService;
  success:boolean = false;
  failure:boolean = false;
  constructor(userServ:UserService, router:Router) { 
    this.userServ=userServ;
  }

  ngOnInit(): void {
  }


  signUpUser(f:any){
    if(f.value.role=="Blogger"){
      this.blogger = new Blogger(0,f.value.name,0,f.value.cnfPassword,[]);
      // console.log(this.blogger);
      this.userServ.signupBlogger(this.blogger);
      setTimeout(()=>{
        if(this.blogger.userId>0){
          this.success = true;
          // console.log("Account Created Successfully.");
        }else{
          console.log("Something went wrong");
          this.failure = true;
        }

      },2000);

    }else{
      this.blogger = new Blogger(0,f.value.name,0,f.value.cnfPassword,[]);
      this.userServ.signupModerator(this.blogger);
      setTimeout(()=>{
        // console.log(this.blogger.userId);
        if(this.blogger.userId>0){
          this.success = true;
          // console.log("Account Created Successfully.");
        }else{
          console.log("Something went wrong");
          this.failure = true;
        }

      },2000);
      // console.log(this.moderator);
      
    }





    // console.log(f.value);
  }
}