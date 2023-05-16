package ir.hinceid.warehouse.model.warhouse;

import ir.hinceid.warehouse.model.general.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = ForwardingPackage.TABLE_NAME)
public class ForwardingPackage extends BaseModel {
    public static final String TABLE_NAME = "forwarding_package";

    @ManyToOne
    @JoinColumn(name = "forwarding_id")
    private Forwarding forwarding;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package packages;
}
