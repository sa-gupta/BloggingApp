import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../model/user';
import { UserService } from '../../service/user-service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  user:any;
  success:boolean = false;
  userServ:UserService;
  router:Router;

  constructor(router:Router,userServ:UserService) {
    this.userServ = userServ;
    this.router = router;
  }

  ngOnInit(): void {
  }

  loginUser(fm:any){
    this.user = new User(fm.value.id,fm.value.password,"");
    this.userServ.login(this.user);
    setTimeout(
      ()=>{

        console.log(this.user);
        if(this.user.role==""){
          console.log("Wrong Password");
          this.success = true;
        }else{
          this.router.navigate([
            '/user/'+this.user.role+'/'+fm.value.id
          ]);
        }
      }, 
      1000
    ); 

  }

}
