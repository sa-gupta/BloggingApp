import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostComment } from '../../model/comment';
import { CommentService } from '../../service/comment-service';
import { Post } from '../../model/post';
import { PostService } from '../../service/post-service';

@Component({
  selector: 'app-single-page-post',
  templateUrl: './single-page-post.component.html',
  styleUrls: ['./single-page-post.component.css']
})
export class SinglePagePostComponent implements OnInit {

  postService:PostService;
  // commentService: CommentService;
  // cmnt:PostComment = new PostComment(1,"hi","sachin",new Date(),90,1);
  // cmnts:PostComment[] = [this.cmnt];
  // this.cmnts.push(this.cmnt);
  // post:any;
  constructor(router:Router, private route:ActivatedRoute,postService:PostService) {
    this.postService = postService;
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.postService.getPost(id);
    // console.log(this.postService.getPost(id));
    
  }

}
