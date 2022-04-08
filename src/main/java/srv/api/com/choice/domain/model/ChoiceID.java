package srv.api.com.choice.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

/**
 * The model class for the Choice's UUID
 * Implements the IBaseAggregateRootID
 */
@Embeddable
public class ChoiceID implements IBaseAggregateRootID {

    /**
     * Choice's UUID
     */
    @NotNull
    @Column(name = "choice_id")
    private UUID uuid;

    public ChoiceID() {}

    private ChoiceID(UUID uuid) {
        this.uuid = uuid;
    }

    public static ChoiceID create(UUID uuid) {
        return new ChoiceID(uuid);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ChoiceID{" +
                "uuid=" + uuid +
                '}';
    }

    public static class ChoiceIdParamConverter implements ParamConverter<ChoiceID> {

        @Override
        public ChoiceID fromString(String uuid) {
            if (uuid == null) return null;
            return ChoiceID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(ChoiceID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
