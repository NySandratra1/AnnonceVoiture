package mg.valian.tsiaro.springbootdemo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;


import io.jsonwebtoken.io.IOException;

@Service
public class ImageService {

    public String uploadFile(File file, String fileName) throws IOException, FileNotFoundException, java.io.IOException {
    BlobId blobId = BlobId.of("kinaka-a4d8e.appspot.com", "image/" + fileName); // Replace with your bucket name
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
    try (InputStream inputStream = new FileInputStream(file)) {
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, inputStream);
    }
  
    String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/kinaka-a4d8e.appspot.com/o/%s?alt=media";
    return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
}
  
    public File convertToFile(MultipartFile multipartFile, String fileName) throws IOException, FileNotFoundException, java.io.IOException {
    File tempFile = new File(fileName);
    try (OutputStream outputStream = new FileOutputStream(tempFile);
         InputStream inputStream = multipartFile.getInputStream()) {
        byte[] buffer = new byte[8192]; // 8KB buffer size
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    } catch (IOException e) {
        throw e; // Rethrow the exception
    }
    return tempFile;
}
  
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
  
  
    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.
  
            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }
  
  }
