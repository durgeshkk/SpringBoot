package com.api.book.bootrestbookdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbookdb.helper.FileUploadHelper;

/*
 * We are now creating a end point which mean we are going to create a Controller 
 * on which we are going to upload/submit a file. 
 */

//  For Rest APIs
 @RestController
public class FileUploadController {
    
    @Autowired
    private FileUploadHelper fileUploadHelper;

    // So now to upload the file hit the below URL
    /*
     * Steps to upload file in Postman : 
     * Body->form data->(in Key select file)->(in value upload file)->send
     * key will the name by which we wanna save the file in the destination folder
     * Setting key as Result currently
     */

     /*
      * To Receive data :
      We simply need to take form data and so we will take I/p as ResponseParam
      passing parameter to it as the key_name provided in postman
      Now datatype to handle the file is MultipartFile
      */
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("Result") MultipartFile f){
        // Just checking if file name is taken in f
        System.out.println(f.getOriginalFilename());
        System.out.println(f.getSize());//returns in type of byte
        System.out.println(f.getContentType());
        System.out.println(f.getName());//key_name
        
        try{
            // Validation
            if(f.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Req must contain file");
            }
            
            // To take only file as jpg just apply condition if f.getContentType() == image/jpg
            // Then only take as i/p else return error
            if(!f.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file allowed");
            }
            
            // File Uploading
            /*
            For simplicity create a different class and call itzz Object here for File Uploadign
                * 1. Where to Upload on Server?? UPLOAD_DIR must be set
                * Curr DIR = E:\Courses\Code with Durgesh Spring Boot\bootrestbookdbfiles\src\main\resources\static\image
                * 2. 
                */
            boolean flag = fileUploadHelper.uploadFile(f);
            if(flag){
                return ResponseEntity.ok("File Uploaded Successfully...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went WRONG!!");
        /*
         * One Problem : We are serving the Target files and are saving the files in 
         * src folder so we need to update this else it will create the prblm!!
         */
    }
}
