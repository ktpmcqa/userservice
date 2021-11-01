package ktpm.cqa.userservice.controller;

import ktpm.cqa.userservice.VO.UserVO;
import ktpm.cqa.userservice.entity.User;
import ktpm.cqa.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Homepage(){
        return "User service is running at port 8080";
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public UserVO getUserWithDepartmentById(@PathVariable("userId") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
