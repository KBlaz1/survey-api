package srv.api.com.general.domain.model;

import java.io.Serializable;
import java.util.UUID;

public interface IBaseAggregateRootID extends Serializable {

    UUID getUUID();

    void setUUID(UUID uuid);
}
