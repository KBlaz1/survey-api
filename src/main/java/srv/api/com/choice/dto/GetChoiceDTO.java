package srv.api.com.choice.dto;

import srv.api.com.choice.domain.model.Choice;
import srv.api.com.choice.domain.model.ChoiceID;

/**
 * DTO class for handling the Choice class used in GET requests
 */
public class GetChoiceDTO {

    /**
     * Choice's ID
     */
    private ChoiceID choiceID;

    /**
     * Choice's label
     */
    private String label;

    /**
     * Choice's index
     */
    private Integer index;

    public ChoiceID getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(ChoiceID choiceID) {
        this.choiceID = choiceID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "GetChoiceDTO{" +
                "choiceID=" + choiceID +
                ", label='" + label + '\'' +
                ", index=" + index +
                '}';
    }

    /**
     * Maps the Choice to its dto
     *
     * @param choice The choice that's mapped
     * @return GetChoiceDTO
     */
    public static GetChoiceDTO createDTOFromChoice(Choice choice) {
        GetChoiceDTO dto = new GetChoiceDTO();

        dto.choiceID = choice.getChoiceID();
        dto.label = choice.getLabel().getText();
        dto.index = choice.getIndex().getNumber();

        return dto;
    }
}
