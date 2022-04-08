package srv.api.com.general.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The BaseEntity class that acts as a Superclass for all the model classes
 * Implements the Serializable interface
 * Contains a no-arg constructor with an entityId as its sole variable
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long entityId;

    public BaseEntity() {
        super();
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
