package com.futuristlabs.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.futuristlabs.task.input.InputObject;
import com.futuristlabs.task.services.GameOfLifeService;

@RestController
public class GameOfLifeController {
	
	@Autowired
	private GameOfLifeService appService;
	
	@RequestMapping(method=RequestMethod.POST, value="/gameOfLife")
	public int[][] gameOfLife(@RequestBody InputObject input) {
		return appService.getLife(input.getArr(), input.getGenerations());
	}

}
