package srv.api.com.user.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

public class UserInfoID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "user_id")
    private UUID uuid;

    private UserInfoID(UUID uuid) {
        this.uuid = uuid;
    }

    public static UserInfoID create(UUID uuid) {
        return new UserInfoID(uuid);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public static class UserIdParamConverter implements ParamConverter<UserInfoID> {

        @Override
        public UserInfoID fromString(String uuid) {
            if (uuid == null) return null;
            return UserInfoID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(UserInfoID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
