package srv.api.com.user.service;

import srv.api.com.user.infrastructure.UserRepository;
import srv.api.com.user.model.KeyCloakID;
import srv.api.com.user.model.UserInfo;
import srv.api.com.user.model.UserInfoID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public UserInfo getByID(UserInfoID userInfoID) {
        UserInfo userInfo = userRepository.getByID(userInfoID).orElseThrow(() -> new NotFoundException("User not found."));

        return userInfo;
    }

    public UserInfo getByKeyCloakID(KeyCloakID keyCloakID) {
        UserInfo userInfo = userRepository.getByKeyCloakID(keyCloakID).orElseThrow(() -> new NotFoundException("User not found."));

        return userInfo;
    }

    public UserInfo create(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }
}
