package com.hari.ecommerce.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.multipart.support.MultipartFilter;
// import org.springframework.web.multipart.support.MultipartFilter;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AwsS3Service {
    public final String bucketName="myecommercebucketbyhari";
    
    @Value("${aws.s3.access}")
    private String awsS3AccessKey;

    @Value("${aws.s3.secrete}")
    private String awsS3SecreteKey;

    public String saveImageToS3(MultipartFile photo){
        try{
            String s3Filename=photo.getOriginalFilename();
            BasicAWSCredentials awsCredentials=new BasicAWSCredentials(awsS3AccessKey, awsS3SecreteKey);
            AmazonS3 s3Client= AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
            .withRegion(Regions.US_EAST_1)
            .build();

            InputStream inputStream=photo.getInputStream();
            
            ObjectMetadata metadata=new ObjectMetadata();
            metadata.setContentType("image/jpeg");
            PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName, s3Filename, inputStream,metadata);
            s3Client.putObject(putObjectRequest);

            return "https://"+bucketName+".s3.us-east-1.amazonaws.com/"+s3Filename;

        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("Unable to upload image to s3 bucket: "+e.getMessage());
        }

    }

}
