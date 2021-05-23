import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from '../../service/book-service';

@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css']
})
export class ShowBookComponent implements OnInit {
  bookService:BookService;
  router: Router;
  constructor( bookService:BookService, router:Router) { 
    this.bookService = bookService;
    this.router = router;
  }

  ngOnInit(): void {
  }

  updateBook(id:number){
    this.bookService
    this.router.navigate([
      'update-book/'+id
    ]);
  }
}