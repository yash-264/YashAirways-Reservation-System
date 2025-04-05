package yash.s.project.Airline.Reservation.System.Yash.Maincantrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import yash.s.project.Airline.Reservation.System.Yash.Entity.User;
import yash.s.project.Airline.Reservation.System.Yash.Services.UserServices;
import yash.s.project.Airline.Reservation.System.Yash.enums.Role;

@RestController
@RequestMapping("/login/yash/airlines")
public class LoginCantroller {



    @Autowired
    private UserServices userServices;

    @GetMapping

    public ResponseEntity<?> login(){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

        String username=authentication.getName();

        User user=userServices.findUserByUserName(username);

        Role role=user.getRole();


        return new ResponseEntity<>(
                "🌟 Welcome aboard YashAirways Reservation System – Where Your Journey Takes Flight! 🌟\n\n" +
                        "🎉 DASHBOARD ACCESSED SUCCESSFULLY! 🎉\n\n" +
                        "Role: " + role + "\n" +
                        "Username: " + username,

                HttpStatus.ACCEPTED
        );
    }

}
