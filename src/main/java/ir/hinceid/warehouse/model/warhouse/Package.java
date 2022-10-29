package ir.hinceid.warehouse.model.warhouse;

import ir.hinceid.warehouse.model.general.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = Package.tableName)
public class Package extends BaseModel {
    public static final String tableName = "package";

    private String barcode;
    private String color;
    private Boolean status;
}
