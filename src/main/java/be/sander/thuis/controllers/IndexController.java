package be.sander.thuis.controllers;

import be.sander.thuis.services.KattenbakService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private final KattenbakService kattenbakService;

    public IndexController(KattenbakService kattenbakService) {
        this.kattenbakService = kattenbakService;
    }


    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index", "Allekattenbakken",kattenbakService.findAllByDatum());
    }
}
