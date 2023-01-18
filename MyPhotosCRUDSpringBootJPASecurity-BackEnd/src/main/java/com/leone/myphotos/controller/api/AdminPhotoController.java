package com.leone.myphotos.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.leone.myphotos.model.Photo;
import com.leone.myphotos.service.InterfacePhotoService;

import jakarta.validation.Valid;

@RestController
public class AdminPhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private InterfacePhotoService photoService;
	
	public AdminPhotoController() {

	}
	
	@RequestMapping("/admin/api/photos")
	public Iterable<Photo> getAll(){
		
		return photoService.getAll();
	}
	
	@RequestMapping("/admin/api/photos/{id}")
	public Photo getById(@PathVariable int id) {
		
		Optional<Photo> photo = photoService.getById(id);
		
		if (photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}else {
			return photo.get();
		}
	}
	
	@RequestMapping(value = "/admin/api/photos" , method = RequestMethod.POST)
	public Photo create(@Valid @RequestBody Photo photo) {
		
		return photoService.create(photo);
	}
	
	@RequestMapping(value = "/admin/api/photos/{id}" , method = RequestMethod.PUT)
	public Photo update(@Valid @PathVariable int id, @RequestBody Photo photo) {
		Optional<Photo> updatedPhoto = photoService.update(id, photo);
		
		if (updatedPhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		
		return updatedPhoto.get();
	
	}
	
	@RequestMapping(value ="/admin/api/photos/{id}" , method = RequestMethod.DELETE )
	public void delete(@PathVariable int id) {
		Boolean isDeleted = photoService.delete(id);
		if(!isDeleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
	}
	
	}
	
}
