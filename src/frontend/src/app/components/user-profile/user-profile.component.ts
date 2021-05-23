import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloggerService } from 'src/app/service/blogger-service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  bloggerServ: BloggerService;
  constructor(bloggerServ: BloggerService, router:Router,  private route:ActivatedRoute) { 
    this.bloggerServ = bloggerServ;
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    let role = this.route.snapshot.params['role'];
    // console.log(id + "   "+role);
    this.bloggerServ.fetchBlogger(id,role);
    
  }

}
