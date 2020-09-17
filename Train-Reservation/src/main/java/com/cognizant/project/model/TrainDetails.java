package com.cognizant.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDetails {
	private Long Id;
	private String name;
	private String startingStation;
	private String endingStation;

}
