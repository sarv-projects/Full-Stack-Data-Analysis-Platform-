package com.sarvesh.datainsight.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/api/files")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class FileController {
    private static final String UPLOAD_DIR = "C:/Users/Sonali/Desktop/fsspringdjangoreact/resume projects/data-insight/uploaded-files/";
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a csv file to upload!!");
        }
        try{
            // ... inside the try block of the uploadFile method ...

// Create the upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // mkdirs() creates parent directories if needed
            }

// Get the file's original name and create a path for it
            String originalFilename = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, originalFilename);

// Save the file to the specified path
            file.transferTo(filePath);

            System.out.println("File saved to: " + filePath.toAbsolutePath());

// ... rest of the method ...
            return ResponseEntity.status(HttpStatus.OK).body("File "+file.getOriginalFilename()+"uploaded successfully!");
        }catch (Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! "+e.getMessage());
        }
    }
}
