package tr.edu.yildiz.ce.se.base.domain.common;

import java.io.Serializable;
import java.util.Objects;

public class TenantUser implements Serializable {
    private String tenantId;
    private String email;
    private String name;
    private String surname;
    private String middleName;
    private String title;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String formalName() {
        final var middleName = !Objects.isNull(this.middleName) && !this.middleName.isEmpty()
                ? this.middleName + " "
                : "";
        return name + " " + middleName + surname;
    }

}
