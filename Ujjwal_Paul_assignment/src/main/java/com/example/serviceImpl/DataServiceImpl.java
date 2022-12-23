package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.AllEntryDTO;
import com.example.dto.EntryDataDTO;
import com.example.exception.EntryDataException;
import com.example.model.EntryData;
import com.example.repository.EntryRepo;
import com.example.service.DataService;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private EntryRepo eRepo;

	@Override
	public List<EntryDataDTO> getListbyCategory(String category) throws EntryDataException {
		
		String uri = "https://api.publicapis.org/entries";
		
		RestTemplate restTemp = new RestTemplate();
		
		AllEntryDTO allEntry = restTemp.getForObject(uri, AllEntryDTO.class);
		
		List<EntryDataDTO> myList = new ArrayList<>();
		
		for(EntryData e : allEntry.getEntries()) {
			if(e.getCategory().equals(category)) {
				myList.add(new EntryDataDTO(e.getAPI(), e.getDescription()));
			}
		}
		
		if(myList.size() == 0) {
			throw new EntryDataException("No entry found with category " + category);
		}
		
		
		
		// TODO Auto-generated method stub
		return myList;
	}

	@Override
	public EntryData addEntry(EntryData entry) throws EntryDataException {
		// TODO Auto-generated method stub
		return null;
	}

}
