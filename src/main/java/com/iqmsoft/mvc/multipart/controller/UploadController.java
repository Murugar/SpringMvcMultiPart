package com.iqmsoft.mvc.multipart.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iqmsoft.mvc.multipart.service.FileUploadService;

@RestController
public class UploadController {

	@Autowired
	FileUploadService fileUploadService;


	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFileHandler(
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				
				File serverFile = fileUploadService.load(file);

				if(serverFile != null)
				     return new ResponseEntity<>("{}", HttpStatus.OK);
				else
					return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
	
			} catch (Exception e) {
				
				return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			System.err.println("File was empty");
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
