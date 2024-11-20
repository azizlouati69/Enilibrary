package enilibrary.EniLibrary.controllers;


import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.repositories.RoleRepository;
import enilibrary.EniLibrary.repositories.UserRepository;
import enilibrary.EniLibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userServ;

    @Autowired
    RoleRepository roleRepository;







    @PostMapping(value = "/adduser")
    public User addUser(@RequestBody User user )
    {
        return userServ.addUser(user);
    }

    @PostMapping(value = "/addListUser")
    public List<User> addListUser(@RequestBody List<User> listUser)
    {
        return userServ.addListUser(listUser);
    }



    @PutMapping("/{iduser}")
    public User updateuser(@RequestBody User user,@PathVariable("iduser") Long iduser)
    {
        return userServ.updateUser(user, iduser);
    }
    @DeleteMapping(value = "/del/{iduser}")
    public String deleteuser(@PathVariable Long iduser)
    {
        return userServ.deleteuser(iduser) ;
    }

    @GetMapping(value = "/getallusers")
    public List<User> getAllusers()
    {
        return userServ.getAllUsers() ;
    }

    @GetMapping(value = "/getuserStartWSC/{ch}")
    public List<User> getuserStartWSC(@PathVariable String ch)
    {
        return userServ.getListUsersStartWSC(ch);
    }

    @GetMapping(value = "/getuserFromUN/{ch}")
    public User getuserFromUN(@PathVariable String ch)
    {
        return userServ.findByUsername(ch);
    }

    @PostMapping(value = "/addUserRole/{iduser}/{idrole}")
    public User addUserRole(@PathVariable Long iduser, @PathVariable Long idrole)
    {
        return userServ.adduserRole(iduser, idrole);
    }

    @GetMapping(value = "/getiduserfridrole")
    public List<Long> getiduserfridrole()
    {
        return userServ.listiduserfromidrole();
    }

    @GetMapping(value = "/getiduserfridrole/{idrole}")
    public List<Long> getiduserfridrole(@PathVariable Long idrole)
    {
        return userServ.listiduserfromidrole(idrole);
    }
    @GetMapping(value = "/getuserfridrole/{idrole}")
    public List<User> getuserfridrole(@PathVariable Long idrole)
    {
        return userServ.listuserfromidrole(idrole);
    }




    @GetMapping("/count")
    public ResponseEntity<Long> getUserCount() {
        long userCount = userServ.countUsers();
        return ResponseEntity.ok(userCount);
    }




    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody  User user
   ) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body( ("Error: Email is already in use!"));
        }
        // Create new user's account
        User user1 =  new User(user.getUsername(),
                user.getEmail(),
                user.getPassword(), user.getAdresse(),user.getFname(),user.getLname() , user.getRole());


        userRepository.save(user1);
        return ResponseEntity.ok( ("User registered successfully!"));
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody  User user) {
        User user1 = userRepository.findByEmail(user.getEmail());

        // Check if the user exists and if the password matches
        if (user1 != null && user1.getPassword().equals(user.getPassword())) {
            // Authentication failed, return an error message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login successful for user: " + user.getEmail());
        } else {
            // User is authenticated, return a success message or user details
            return ResponseEntity.ok("Invalid username or password");
        }


    }

}