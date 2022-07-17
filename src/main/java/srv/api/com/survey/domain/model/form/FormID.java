package srv.api.com.survey.domain.model.form;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.IBaseAggregateRootID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.ws.rs.ext.ParamConverter;
import java.util.UUID;

/**
 * Model class of the Form UUID
 * Implements the IBaseAggregateRootID
 */
@Embeddable
public class FormID implements IBaseAggregateRootID {

    /**
     * Surveys UUID
     */
    @NotNull
    @Column(name = "form_id")
    private UUID uuid;

    public FormID() {}

    private FormID(UUID uuid) {
        this.uuid = uuid;
    }

    public static FormID create(UUID uuid) {
        return new FormID(uuid);
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
        return "FormID{" +
                "uuid=" + uuid +
                '}';
    }

    public static class FormIdParamConverter implements ParamConverter<FormID> {

        @Override
        public FormID fromString(String uuid) {
            if (uuid == null) return null;
            return FormID.create(UUID.fromString(uuid));
        }

        @Override
        public String toString(FormID value) {
            if (value == null) return null;
            if (value.getUUID() == null) return null;
            return value.getUUID().toString();
        }
    }
}
