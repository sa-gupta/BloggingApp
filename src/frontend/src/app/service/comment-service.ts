import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { PostComment } from "../model/comment";

@Injectable({
    providedIn: 'root'
})
export class CommentService{
    addCommentToDb(comment: PostComment) {
        const headers = { 'content-type': 'application/json'};
        const body=JSON.stringify(comment);  
        console.log('---------');
        console.log(body);
         this.http.post<boolean>('http://localhost:8083/comment/add',body,{'headers':headers}).subscribe(
           data=>{
            //    comment.commentId=data.commentId;
        console.log(data);
    }
         );
    }

    comments:Array<PostComment> = [];
   

    constructor(private http:HttpClient){

    }
    fetchComment(id:number){
        this.http.get<PostComment[]>("http://localhost:8083/comment/all/"+id).subscribe(
            data=>{this.comments = [];
                this.convert(data);}
        );

        
    }

    convert(data:PostComment[]){
        
        data.forEach(c => {
            this.comments.push(c);
            console.log(c);
        });
    }
}