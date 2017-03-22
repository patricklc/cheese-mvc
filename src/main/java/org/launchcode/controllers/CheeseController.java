package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Patrick on 3/9/2017.
 */
@Controller
@RequestMapping("cheese")

public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute("Cheese") Cheese cheese ) {
        cheeses.put(cheese.getCheeseName(), cheese.getDescription());

        // redirect to /cheese
        return "redirect:";

    }
    // Request path: POST /cheese/delete
    // Deletes cheeses
    // Redirects to index
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("delete") ArrayList<String> cheesesToDelete) {
        for (String cheeseToDelete : cheesesToDelete) {
            cheeses.remove(cheeseToDelete);
        }
        return "redirect:";

    }

}
