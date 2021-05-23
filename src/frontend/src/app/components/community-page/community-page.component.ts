import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunityService } from 'src/app/service/community-service';

@Component({
  selector: 'app-community-page',
  templateUrl: './community-page.component.html',
  styleUrls: ['./community-page.component.css']
})
export class CommunityPageComponent implements OnInit {

  router:Router;
  communityService: CommunityService;
  constructor(router:Router, communityService:CommunityService) { 
    this.router = router;
    this.communityService = communityService;
  }

  ngOnInit(): void {
    this.communityService.fetchCommunities();
  }

  routeToAddCommunity(){
    this.router.navigate([
      'add-community/'
    ]);
  }

}
