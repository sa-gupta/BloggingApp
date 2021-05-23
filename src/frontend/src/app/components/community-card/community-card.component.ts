import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommunityService } from 'src/app/service/community-service';

@Component({
  selector: 'app-community-card',
  templateUrl: './community-card.component.html',
  styleUrls: ['./community-card.component.css']
})
export class CommunityCardComponent implements OnInit {

  @Input() communityId: number = 0;
  @Input() communityName: string = "";
  @Input() communityDescription: string = "";
  @Input() flairs: Array<string> =[];


  constructor(communityService:CommunityService,private router:Router) { }

  ngOnInit(): void {
  }

  routerToCommunityPage(id: number){
    this.router.navigate([
      'community/'+id
    ]);

  }

}
