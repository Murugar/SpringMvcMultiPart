package com.iqmsoft.mvc.multipart.model;

public class FileUpload {

	public FileUpload(String filename, byte[] file, String mimeType) {

		this.file = file;
		this.filename = filename;
		this.mimeType = mimeType;
	}

	
	
	private String filename;

	private byte[] file;

	private String mimeType;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
