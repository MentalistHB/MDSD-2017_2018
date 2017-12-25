package com.mdsd_2017_2018.s3_transactions.file_management;

import java.io.InputStream;

public interface FileManagement {

	public String upload(String keyName, InputStream file, long size);

	public void delete(String keyName);
}
