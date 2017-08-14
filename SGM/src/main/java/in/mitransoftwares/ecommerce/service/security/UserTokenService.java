package in.mitransoftwares.ecommerce.service.security;

import javax.transaction.Transactional;

import in.mitransoftwares.ecommerce.entity.security.UserToken;

@Transactional
public interface UserTokenService {

	
	public UserToken userTokenByIpAddress(String userToken);
}
