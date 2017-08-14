package in.mitransoftwares.ecommerce.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mitransoftwares.ecommerce.entity.security.UserToken;
import in.mitransoftwares.ecommerce.repository.security.UserTokenRepository;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired UserTokenRepository userTokenRepository;

	@Override
	public UserToken userTokenByIpAddress(String userToken) {
		return null;
	}

	
	
	
	

}
