package srv.api.com.user.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import srv.api.com.question.domain.model.Question;
import srv.api.com.user.model.KeyCloakID;
import srv.api.com.user.model.UserInfo;
import srv.api.com.user.model.UserInfoID;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<Question> {

    public Optional<UserInfo> getByID(UserInfoID userInfoID) {
        return getEntityManager().createNamedQuery(UserInfo.getByID, UserInfo.class)
                .setParameter("user_uuid", userInfoID.getUUID())
                .getResultStream()
                .findFirst();
    }

    public Optional<UserInfo> getByKeyCloakID(KeyCloakID keyCloakID) {
        return getEntityManager().createNamedQuery(UserInfo.getByKeyCloakID, UserInfo.class)
                .setParameter("keyCloak_uuid", keyCloakID.getUUID())
                .getResultStream()
                .findFirst();
    }

    public UserInfo save(UserInfo userInfo) {
        if (userInfo.getEntityId() != null && userInfo.getUserID() != null) {
            return getEntityManager().merge(userInfo);
        } else {
            getEntityManager().persist(userInfo);
            return userInfo;
        }
    }
}
