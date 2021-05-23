import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "../model/post";
import { CommentService } from "./comment-service";



@Injectable({
    providedIn: 'root'
})
export class PostService{

    updatePost(post: Post) {
        const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(post);  
        console.log('---------');
        console.log(body);
         this.http.put<boolean>('http://localhost:8083/post/update',body,{'headers':headers}).subscribe(
           data=>{
            //    comment.commentId=data.commentId;
        console.log(data);
    }
         );
    }
    
    posts:Array<Post> = [];
    
    userPosts:Array<Post> = [];

    postToUpdate:Post;

    post:Post = new Post(0,"","","",new Date,"","",0,[],0,"");

    fetchPostById(id: any): Post{
        this.fetchPosts();
        this.postToUpdate = this.getPost(id);
        console.log(this.posts);
        console.log(this.postToUpdate);
        
    //   for (let i = 0; i < this.posts.length; i++) {
    //       if(this.posts[i].postId == id){
    //           this.postToUpdate = this.posts[i];
    //           console.log(this.postToUpdate);

    //           break;
    //         }
            
    //     }
      return this.postToUpdate;
    }
    addPostToDb(post: any) {
        const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(post);  
        console.log('---------');
        console.log(body);
         this.http.post<boolean>('http://localhost:8083/post/test',body,{'headers':headers}).subscribe(
           data=>{
            //    comment.commentId=data.commentId;
        console.log(data);
    }
         );
    }
    deletePost(id: number) {
        this.http.delete('http://localhost:8083/post/delete/'+id).subscribe(
            data => {
                console.log(data);
            }
        );
    }
    

    

    constructor(private commentService: CommentService, private http:HttpClient){
        // this.commentService = commentService;
        this.postToUpdate = new Post(0,"","","",new Date(),"","",0,[],0,"");
    }

    getPost(id: number):any {
        
        this.http.get<Post>("http://localhost:8083/post/"+id).subscribe(
            data=>{
                this.post = data;
            }
            // console.log(data);}
        );  
        
        return this.post;
    }
    fetchPosts(){
        this.http.get<Post[]>("http://localhost:8083/post/all/").subscribe(
            data=>{this.convert(data);}
            // console.log(data);}
        );
    }

    convert(data:Post[]){
        this.posts = [];
        data.forEach(p => {
            
            this.posts.push(p);
            // console.log(p)
        });
    }

    convertPostsByBlogger(data:Post[]){
        this.userPosts = [];
        data.forEach(p => {
            
            this.userPosts.push(p);
            // console.log(p)
        });
    }

    getPostsByBlogger(id: any): any {
        this.http.get<Post[]>("http://localhost:8083/post/all/byblogger/"+id).subscribe(
            data=>{this.convertPostsByBlogger(data);}
        );
    }


}