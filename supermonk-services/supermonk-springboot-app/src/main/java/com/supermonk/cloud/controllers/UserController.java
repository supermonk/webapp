package com.supermonk.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.supermonk.cloud.DO.UserDO;
import com.supermonk.cloud.DO.UserResponse;
import com.supermonk.cloud.constants.ConstantsSwagger;
import com.supermonk.cloud.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "GET_USER", notes = "Given an id get details of user", response = UserDO.class)
	@ApiResponses(value = {
			@ApiResponse(code = ConstantsSwagger.SWAGGER_ACCEPTED, message = ConstantsSwagger.SWAGGER_ACCEPTED_TEXT, response = UserDO.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = HttpHeaders.CONTENT_TYPE, value = MediaType.APPLICATION_JSON_VALUE, required = true, paramType = ConstantsSwagger.SWAGGER_HEADER) })
	@GetMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody UserDO getUserInfo(@PathVariable("userId") String userId) {
		logger.info("Making call");
		return userService.getUserDO(userId);
	}

	@ApiOperation(value = "POST_USER", notes = "Given details of the user add to the database", response = UserDO.class)
	@ApiResponses(value = {
			@ApiResponse(code = ConstantsSwagger.SWAGGER_ACCEPTED, message = ConstantsSwagger.SWAGGER_ACCEPTED_TEXT, response = UserResponse.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = HttpHeaders.CONTENT_TYPE, value = MediaType.APPLICATION_JSON_VALUE, required = true, paramType = ConstantsSwagger.SWAGGER_HEADER) })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/user")
	public ResponseEntity<UserResponse> addUserInfo(UserDO user) {
		UserResponse response = new UserResponse();
		response.setUserId(userService.addUserDO(user));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}