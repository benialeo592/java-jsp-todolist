package com.leone.myphotos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leone.myphotos.model.Photo;

@Repository
public interface InterfacePhotoRepository extends CrudRepository<Photo, Integer>{

}
