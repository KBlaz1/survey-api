package srv.api.com.user.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;
import javax.validation.constraints.Email;

@Entity
@NamedQueries({
       @NamedQuery(name = UserInfo.getByID, query = "SELECT u FROM UserInfo u where u.userInfoID.uuid = :user_uuid"),
       @NamedQuery(name = UserInfo.getByKeyCloakID, query = "SELECT u FROM UserInfo u where u.keyCloakID.uuid = :keyCloak_uuid")
})
public class UserInfo extends BaseEntity {

    public static final String PREFIX = "UserInfo";
    public static final String getByID = PREFIX + ".getByID";
    public static final String getByKeyCloakID = PREFIX + ".getByKeyCloakID";

    @Valid
    @Embedded
    @NotNull
    private UserInfoID userInfoID;

    private String name;

    private String lastName;

    @Email
    private String email;

    @Valid
    @Embedded
    @NotNull
    private KeyCloakID keyCloakID;

    public UserInfoID getUserID() {
        return userInfoID;
    }

    public void setUserID(UserInfoID userInfoID) {
        this.userInfoID = userInfoID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KeyCloakID getKeyCloakID() {
        return keyCloakID;
    }

    public void setKeyCloakID(KeyCloakID keyCloakID) {
        this.keyCloakID = keyCloakID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
