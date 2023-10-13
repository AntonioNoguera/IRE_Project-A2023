package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Repositories.I_Image_pseudoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Image")
public class Image_Controller {

    @Autowired
    I_Image_pseudoRepo imagePseudoRepo;

    @PostMapping("/{id}")
    private ResponseEntity<String> set_Picture(@RequestParam("file") MultipartFile file, @PathVariable("id") long id) throws Exception {
        return new ResponseEntity<>(imagePseudoRepo.handleFileUpload(file, id), HttpStatus.OK);
    }

}