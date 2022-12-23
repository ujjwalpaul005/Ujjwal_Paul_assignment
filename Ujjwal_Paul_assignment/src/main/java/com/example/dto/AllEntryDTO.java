package com.example.dto;

import java.io.Serializable;
import java.util.List;

import com.example.model.EntryData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllEntryDTO implements Serializable{

	private Integer count;
	
	private List<EntryData> entries;
}
