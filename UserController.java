package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.Dto.BookDto;
import library.Dto.UserDto;
import library.Service.UserService;
import library.entities.Book;
import library.entities.User;

@RestController
public class UserController {
	@Autowired
	private  UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
// add user
	 @PostMapping("/User")
	    public User  AddUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	    }
	 
// delete User
	 
	          @DeleteMapping(path = "/User/{userId}")
	       public User RemoveUser(@PathVariable("userId") Integer Id,
	    		   @RequestBody UserDto userDto) {
		  return userService.removeUser(Id, userDto);
	   }
	          
// update User	  
	          
	   @PutMapping(path = "/User/{userId}")
	   public User updateUser(
			   @PathVariable("userId") Integer Id,
			   @RequestBody UserDto userDto )
			    {
		 return   userService.updateUser(Id , userDto );
	   }
	   

	  
		   


}
