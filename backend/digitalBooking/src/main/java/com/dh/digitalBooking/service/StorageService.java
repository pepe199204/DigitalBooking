package com.dh.digitalBooking.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.dh.digitalBooking.model.Imagen;
import com.dh.digitalBooking.model.UploadBean;
import com.dh.digitalBooking.repository.ImagenRepository;
import com.dh.digitalBooking.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Log4j2
@Service
public class StorageService {

    private AmazonS3 s3client;

    private static String defaultRegion = "us-east-2";

    @Value("${amazonProperties.endpointUrl.usEast}")
    private String defaultEndpointUrl;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.accessKey}")
    private String accessKey;

    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    @Autowired
    private ImagenService imagenService;

    private void uploadFileTos3bucket(String fileName, File file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setCacheControl("51635000");
        metadata.setExpirationTime(Utils.getTwentyYearsFromNow());
        s3client.putObject(new PutObjectRequest(bucketName, "Productos/"+fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead).withMetadata(metadata));
    }

    void buildAmazonS3Client(String defaultRegion, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        AmazonS3ClientBuilder amazons3ClientBuilder = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, defaultRegion));
        this.s3client = amazons3ClientBuilder.build();
    }

    public void eraseFile(String urlImagen){
        buildAmazonS3Client(defaultRegion, defaultEndpointUrl);
        s3client.deleteObject(new DeleteObjectRequest(bucketName, urlImagen));
        log.info("Se borro una imagen.");
    }

    public String store(UploadBean uploadBean) {
        String fileName = uploadBean.getName();
        String fileUrl = "";
        try {
            File file = Utils.getImageFromBase64(uploadBean.getImage(), fileName);
            buildAmazonS3Client(defaultRegion, defaultEndpointUrl);
            fileUrl = defaultEndpointUrl + "/" + bucketName + "/Productos/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
            log.info("File uploaded to S3 successfully");
        } catch (Exception e) {
            log.error("Error while uploadeding the file to S3" + e);
            // fileUrl = "exception: "+e.getMessage();
            throw e;
        }
        log.info("Uploaded image with url: " +fileUrl);
        return fileUrl;
    }

}
