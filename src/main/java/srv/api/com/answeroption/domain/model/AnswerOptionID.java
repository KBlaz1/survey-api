package srv.api.com.answeroption.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class AnswerOptionID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "answeroption_id")
    private UUID uuid;

    public AnswerOptionID() {}

    private AnswerOptionID(UUID uuid) {
        this.uuid = uuid;
    }

    public static AnswerOptionID create(UUID uuid) {
        return new AnswerOptionID(uuid);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
