import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from 'src/app/service/post-service';

@Component({
  selector: 'app-community-post',
  templateUrl: './community-post.component.html',
  styleUrls: ['./community-post.component.css']
})
export class CommunityPostComponent implements OnInit {

  router:Router;
  postService:PostService;
  id: any;
  constructor( router:Router, private route:ActivatedRoute,postService:PostService) { 
    this.postService = postService;
    this.router = router;
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.id = id;
    this.postService.getPostsByCommunity(id);
  }

  postPageRoute(id: number){
    this.router.navigate([
      '/post/'+id
    ]);
  }

}
