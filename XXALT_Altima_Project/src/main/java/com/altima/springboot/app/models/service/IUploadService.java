package com.altima.springboot.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

	public Resource load(String filename) throws MalformedURLException;
	
	public String[] copy(MultipartFile file, MultipartFile file2) throws IOException;
	
	public String copy2(MultipartFile file) throws IOException;
	
	public boolean delete(String filename);
	
	public Resource loadTela(String filename) throws MalformedURLException;
	
	public String copyTela(MultipartFile file1) throws IOException;
	
	public boolean deleteTela(String filename);
	
	
	public Resource loadForro(String filename) throws MalformedURLException;
	
	public String copyForro(MultipartFile file1) throws IOException;
	
	public boolean deleteForro(String filename);

}
