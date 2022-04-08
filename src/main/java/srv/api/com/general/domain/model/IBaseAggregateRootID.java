package srv.api.com.general.domain.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * The interface for all model IDs
 * Extends from the Serializable interface
 */
public interface IBaseAggregateRootID extends Serializable {

    UUID getUUID();

    void setUUID(UUID uuid);
}
