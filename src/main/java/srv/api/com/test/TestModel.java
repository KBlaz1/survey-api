package srv.api.com.test;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TestModel extends BaseEntity {

    @NotNull
    private String testingString;

    public String getTestingString() {
        return testingString;
    }

    public void setTestingString(String testingString) {
        this.testingString = testingString;
    }
}
