package com.iqmsoft.mvc.multipart.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileUploadService {

	

	public File load(MultipartFile file) throws IOException, FileNotFoundException {
		byte[] bytes = file.getBytes();
		String name = file.getOriginalFilename();
		// Creating the directory to store file
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "tmpFiles");
		if (!dir.exists())
			dir.mkdirs();
	
		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath()
				+ File.separator + name);
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		
		System.out.println("Uploaded file " + serverFile.getName());
		
		return serverFile;
	}
}
