package com.test.circulation_predictor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles page redirection.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
@Controller
public class PageController {

    /**
     * Redirects root ("/") requests to index.html.
     * 
     * @return Redirect to index.html located in the static folder.
     */
    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:/index.html";
    }
}
