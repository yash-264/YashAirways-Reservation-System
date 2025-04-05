package yash.s.project.Airline.Reservation.System.Yash.Maincantrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yash.s.project.Airline.Reservation.System.Yash.Entity.User;
import yash.s.project.Airline.Reservation.System.Yash.Repositories.UserRepository;
import yash.s.project.Airline.Reservation.System.Yash.Services.EmailServices;
import yash.s.project.Airline.Reservation.System.Yash.Services.UserServices;
import yash.s.project.Airline.Reservation.System.Yash.enums.Role;



@RestController
@RequestMapping("/create/admin")
public class AdminCreationCantroller {

    @Autowired
    private UserServices userServices;

    @Autowired
    private EmailServices emailServices;

    @Value("${admin.creation.passkey}")
    private String adminCreationPasskey;

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestParam("passkey") String passkey, @RequestBody User newAdmin) {

        if (!passkey.equals(adminCreationPasskey)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid passkey! You are not authorized to create an admin.");
        }

        newAdmin.setRole(Role.admin);

        userServices.save(newAdmin);

        emailServices.sendAdminCreationEmail(newAdmin.getGmail(), newAdmin.getUsername());


        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Admin successfully created!");
    }

}

