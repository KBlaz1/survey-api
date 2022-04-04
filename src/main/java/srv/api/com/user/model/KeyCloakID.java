package srv.api.com.user.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

public class KeyCloakID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "keycloak_id")
    private UUID uuid;

    private KeyCloakID(UUID uuid) {
        this.uuid = uuid;
    }

    public static KeyCloakID create(UUID uuid) {
        return new KeyCloakID(uuid);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public static class KeyCloakIdParamConverter implements ParamConverter<KeyCloakID> {

        @Override
        public KeyCloakID fromString(String uuid) {
            if (uuid == null) return null;
            return KeyCloakID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(KeyCloakID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
