package com.fine.bookmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListController {
    @RequestMapping("/bookListPage")
    public String bookList() {
        return "bookList";
    }
}
