package com.PI_AGO23.IRE_Project.Services;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

public interface I_Upload_Images  {
    String handleFileUpload(MultipartFile file) throws Exception;
}
