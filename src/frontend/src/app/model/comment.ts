// import { Blogger } from "./blogger";
// import { Post } from "./post";

export class PostComment {
    commentId:number;
    commentDescription:string;
    bloggerName:string;
    createdOn: Date;
    votes:number;
    bloggerId:number;
    postId:number;

    constructor(commentId:number, commentDescription:string, bloggerName:string, createdOn: Date, votes:number,
        bloggerId:number, postId:number){
             
        this.commentId = commentId;
        this.commentDescription = commentDescription;
        this.bloggerName = bloggerName;
        this.createdOn = createdOn;
        this.votes = votes;
        this.bloggerId = bloggerId;
        this.postId = postId;

    }
}