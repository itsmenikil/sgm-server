package in.mitransoftwares.ecommerce.service.usermodule;

import javax.transaction.Transactional;

import in.mitransoftwares.ecommerce.entity.usermodule.User;

@Transactional
public interface UserService {

	User userByEmailId(String emailId);
	User userByUserName(String userName);
	void createNewUser(User user);
	void deleteUser(Long userId);
	User userByUserId(Long userId);
	void updateUser(User user);
}
