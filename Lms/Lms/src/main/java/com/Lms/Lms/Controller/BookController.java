package com.Lms.Lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Lms.Lms.Entity.Book;
import com.Lms.Lms.Service.BookService;

@Controller


public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/h")
    public String home() {
        return "home";
    }
    
   // @GetMapping("/books")
    //public List<Book> getAllBooks() {
     //   return bookService.findAll();
   // }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/save")
	public String creatBook(@ModelAttribute Book book) {
		//TODO: process POST request
		bookService.save(book);
		return "redirect:/books";
    }
    @GetMapping("/create")
    public String addBooks() {
    	return "AddBook";
    }
    
    @GetMapping("/books")
	public ModelAndView getApplicables() {
		//TODO: process POST request
		List<Book>list=bookService.findAll();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Application");
//		mv.addObject("Jobs",list);
		return new ModelAndView("books","book",list);
	}
    

    @PutMapping("/editb/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Additional logic to ensure you're updating the correct book
        return bookService.save(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    // ... other endpoints ...

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}