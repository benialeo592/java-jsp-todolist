package com.leone.myphotos.service;

import java.util.Optional;

import com.leone.myphotos.model.Photo;

public interface InterfacePhotoService {

	public Iterable<Photo> getAll();
	
	public Optional<Photo> getById(int id);
	
	public Photo create(Photo photo);
	
	public Optional<Photo > update(int id, Photo photo);
	
	public boolean delete(int id);

}
