package com.aysun.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.query.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
	@Query("SELECT l FROM Language l")
	List<Language> findAllLanguages();
	
	@Query("SELECT l.language FROM Language l")
	List<Language> findAllLanguagesNames();

}