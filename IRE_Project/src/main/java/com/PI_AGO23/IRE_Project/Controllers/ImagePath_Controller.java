package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Services.I_Upload_Images;
import com.PI_AGO23.IRE_Project.Services.Implementation.UploadFilesServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class ImagePath_Controller {

    @Autowired I_Upload_Images iUploadImages;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(iUploadImages.handleFileUpload(file), HttpStatus.OK);
    }

}
