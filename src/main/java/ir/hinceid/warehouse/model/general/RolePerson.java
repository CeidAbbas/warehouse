package ir.hinceid.warehouse.model.general;

import ir.hinceid.warehouse.model.references.BaseInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = RolePerson.tableName)
public class RolePerson extends BaseModel {
    public static final String tableName = "rolePerson";

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person person;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public BaseInformation role;
}
