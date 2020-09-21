package com.boot.pattern.controller.booksample;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.pattern.domain.Book;

@Controller
public class BookController {
	@GetMapping("/index.html")
	public String index() {
		return "books/index";
	}
	
	@GetMapping("/books.html")
	public String all(Model model) {
		model.addAttribute("books", Arrays.asList(new Book("isbn1", "토지", "박경리"), new Book("isbn2", "삼국지", "나관중"), new Book("isbn3", "개미", "베르나르")));
		return "books/list";
	}

	@GetMapping(value = "/books.html", params = "isbn")
	public String get(@RequestParam("isbn") String isbn, Model model) {
		if(StringUtils.isEmpty(isbn)) {
			model.addAttribute("book", new Book("not exist!", "not exist!", "not exist!"));
		} else {
			model.addAttribute("book", new Book(isbn, "찾음", "찾음"));
		}

		return "books/details";
	}

	/*@PostMapping("/books")
	public Book create(@ModelAttribute Book book) {
		return bookService.create(book);
	}*/
}
