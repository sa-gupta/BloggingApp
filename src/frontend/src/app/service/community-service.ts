import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Community } from "../model/community";

@Injectable({
    providedIn: 'root'
})
export class CommunityService {
  

    communities:Array<Community> = [];
    community:Community = new Community(0,"","",0,0,new Date(),[],[],[],[]);
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

getCommunity(id: number): any {
  // let community;
  this.http.get<Community>("http://localhost:8083/community/" + id).subscribe(
    data => {
      // console.log(data);
      this.community = data;
      // console.log(this.community);
    }
  );
  // return community;
}

}