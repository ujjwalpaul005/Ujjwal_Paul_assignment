package com.example.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorTemplate {

	private LocalDateTime dateTime;
	private String message;
	private String description;
}

