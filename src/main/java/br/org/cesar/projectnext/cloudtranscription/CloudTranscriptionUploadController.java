package br.org.cesar.projectnext.cloudtranscription;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
// public class CloudTranscriptionUploadController {
//     @PostMapping("/uploadFile")
//     public ResponseEntity<CloudTranscriptionModel> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//         String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//         CloudTranscriptionModel response = new CloudTranscriptionModel(fileName);
//         response.setFileName(fileName);
//         return new ResponseEntity<>(response, HttpStatus.OK);
//     }
// }
 

public class CloudTranscriptionUploadController {
    @PostMapping("/uploadFile")
    public ResponseEntity<CloudTranscriptionModel> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        CloudTranscriptionUtil.saveFile(fileName, multipartFile);

        CloudTranscriptionModel response = new CloudTranscriptionModel();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}