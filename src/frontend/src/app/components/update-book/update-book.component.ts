import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../../model/book';
import { BookService } from '../../service/book-service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  book:Book;
  router:Router;
  constructor(private route:ActivatedRoute, private bookService:BookService, router:Router) {
    this.book=new Book();
    this.router = router;
   }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.book=this.bookService.getBook(id);
    console.log(this.book);
  }
  updateBook(book:Book){
    if(this.bookService.updatedBook(book)){
       alert('Book updated successfully');
       this.router.navigate([
        'show-all'
      ]);
    }
    else{
      alert("Book not found");
      this.router.navigate([
        'show-all'
      ]);
    }
  }
}
