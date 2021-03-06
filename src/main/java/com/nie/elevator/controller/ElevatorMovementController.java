package com.nie.elevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nie.elevator.model.ElevatorMovement;
import com.nie.elevator.repository.ElevatorMovementRepository;


@RestController
@RequestMapping("/elevatormovements")
public class ElevatorMovementController extends AbstractRestHandler{
	
	@Autowired
	private ElevatorMovementRepository repository;
	

	/**
	 * List all elevator movements
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<ElevatorMovement> findElevatorMovements() {
		return repository.findAll();
	}
	
	/**
	 * List movements of a particular elevator.
	 * @param elevatorID
	 * @return
	 */
	@RequestMapping(value="/{elevatorID}", method = RequestMethod.GET)
	public List<ElevatorMovement> findElevatorMovementsOfElevator(@PathVariable String elevatorID) {
		return repository.findByElevatorIDOrderByTimeAsc(elevatorID);
	}

}
