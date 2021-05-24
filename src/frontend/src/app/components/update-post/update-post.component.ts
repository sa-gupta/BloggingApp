import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/service/post-service';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})
export class UpdatePostComponent implements OnInit {

  id:any;
  post:Post;
  updatePostTest:Post;
  postService:PostService;
  constructor(router:Router, private route:ActivatedRoute, postService:PostService, private location:Location) { 
    this.post = new Post(0,"","","",new Date(),"","",0,[],0,"");
    this.updatePostTest = new Post(0,"","","",new Date(),"","",0,[],this.post.bloggerId,"");
    this.postService = postService;
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    
    this.postService.fetchPostById(id);
    // console.log(this.post);
    
    this.id = id;
  }

  updatePost(f:any){
    console.log(this.post);
    this.updatePostTest = new Post(this.id,f.value.postTitle,f.value.postContent,this.postService.postToUpdate.createdBy,new Date(),f.value.postFlair,
    this.postService.postToUpdate.community,this.postService.postToUpdate.communityId,this.postService.postToUpdate.comments,this.postService.postToUpdate.bloggerId,"TEXT");
    // console.log(f.value);
    console.log(this.updatePostTest);
    this.postService.updatePost(this.updatePostTest);
    setTimeout(() => {
      this.location.back();

    },1000);
    // console.log(this.post);
  }

}
