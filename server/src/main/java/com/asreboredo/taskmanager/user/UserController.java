package com.asreboredo.taskmanager.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
public class UserController {

    /**
     * Base URL for the User API endpoint
     */
    private static final String API_STRING = "/user";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = API_STRING)
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = API_STRING + "/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = API_STRING)
    public void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = API_STRING + "/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        this.userService.updateUser(user, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = API_STRING + "/{id}")
    public void deleteUser(@PathVariable Long id) {
        Optional<User> aux = this.userService.getUser(id);
        if (aux.isPresent()) {
            this.userService.deleteUser(aux.get());
        }
    }

}