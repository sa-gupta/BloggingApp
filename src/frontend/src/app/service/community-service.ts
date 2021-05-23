import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Community } from "../model/community";

@Injectable({
    providedIn: 'root'
})
export class CommunityService {

    communities:Array<Community> = [];
    constructor(private http:HttpClient){

    }
  fetchCommunities() {
    this.http.get<Community[]>("http://localhost:8083/community/all").subscribe(
        data=>{this.convert(data);}
        // console.log(data);}
    );
  }

  convert(data:Community[]){
    this.communities = [];
    data.forEach(c => {
        
        this.communities.push(c);
        // console.log(p)
    });
}

}