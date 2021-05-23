import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/service/post-service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  id:any;
  post:any;
  constructor(router:Router, private route: ActivatedRoute, private postService:PostService) { 
    let id = this.route.snapshot.params['id'];
    this.id = id;
  }

  ngOnInit(): void {
  }

  addPost(f:any){
    this.post = new Post(0,f.value.postTitle,f.value.postContent,this.id,new Date(),f.value.postFlair,"",f.value.community,[],this.id,"TEXT");
    console.log(f.value);
    console.log(this.post);

    this.postService.addPostToDb(this.post);
  }

}
