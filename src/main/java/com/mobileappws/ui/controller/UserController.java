package com.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.mobileappws.ui.model.request.UserDetailsModelRequest;
import com.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("/user") // http://localhost:9080/user
//@Validated
public class UserController {
	
	
	Map<String,UserRest> users;     //Map for storing Data.

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", required = false, defaultValue = "Desc") String sort

	) {

		return "get user was called with page=" + page + "and limit=" + limit + "sort=" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		if(users.containsKey(userId))
		{
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },

			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }

	)
	public ResponseEntity<UserRest> createUser(
		@Valid	@RequestBody UserDetailsModelRequest detailsModelRequest) {

		UserRest returnValue = new UserRest();

		returnValue.setFirstName(detailsModelRequest.getFirstName());
		returnValue.setLastName(detailsModelRequest.getLastName());
		returnValue.setEmail(detailsModelRequest.getEmail());
		
		String userId=UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users==null) users=new HashMap();
		users.put(userId, returnValue);

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.CREATED);
	}

	@PutMapping
	public String updateUser() {
		return "Update User!";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User was called!";
	}

}
