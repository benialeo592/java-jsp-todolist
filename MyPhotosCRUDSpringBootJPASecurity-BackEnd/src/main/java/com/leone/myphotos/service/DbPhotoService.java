package com.leone.myphotos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leone.myphotos.model.Photo;
import com.leone.myphotos.repository.InterfacePhotoRepository;

@Service("mainPhotoService")
public class DbPhotoService  implements InterfacePhotoService{
	
	@Autowired
	private InterfacePhotoRepository photoRepository;
	
	@Override
	public Iterable<Photo> getAll(){
		
		return photoRepository.findAll();
	}
	
	@Override
	public Optional<Photo> getById(int id) {
		
			return photoRepository.findById(id);
	}
	
	@Override
	public Photo create(Photo photo) {
		
		return photoRepository.save(photo);
	}
	
	@Override
	public Optional<Photo > update(int id, Photo photo) {
		
		Optional<Photo> foundedPhoto = photoRepository.findById(id);
		if(foundedPhoto.isEmpty()) {
			return Optional.empty();
		}else {
			foundedPhoto.get().setUrl(photo.getUrl());
			photoRepository.save(foundedPhoto.get());
			return foundedPhoto;	
		}
	}
	
	@Override
	public boolean delete(int id) {

		Optional<Photo> foundedPhoto = photoRepository.findById(id);
		if(foundedPhoto.isEmpty()) {
			return false;
		}else {
			photoRepository.delete(foundedPhoto.get());
			return true;
			}
		}


	
}
