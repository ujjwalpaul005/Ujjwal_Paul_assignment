package com.example.service;

import java.util.List;

import com.example.dto.EntryDataDTO;
import com.example.exception.EntryDataException;
import com.example.model.EntryData;

public interface DataService {

	public List<EntryDataDTO> getListbyCategory(String category) throws EntryDataException;
	
	public EntryData addEntry(EntryData entry) throws EntryDataException;
}
