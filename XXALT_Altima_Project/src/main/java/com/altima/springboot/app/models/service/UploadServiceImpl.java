package com.altima.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//ALTIMA
@Service
public class UploadServiceImpl implements IUploadService {
	private final static String folderPrendas = "uploads/prendas";
	
	private final static String folderTelas = "uploads/telas";
	@Override
	public Resource load(String filename) throws MalformedURLException {
		Path pathFoto = getPath(filename);
		Resource recurso = null;

		recurso = new UrlResource(pathFoto.toUri());
		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error: No se puede cargar la imagen " + pathFoto.toString());
		}

		return recurso;
	}
	

	@Override
	public String[] copy(MultipartFile file, MultipartFile file2) throws IOException {
		String[] img = new String[2];
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		String uniqueFilename2 = UUID.randomUUID().toString() + "_" + file2.getOriginalFilename();
		Path rootPath = getPath(uniqueFilename);
		Path rootPath2 = getPath(uniqueFilename2);

		Files.copy(file.getInputStream(), rootPath);
		Files.copy(file2.getInputStream(), rootPath2);

		img[0] = uniqueFilename;
		img[1] = uniqueFilename2;
		
		return img;
	}

	@Override
	public boolean delete(String filename) {
		Path rootPath = getPath(filename);
		File archivo = rootPath.toFile();

		if (archivo.exists() && archivo.canRead()) {
			if (archivo.delete()) {
			}
		}
		return true;
	}

	public Path getPath(String filename) {
		return Paths.get(folderPrendas).resolve(filename).toAbsolutePath();

	}
	
	public Path getPathTela(String filename) {
		return Paths.get(folderTelas).resolve(filename).toAbsolutePath();

	}
	
	@Override
	public Resource loadTela(String filename) throws MalformedURLException {
		Path pathFoto = getPathTela(filename);
		Resource recurso = null;

		recurso = new UrlResource(pathFoto.toUri());
		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error: No se puede cargar la imagen " + pathFoto.toString());
		}

		return recurso;
	}
	
	@Override
	public String copyTela(MultipartFile file) throws IOException {
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rootPath = getPathTela(uniqueFilename);
		Files.copy(file.getInputStream(), rootPath);
		return uniqueFilename;
	}
	
	@Override
	public boolean deleteTela(String filename) {
		Path rootPath = getPathTela(filename);
		File archivo = rootPath.toFile();

		if (archivo.exists() && archivo.canRead()) {
			if (archivo.delete()) {
			}
		}
		return true;
	}


	@Override
	public String copy2(MultipartFile file) throws IOException {
		String img;
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rootPath = getPath(uniqueFilename);

		Files.copy(file.getInputStream(), rootPath);

		img = uniqueFilename;
		
		return img;
	}
	

}
