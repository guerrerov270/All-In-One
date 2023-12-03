package com.allinone.demo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.net.URL;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	private final AmazonS3 s3Client;

	public S3Service() {
		this.s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
	}

	public String generatePresignedUrl(String objectKey) {
		Date expiration = new Date();
		long expTimeMillis = expiration.getTime();
		expTimeMillis += 1000 * 60 * 60; // 1 hour
		expiration.setTime(expTimeMillis);

		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
				.withMethod(HttpMethod.GET).withExpiration(expiration);

		// Optionally, you can set response headers for caching or other purposes
		ResponseHeaderOverrides responseHeaders = new ResponseHeaderOverrides();
		responseHeaders.setContentDisposition("inline");
		generatePresignedUrlRequest.setResponseHeaders(responseHeaders);

		URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);

		return url.toString();
	}
}
