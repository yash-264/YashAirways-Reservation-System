package yash.s.project.Airline.Reservation.System.Yash.Maincantrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yash.s.project.Airline.Reservation.System.Yash.Entity.User;
import yash.s.project.Airline.Reservation.System.Yash.Services.EmailServices;
import yash.s.project.Airline.Reservation.System.Yash.Services.UserServices;
import yash.s.project.Airline.Reservation.System.Yash.enums.Role;


@RestController
@RequestMapping("/create/user")
public class PublicCantrollerForCreateUser {


    @Autowired
    private UserServices userServices;

    @Autowired
    private EmailServices emailServices;

    @PostMapping
    public ResponseEntity<?> CreateUser(@RequestBody User newUser) {


        if (newUser.getRole().equals(Role.user)){

            userServices.save(newUser);

            emailServices.sendSignupEmail(newUser.getGmail(), newUser.getUsername());

            return new ResponseEntity<>("User registered successfully, and a confirmation email has been sent!",HttpStatus.CREATED);
        }

        return new ResponseEntity<>(" Not authorized to create an admin. Please select role 'user'.or username already exist.",HttpStatus.BAD_REQUEST);

    }

}
