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
  constructor(router:Router, private route:ActivatedRoute, private postService:PostService, private location:Location) { 
    this.post = new Post(0,"","","",new Date(),"","",0,[],0,"");
    this.updatePostTest = new Post(0,"","","",new Date(),"","",0,[],this.post.bloggerId,"");
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.post = this.postService.fetchPostById(id);
    console.log(this.post);
    
    this.id = id;
  }

  updatePost(f:any){
    console.log(this.post);
    this.updatePostTest = new Post(this.id,f.value.postTitle,f.value.postContent,this.post.createdBy,new Date(),f.value.postFlair,
    this.post.community,this.post.communityId,this.post.comments,2,"TEXT");
    // console.log(f.value);
    console.log(this.updatePostTest);
    this.postService.updatePost(this.updatePostTest);
    setTimeout(() => {
      this.location.back();

    },1000);
    // console.log(this.post);
  }

}
