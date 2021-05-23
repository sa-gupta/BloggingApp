import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blogger } from 'src/app/model/blogger';
import { Post } from 'src/app/model/post';
import { PostComment } from '../../model/comment';
import { CommentService } from '../../service/comment-service';

@Component({
  selector: 'app-comment-section',
  templateUrl: './comment-section.component.html',
  styleUrls: ['./comment-section.component.css']
})
export class CommentSectionComponent implements OnInit {
  commentService: CommentService;
  comment:any;
  // cmnts:any;
  id:any;
  constructor(commentService: CommentService, private route:ActivatedRoute, private router:Router) {
    this.commentService = commentService;
   }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.id = id;
    this.commentService.fetchComment(id);
    // console.log(this.cmnts);
  }

  addComment(cmnt:any, bid:any){
    // console.log(cmntFrm.value );
    // this.comment = new PostComment(0,cmnt.value,"",new Date(),0,new Blogger(bid.value,"",0,"",[]),new Post(this.id,"","","",new Date(),"","",[]));
    this.comment = new PostComment(0,cmnt.value,"",new Date(),0,bid.value,this.id);

    // console.log(this.comment);
    this.commentService.addCommentToDb(this.comment);
    this.router.navigate([
      'post/'+this.id
    ]);
    // this.ngOnInit();

  }
}
