package in.mitransoftwares.ecommerce.controller.usermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.mitransoftwares.ecommerce.entity.usermodule.User;
import in.mitransoftwares.ecommerce.service.usermodule.UserService;
import in.mitransoftwares.ecommerce.utility.DateFormatter;
import in.mitransoftwares.ecommerce.utility.DateHelper;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void saveUser(@RequestParam User user){
		userService.createNewUser(user);
	}
	
	@RequestMapping(value="/{id}")
	public User retriveUser(@PathVariable Long id){
		return userService.userByUserId(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public User dummyUser(){
		User user =new User();
		user.setFirstName("nikil");
		user.setLastName("kumar");
		user.setCreatedDate(DateHelper.getCurrentSystemDate(DateFormatter.ddMMyyHHmmss));
		return user;
	}
}
