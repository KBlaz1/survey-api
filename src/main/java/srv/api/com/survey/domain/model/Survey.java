package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.question.domain.model.Question;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Survey.getAll, query = "SELECT s FROM Survey s"),
        @NamedQuery(name = Survey.getByID, query = "SELECT s FROM Survey s where s.surveyID.uuid = :survey_info_id")
})
@NamedEntityGraph(name = "graph.survey.questions",
        attributeNodes = @NamedAttributeNode(value = "questions", subgraph = "questions"),
        subgraphs = @NamedSubgraph(name = "questions", attributeNodes = @NamedAttributeNode("answerOptions")  ))
public class Survey extends BaseEntity {

    private static final String PREFIX = "Survey";
    public static final String getAll = PREFIX + ".getAll";
    public static final String getByID = PREFIX + ".getByID";

    @Valid
    @Embedded
    @NotNull
    private SurveyID surveyID;

    @Valid
    @Embedded
    @NotNull
    private Title title;

    @Valid
    @Embedded
    private Description description;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Question> questions;

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyID=" + surveyID +
                ", title=" + title +
                ", description=" + description +
                ", questions=" + questions +
                '}';
    }
}
