import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  trainee1:string="";
  flag = false;
  constructor() { }

  ngOnInit(): void {
  }

  fun(trainee:any){
    // alert("clicked");
    // this.flag = !this.flag;
    // alert("Hi ! "+trainee);       
    this.trainee1 = trainee;
  }

}
