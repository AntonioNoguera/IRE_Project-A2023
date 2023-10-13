package com.PI_AGO23.IRE_Project.Repositories;

import org.springframework.web.multipart.MultipartFile;

public interface I_Image_pseudoRepo  {
    String handleFileUpload(MultipartFile file, long id) throws Exception;
}