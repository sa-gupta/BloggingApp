import { Blogger } from "./blogger";
import { PostComment } from "./comment";
import { Community } from "./community";

export class Post {
    postId:number;
    title:string;
    data:string;
    createdBy:string;
    createdDateTime:Date;
    flair:string;
    community:string;
    comments:Array<PostComment>;
    communityId:number;
    bloggerId:number; 
    postType:string;
    

    constructor(postId:number, title:string, data:string, createdBy:string, createdDateTime:Date, flair:string, community:string,
    communityId:number, comments:Array<PostComment>,bloggerId:number,postType:string){
        this.postId = postId;
        this.title = title;
        this.data = data;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
        this.community = community;
        this.flair = flair;
        this.comments = comments;
        this.communityId = communityId;
        this.bloggerId = bloggerId;
        this.postType = postType;
    }

    
}