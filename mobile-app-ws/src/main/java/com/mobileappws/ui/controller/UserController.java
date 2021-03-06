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

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", required = false, defaultValue = "Desc") String sort

	) {

		return "get user was called with page=" + page + "and limit=" + limit + "sort=" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		UserRest returnValue = new UserRest();

		returnValue.setEmail("akash@333.com");
		returnValue.setFirstName("Akash");
		returnValue.setLastName("Dubey");
		returnValue.setUserId(userId);

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },

			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }

	)
	public ResponseEntity<UserDetailsModelRequest> createUser(
		@Valid	@RequestBody UserDetailsModelRequest detailsModelRequest) {

		UserRest userRest = new UserRest();

		userRest.setFirstName(detailsModelRequest.getFirstName());
		userRest.setLastName(detailsModelRequest.getLastName());
		userRest.setEmail(detailsModelRequest.getEmail());

		return new ResponseEntity<UserDetailsModelRequest>(detailsModelRequest, HttpStatus.CREATED);
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
