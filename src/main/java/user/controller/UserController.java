package user.controller;

import org.springframework.web.bind.annotation.*;
import user.model.User;
import user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null || user.getId() == 0) {
            userService.addUser(user);
        } else {
            User usLost = userService.getUserById(user.getId());
            Date date= usLost.getCreatedDate();
            userService.updateUser(user, date);
        }
        return "redirect:/";
    }

    @RequestMapping("/search/")
    public String search(@RequestParam("name") String name, Model model) {
        if (userService.findUsers(name).size()!=0) {
            model.addAttribute("user", new User());
            model.addAttribute("users", userService.findUsers(name));
         return "users";
        }
         else {
            return "redirect:/";
        }
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("users", userService.listUsers());

        return "users";
    }

    @RequestMapping("/filter/edit/{id}")
    public String editInFilter(@PathVariable("id") Long id, Model model) {
        return editUser(id, model);
    }

    @RequestMapping("/fill")
    public String fillUsers() {
        userService.fillUsers();

        return "redirect:/";
    }
}
