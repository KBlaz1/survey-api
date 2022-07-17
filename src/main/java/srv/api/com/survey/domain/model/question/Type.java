package srv.api.com.survey.domain.model.question;

/**
 * Enum class which defines the question type
 * Lets the client know how to display the question
 */
public enum Type {
    RADIO_BUTTON,
    CHECK_BOX,
    TEXT_FIELD,
    TEXT_AREA,
    SELECT
}
