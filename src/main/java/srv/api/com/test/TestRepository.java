package srv.api.com.test;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestRepository implements PanacheRepository<TestModel> {

    public TestModel save(TestModel testModel) {
        if (testModel.getEntityId() != null) {
            return getEntityManager().merge(testModel);
        } else {
            getEntityManager().persist(testModel);
            return testModel;
        }
    }
}
