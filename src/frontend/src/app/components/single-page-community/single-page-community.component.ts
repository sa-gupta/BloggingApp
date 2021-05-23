import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Community } from 'src/app/model/community';
import { CommunityService } from 'src/app/service/community-service';

@Component({
  selector: 'app-single-page-community',
  templateUrl: './single-page-community.component.html',
  styleUrls: ['./single-page-community.component.css']
})
export class SinglePageCommunityComponent implements OnInit {

  // community:Community;
  communityServ:CommunityService;
  constructor(router:Router, communityServ:CommunityService, private route:ActivatedRoute) {
    // this.community = new Community(0,"","",0,0,new Date(),[],[],[],[]);
    this.communityServ = communityServ;
   }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.communityServ.getCommunity(id);
  }

}
