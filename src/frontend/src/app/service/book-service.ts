import { Injectable } from "@angular/core";
import { Book } from "../model/book";


@Injectable ({
    providedIn:'root'
})
export class BookService{
    books:Array<Book>=[];
    idExists(id: any):boolean {
        if(this.books.find(b=>b.id==id)){
            return true;
        }
        return false;
    }
    updatedBook(book: Book):boolean {
      let bookToUpdate = this.books.find(b=>b.id==book.id);
      if(bookToUpdate){
        bookToUpdate.title=book.title;
        bookToUpdate.author=book.author;
        bookToUpdate.price=book.price;
        return true;
      }
      return false;
    }
    getBook(id: any):Book {
        let book:Book=new Book();
        //book=this.books.find(b=>b.id==id);
        for(let i=0;i<this.books.length;i++){
            let b=this.books[i];
            if(b.id==id){
                book=b;
                break;
            }
        }
        return book;
    }
}