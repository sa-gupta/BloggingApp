export class Blogger{
    userId: number;
    bloggerName: string;
    karma: number;
    password:string;
    communityName: Array<string>;
    
    constructor(userId: number, bloggerName: string, karma: number, password:string, communityName: Array<string>){
        this.userId = userId; 
        this.bloggerName = bloggerName;
        this.karma = karma;
        this.password = password;
        this.communityName = communityName;
    }
    
}

