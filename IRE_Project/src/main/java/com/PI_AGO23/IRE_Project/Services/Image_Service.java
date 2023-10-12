package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Repositories.I_Image_pseudoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class Image_Service implements I_Image_pseudoRepo {
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
                } catch (IOException e) {
                    // Manejar cualquier error de creación de la carpetar
                    return "Problems with the folder";
                }
            }
            Path filePath = folderPath.resolve(newFileName);

            try {
                // Supongo que 'bytes' es un arreglo de bytes que deseas escribir en el archivo
                Files.write(filePath, bytes);
                return "File Uploaded!";
            } catch (IOException e) {
                return "File Problem!";
                // Manejar cualquier error de escritura en el archivo
            }


        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }
}

