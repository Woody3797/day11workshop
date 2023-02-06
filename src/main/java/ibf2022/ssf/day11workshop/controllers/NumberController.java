package ibf2022.ssf.day11workshop.controllers;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/index.html", "/index", "/"}, produces = MediaType.TEXT_HTML_VALUE)
public class NumberController {
    
    private Logger logger = Logger.getLogger(NumberController.class.getName());

    @GetMapping
    public String getNumber(Model model) {
        Random rand = new Random();
        int imageNum = rand.nextInt(31);
        String number = String.valueOf(imageNum);

        model.addAttribute("number", number);

        logger.log(Level.INFO, "imageNum = %d".formatted(imageNum));

        // render template with model
        return "index";
    }
}
