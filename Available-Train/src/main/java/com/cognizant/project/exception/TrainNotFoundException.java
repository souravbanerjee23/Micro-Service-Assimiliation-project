package com.cognizant.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrainNotFoundException extends Exception {

	public TrainNotFoundException(Long id) {
		// TODO Auto-generated constructor stub

		System.out.println("Train is not found");
	}

}
