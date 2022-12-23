package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EntryDataDTO;
import com.example.exception.EntryDataException;
import com.example.model.EntryData;
import com.example.service.DataService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EntryController {
	
	@Autowired
	private DataService dService;

	@GetMapping("/{category}")
	public ResponseEntity<List<EntryDataDTO>> getListbyCategoryHandler(@PathVariable String category) throws EntryDataException{
		List<EntryDataDTO> allList = dService.getListbyCategory(category);
		
		return new ResponseEntity<List<EntryDataDTO>>(allList, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<EntryData> addEntryHandler(@RequestBody EntryData entry) throws EntryDataException{
		EntryData newEntry = dService.addEntry(entry);
		
		return new ResponseEntity<EntryData>(newEntry, HttpStatus.CREATED);
	}
}
