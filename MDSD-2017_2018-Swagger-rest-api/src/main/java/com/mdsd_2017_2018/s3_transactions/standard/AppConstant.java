package com.mdsd_2017_2018.s3_transactions.standard;

public class AppConstant {

	public static final String BUCKET_NAME = "mdsd20172018";
	public static final String CREDENTIALS_PATH = "src/main/resources/credentials.txt";
	public static final String TEST_FILE = "src/main/resources/test.txt";

	public static String getBucketName() {
		return BUCKET_NAME;
	}

	public static String getCredentialsPath() {
		return CREDENTIALS_PATH;
	}

}
