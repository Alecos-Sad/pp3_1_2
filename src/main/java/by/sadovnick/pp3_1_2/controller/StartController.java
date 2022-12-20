package by.sadovnick.pp3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {

    @GetMapping(value = "/")
    public String startApp (ModelMap model){
        List<String> messages = new ArrayList<>();
        messages.add("START!");
        messages.add("HEY HEY");
        model.addAttribute("messages", messages);
        return "start";
    }
}
