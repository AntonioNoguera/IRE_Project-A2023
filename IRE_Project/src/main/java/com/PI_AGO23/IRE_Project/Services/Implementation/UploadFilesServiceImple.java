package com.PI_AGO23.IRE_Project.Services.Implementation;

import com.PI_AGO23.IRE_Project.Services.I_Upload_Images;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFilesServiceImple implements I_Upload_Images {
    @Override
    public String handleFileUpload(MultipartFile file) throws Exception{
        try{
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5*1024*1024;
            if(fileSize>maxFileSize){
                return "File size must be smaller!";
            }

            if(
                    !fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".png")

            ){
                return "File Type "+ fileOriginalName +" Not Allowed";
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf('.'));
            String newFileName = fileName + fileExtension;



            Path folderPath = Paths.get("IRE_Project","src", "main", "resources", "images");
            if (!Files.exists(folderPath)) {
                try {

                    Files.createDirectories(folderPath);
                    return "Se Crea";
                } catch (IOException e) {
                    // Manejar cualquier error de creación de la carpetar
                    return "No se crea";
                }
            }
            Path filePath = folderPath.resolve(newFileName);

            try {
                // Supongo que 'bytes' es un arreglo de bytes que deseas escribir en el archivo
                Files.write(filePath, bytes);
                return System.getProperty("user.dir");
            } catch (IOException e) {
                return "File Problem!";
                // Manejar cualquier error de escritura en el archivo
            }


        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }
}

