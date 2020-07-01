package be.sander.thuis.controllers;

import be.sander.thuis.domain.Kattenbak;
import be.sander.thuis.services.KattenbakService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/kattenbak")
public class KattenbakController {

    private final KattenbakService kattenbakService;

    public KattenbakController(KattenbakService kattenbakService) {
        this.kattenbakService = kattenbakService;
    }

    public Map<String, Long> top3() {
        long sanderKattenbak = kattenbakService.countByNaam("sander");
        long fraukeKattenbak = kattenbakService.countByNaam("frauke");
        long anjaKattenbak = kattenbakService.countByNaam("anja");

        Map<String, Long> top3 = new LinkedHashMap<>();

        top3.put("sander", sanderKattenbak);
        top3.put("frauke", fraukeKattenbak);
        top3.put("anja", anjaKattenbak);

        //sort by values, and reserve it
        final Map<String, Long> result = top3.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Long>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }

    @GetMapping
    public ModelAndView kattenbak() {
        ModelAndView modelAndView = new ModelAndView("kattenbak");
        Kattenbak kattenbak = new Kattenbak(null, null);
        modelAndView.addObject("kattenbak", kattenbak)
                .addObject("top3", top3())
                .addObject("Allekattenbakken", kattenbakService.findAllByDatum());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView aanmakenKattenbak() {
        ModelAndView modelAndView = new ModelAndView("kattenbak");
        Kattenbak kattenbak = new Kattenbak(null, null);
        modelAndView.addObject("kattenbak", kattenbak);
        return modelAndView;
    }

    @PostMapping("toevoegen")
    public String aanmakenKattenbak(@Valid Kattenbak kattenbak, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("test");
            return "redirect:/kattenbak";
        }
        kattenbakService.create(kattenbak);
        System.out.println("kattenbak aangemaakt");

        return "redirect:/kattenbak";
    }
}
