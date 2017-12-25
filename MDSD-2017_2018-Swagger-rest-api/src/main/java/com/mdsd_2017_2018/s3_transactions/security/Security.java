package com.mdsd_2017_2018.s3_transactions.security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.mdsd_2017_2018.s3_transactions.standard.AppConstant;

public class Security {

	private String ioFileCredential = AppConstant.CREDENTIALS_PATH;

	public Security() {

	}

	public Security(String credentialsPath) {
		this.ioFileCredential = credentialsPath;
	}

	public AWSCredentials getCredentials() {
		File credentials1 = new File(this.ioFileCredential);
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(credentials1));
			line = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AWSCredentials credentials = new BasicAWSCredentials(line.split(",")[0], line.split(",")[1]);
		return credentials;
	}

	public String getIoFileCredential() {
		return ioFileCredential;
	}

	public void setIoFileCredential(String ioFileCredential) {
		this.ioFileCredential = ioFileCredential;
	}
}
