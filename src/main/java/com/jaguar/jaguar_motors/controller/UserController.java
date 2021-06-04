package com.jaguar.jaguar_motors.controller;


import com.jaguar.jaguar_motors.repository.UserRepository;
import com.jaguar.jaguar_motors.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserModel n = new UserModel();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserModel> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
