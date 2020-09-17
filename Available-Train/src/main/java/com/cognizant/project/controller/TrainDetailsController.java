package com.cognizant.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.project.exception.TrainNotFoundException;
import com.cognizant.project.model.TrainDetails;
import com.cognizant.project.repository.TrainRepository;

@RestController
@RequestMapping("trains")
public class TrainDetailsController {

	@Autowired
	private TrainRepository trainRepository;

	@GetMapping()
	public List<TrainDetails> getAllTrains() {
		return trainRepository.findAll();
	}

	@GetMapping("/{id}")
	public TrainDetails findByTrainId(@PathVariable Long id) throws TrainNotFoundException {
		TrainDetails train = trainRepository.findById(id);
		if (train == null) {
			throw new TrainNotFoundException(id);
		}
		return train;

	}

	@PostMapping("/add")
	public TrainDetails createTrain(@RequestBody TrainDetails train) {

		return trainRepository.save(train);
	}

	@PutMapping("/{id}")
	public TrainDetails updateTrainModel(@RequestBody TrainDetails newTrain, @PathVariable Long id)
			throws TrainNotFoundException {
		TrainDetails trainData = trainRepository.findById(id);
		if (trainData != null) {
			TrainDetails train = new TrainDetails();
			train.setID(newTrain.getID());
			train.setEndingStation(newTrain.getEndingStation());
			train.setName(newTrain.getName());
			train.setStartingStation(newTrain.getStartingStation());
			return trainRepository.save(train);
		} else {
			throw new TrainNotFoundException(id);
		}
	}

	@DeleteMapping(path = "/{id}")
	public String deleteTrain(@PathVariable Long id) {
		trainRepository.deleteById(id);
		return "Train details with id= " + id + " deleted";
	}

}
