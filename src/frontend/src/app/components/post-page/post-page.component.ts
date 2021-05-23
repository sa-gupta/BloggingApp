import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from '../../service/post-service';

@Component({
  selector: 'app-post-page',
  templateUrl: './post-page.component.html',
  styleUrls: ['./post-page.component.css']
})
export class PostPageComponent implements OnInit {

  postServ:PostService;

  router:Router;

  constructor(postServ:PostService, router:Router) {
    this.postServ = postServ;
    this.router = router;
   }

  ngOnInit(): void {
    this.postServ.fetchPosts();
  }

  postPageRoute(id: number){
    this.router.navigate([
      '/post/'+id
    ]);
  }

}
