package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

@Embeddable
public class SurveyID implements IBaseAggregateRootID {

    @NotNull
    @Column(name = "survey_id")
    private UUID uuid;

    public SurveyID() {}

    private SurveyID(UUID uuid) {
        this.uuid = uuid;
    }

    public static SurveyID create(UUID uuid) {
        return new SurveyID(uuid);
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
        return "SurveyID{" +
                "uuid=" + uuid +
                '}';
    }

    public static class SurveyIdParamConverter implements ParamConverter<SurveyID> {

        @Override
        public SurveyID fromString(String uuid) {
            if (uuid == null) return null;
            return SurveyID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(SurveyID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
