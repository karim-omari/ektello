package com.ektello.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ektello.demo.dtos.UserDTO;
import com.ektello.demo.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userServie;

	
	@RequestMapping(method=RequestMethod.GET,produces = "application/json",value="/all")
    public  @ResponseBody List<UserDTO> getAllUsers() {
        return userServie.getAllUsers().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
	
	
	@RequestMapping(method=RequestMethod.POST,value="/add",consumes="application/json")
    public  void addUser(@RequestBody UserDTO dto) {
        userServie.addUser(dto);
    }
	
}
