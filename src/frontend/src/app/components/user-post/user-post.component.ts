import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from 'src/app/service/post-service';

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  // post:any;
  router:Router;
  postService:PostService;
  id: any;
  role:any;
  constructor( router:Router, private route:ActivatedRoute,postService:PostService) { 
    this.postService = postService;
    this.router = router;
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.id = id;
    this.postService.getPostsByBlogger(id);
    // console.log(this.post);
  }

  postPageRoute(id: number){
    this.router.navigate([
      '/post/'+id
    ]);
  }

  routeToUpdate(id: number){
    this.router.navigate([
      '/update-post/'+id
    ]);
  }

  deletePost(id: number){
    this.postService.deletePost(id);
    setTimeout(() => {
      window.location.reload();

    },1000);
  }

}
