package in.mitransoftwares.ecommerce.service.usermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mitransoftwares.ecommerce.entity.usermodule.User;
import in.mitransoftwares.ecommerce.repository.usermodule.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public User userByEmailId(String emailId) {
		return userRepository.findUserByEmail(emailId);
	}

	@Override
	public User userByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}

	@Override
	public void createNewUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.delete(userId);
		
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User userByUserId(Long userId) {
		return userRepository.findOne(userId);
	}
	
}
