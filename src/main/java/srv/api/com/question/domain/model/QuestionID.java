package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;
import srv.api.com.user.model.KeyCloakID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

@Embeddable
public class QuestionID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "question_id")
    private UUID uuid;

    public QuestionID() {}

    private QuestionID(UUID uuid) {
        this.uuid = uuid;
    }

    public static QuestionID create(UUID uuid) {
        return new QuestionID(uuid);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public static class QuestionIdParamConverter implements ParamConverter<QuestionID> {

        @Override
        public QuestionID fromString(String uuid) {
            if (uuid == null) return null;
            return QuestionID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(QuestionID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
