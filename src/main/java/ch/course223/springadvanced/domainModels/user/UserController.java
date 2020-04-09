package ch.course223.springadvanced.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/bestEarning")
    public @ResponseBody ResponseEntity<User> getBestEarningUser() {
        return new ResponseEntity<>(userService.getBestEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/worstEarning")
    public @ResponseBody ResponseEntity<User> getWorstEarningUser() {
        return new ResponseEntity<>(userService.getWorstEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/oddEarnings")
    public @ResponseBody ResponseEntity<List<User>> getUsersWithOddEarnings() {
        return new ResponseEntity<>(userService.allUsersWithOddEarnings(), HttpStatus.OK);
    }

    @GetMapping("/evenEarnings")
    public @ResponseBody ResponseEntity<List<User>> getUsersWithEvenEarnings() {
        return new ResponseEntity<>(userService.allUsersWithEvenEarnings(), HttpStatus.OK);
    }

    @GetMapping("/earningMoreThan")
    public @ResponseBody ResponseEntity<List<User>> getUsersEarnMoreThan(@RequestBody int min) {
        return new ResponseEntity<>(userService.allUsersEarningMoreThan(min), HttpStatus.OK);
    }

    @GetMapping("/earningLessThan")
    public @ResponseBody ResponseEntity<List<User>> getUsersEarnLessThan(@RequestBody int max) {
        return new ResponseEntity<>(userService.allUsersEarningLessThan(max), HttpStatus.OK);
    }

    @GetMapping("/earningBetween/{min}/{max}")
    public @ResponseBody ResponseEntity<List<User>> getUsersEarnBetween(@PathVariable int min, @PathVariable int max) {
        return new ResponseEntity<>(userService.allUsersEarningBetween(min, max), HttpStatus.OK);
    }

}
