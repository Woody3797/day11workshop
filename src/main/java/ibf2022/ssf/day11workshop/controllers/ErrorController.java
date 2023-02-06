package ibf2022.ssf.day11workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/error", "error"})
public class ErrorController {

    @GetMapping
    public String showError() {
        
        return "error";
    }
    
}
