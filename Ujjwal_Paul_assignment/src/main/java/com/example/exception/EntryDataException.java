package com.example.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryDataException extends Exception {

	public EntryDataException(String str) {
		super(str);
	}
}
