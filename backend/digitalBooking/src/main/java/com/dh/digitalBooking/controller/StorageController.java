package com.dh.digitalBooking.controller;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.dh.digitalBooking.model.UploadBean;
import com.dh.digitalBooking.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @DeleteMapping("/erase")
    public String erase(@RequestParam(value= "fileName") final String fileName) {
        storageService.eraseFile("Productos/"+fileName);
        return "Se borro!";
    }

    @PostMapping("/upload")
    public String upload(@RequestBody UploadBean uploadBean) {
        storageService.store(uploadBean);
        return "Upload Success!";
    }
}



