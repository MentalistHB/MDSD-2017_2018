package com.mdsd_2017_2018.s3_transactions.service;

import java.io.InputStream;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mdsd_2017_2018.s3_transactions.file_management.FileManagement;
import com.mdsd_2017_2018.s3_transactions.security.Security;
import com.mdsd_2017_2018.s3_transactions.standard.AppConstant;

public class FileTransaction implements FileManagement {

	@SuppressWarnings("deprecation")
	public String upload(String keyName, InputStream file, long size) {

		Security security = new Security();
		AWSCredentials credentials = security.getCredentials();
		AmazonS3 s3client = new AmazonS3Client(credentials);
		Region usEast2 = Region.getRegion(Regions.EU_WEST_1);
		s3client.setRegion(usEast2);
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(size);
			PutObjectRequest req = new PutObjectRequest(AppConstant.BUCKET_NAME, keyName, file, meta);
			req.setCannedAcl(CannedAccessControlList.PublicRead);
			s3client.putObject(req);

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which " + "means your request made it "
					+ "to Amazon S3, but was rejected with an error response" + " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " + "means the client encountered "
					+ "an internal error while trying to " + "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
		return ((AmazonS3Client) s3client).getResourceUrl(AppConstant.BUCKET_NAME, keyName);
	}

	@SuppressWarnings("deprecation")
	public void delete(String keyName) {
		Security security = new Security();
		AWSCredentials credentials = security.getCredentials();
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		// Region usEast2 = Region.getRegion(Regions.US_EAST_2);

		try {
			s3Client.deleteObject(new DeleteObjectRequest(AppConstant.BUCKET_NAME, keyName));
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException.");
			System.out.println("Error Message: " + ace.getMessage());
		}

	}

}
