package srv.api.com.general.infrastructure;

import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.user.model.KeyCloakID;
import srv.api.com.user.model.UserInfoID;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class GenericIdParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(SurveyID.class)) {
            return (ParamConverter<T>) new SurveyID.SurveyIdParamConverter();
        } else if (rawType.equals(KeyCloakID.class)) {
            return (ParamConverter<T>) new KeyCloakID.KeyCloakIdParamConverter();
        } else if (rawType.equals(UserInfoID.class)) {
            return (ParamConverter<T>) new UserInfoID.UserIdParamConverter();
        } else if (rawType.equals(QuestionID.class)) {
            return (ParamConverter<T>) new QuestionID.QuestionIdParamConverter();
        }
        return null;
    }
}
