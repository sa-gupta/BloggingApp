import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Blogger } from "../model/blogger";

@Injectable({
    providedIn: 'root'
})
export class BloggerService{
  blogger:Blogger = new Blogger(0,"",0,"",[]);

    fetchBlogger(id: any, role: any) {
    if(role=="BLOGGER"){
        this.http.get<Blogger>("http://localhost:8083/blogger/view/"+id).subscribe(
            data=>{this.blogger = data;
                console.log(this.blogger);    
            }
        );
    }
    // }else{
    //     // this.http.get<Blogger>("http://localhost:8083/post/all/").subscribe(
    //     //     data=>{
    //     //         this.blogger = this.convert(data);}
    //     // );
    // }
  }
    // convert(data: any): Blogger {
    // }
  constructor( private http:HttpClient){
    // this.blogger = blogger;
  }

}