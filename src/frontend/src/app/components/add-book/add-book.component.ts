import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../../model/book';
import { BookService } from '../../service/book-service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  book:Book;
  bookService:BookService;
  router:Router;
  // books:Array<Book>=[];

  constructor(bookService:BookService, router:Router) { 
    this.book = new Book();
    this.bookService = bookService;
    this.router = router;
  }

  ngOnInit(): void {
  }

  addBook(f:any){
    // this.books.push(f.value);
    if(this.bookService.idExists(f.value.id)){
      alert('Id already exist');
    }else{
      this.bookService.books.push(f.value);
      this.router.navigate([
        'show-all'
      ]);
      console.log(f);
    }
  }

}
