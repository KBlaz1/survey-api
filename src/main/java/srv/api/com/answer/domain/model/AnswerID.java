package srv.api.com.answer.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class AnswerID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "answer_id")
    private UUID uuid;

    public AnswerID() {}

    private AnswerID(UUID uuid) {
        this.uuid = uuid;
    }

    public static AnswerID create(UUID uuid) {
        return new AnswerID(uuid);
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
