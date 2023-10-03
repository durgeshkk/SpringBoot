package com.api.book.bootrestbookdb.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    // Final since no need to change it again
    // public final String UPLOAD_DIR="E:\\Courses\\Code with Durgesh Spring Boot\\bootrestbookdbfiles\\src\\main\\resources\\static\\image";
    // The prblm is solved by ClassPathResource which will give us path of res and 
    // we will just provide the path within resource folder where we wanna save 
    // the data
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
    // But the above code might give IOException so just handle it
    public FileUploadHelper() throws IOException{
        
    }


    // Try uploading the file
    public boolean uploadFile(MultipartFile f){
        boolean flag = false;//to keep the track if file is uploaded or not
        try{
            // Lengthy
            /*
            // Read the data from File
            InputStream is = f.getInputStream();
            // Create an Array jitna data aa rha h uska
            byte data[] = new byte[is.available()];
            is.read(data);

            // Write the data to UPLOAD_DIR
            // To write we have the location but we need to create a new file in the img
            // f.getOriginalFilename() : will create the file in img with same name
            // "\\" can be replaced by File.separator()
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+f.getOriginalFilename());
            // Now write the data 
            fos.write(data);

            // Flush and close
            fos.flush();fos.close();
            */

            // Shortcut comes in : 
            // in : I/P Stream, tar:where to write, options: replace or not
            // But now UPLOAD_DIR+"\\"+f.getOriginalFilename() is String and we need to pass 
            // Path so use Paths.get();
            Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+"\\"+f.getOriginalFilename()),
             StandardCopyOption.REPLACE_EXISTING);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
