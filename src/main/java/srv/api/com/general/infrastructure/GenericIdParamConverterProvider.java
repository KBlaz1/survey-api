package srv.api.com.general.infrastructure;

import srv.api.com.choice.domain.model.Choice;
import srv.api.com.choice.domain.model.ChoiceID;
import srv.api.com.form.domain.model.FormID;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.survey.domain.model.SurveyID;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Registry for all REST parameter converters
 */
@Provider
public class GenericIdParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(SurveyID.class)) {
            return (ParamConverter<T>) new SurveyID.SurveyIdParamConverter();
        } else if (rawType.equals(QuestionID.class)) {
            return (ParamConverter<T>) new QuestionID.QuestionIdParamConverter();
        } else if (rawType.equals(FormID.class)) {
            return (ParamConverter<T>) new FormID.FormIdParamConverter();
        } else if (rawType.equals(Choice.class)) {
            return ((ParamConverter<T>) new ChoiceID.ChoiceIdParamConverter());
        }
        return null;
    }
}
