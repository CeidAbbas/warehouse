package ir.hinceid.warehouse.model.warhouse;

import ir.hinceid.warehouse.model.general.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = Forwarding.tableName)
public class Forwarding extends BaseModel {
    public static final String tableName = "forwarding";
}
