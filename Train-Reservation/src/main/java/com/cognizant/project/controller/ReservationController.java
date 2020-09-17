package com.cognizant.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.project.feign.TrainFeignClient;
import com.cognizant.project.model.TrainDetails;
import com.cognizant.project.repository.ReservationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("user")
public class ReservationController {

	@Autowired
	private TrainFeignClient trainFeign;

	@Autowired
	private ReservationRepository reserveRepository;

	@GetMapping("/trains")
	public List<TrainDetails> getTrainDetails() {
		return trainFeign.getAllTrains();
	}

	@PostMapping("/reserve/{trainid}/{userid}")
	public void reserveTrain(@PathVariable("trainid") Long trainId, @PathVariable("userid") Long userId) {

		reserveRepository.reserveTickets(trainId, userId);

	}

	@GetMapping("/reserve/{userId}")
	public List<TrainDetails> viewReserveTrain(@PathVariable("userId") Long userid) throws JsonProcessingException {

		List<TrainDetails> trainItems = trainFeign.getAllTrains();
		List<TrainDetails> reserve = new ArrayList<TrainDetails>();

		for (TrainDetails t : trainItems) {
			if (reserveRepository.findById(userid).getTrainId() == t.getId()) {

				reserve.add(t);

			}

		}
		return reserve;

	}

	@DeleteMapping(path = "/cancel/{userId}")
	public String deleteById(@PathVariable Long userId) {
		reserveRepository.deleteById(userId);
		return "Details with id= " + userId + " deleted";
	}

}
