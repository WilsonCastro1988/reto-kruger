package com.kruger.ec.controller.utilities;

import com.kruger.ec.dto.utilities.EmailValuesDTO;
import com.kruger.ec.service.utilities.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE,
        RequestMethod.OPTIONS})
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailValuesDTO dto) {
        emailService.sendEmail(dto);
        return new ResponseEntity("Correo enviado con éxito", HttpStatus.OK);
    }

    @PostMapping("/send-html")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        emailService.sendEmailTemplate(dto);
        return new ResponseEntity("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }
}
