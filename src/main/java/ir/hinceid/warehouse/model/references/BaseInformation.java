package ir.hinceid.warehouse.model.references;

import ir.hinceid.warehouse.model.general.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "baseinformation")
public class BaseInformation extends BaseModel {

    public String label;

    public String icon;

    public String collapsedIcon;

    public String expandedIcon;

    public String hierarchy;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public BaseInformation parent;

}
