package ir.hinceid.warehouse.model.warhouse;

import ir.hinceid.warehouse.model.general.BaseModel;
import ir.hinceid.warehouse.model.general.Person;
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
@Table(name = Forwarding.tableName)
public class Forwarding extends BaseModel {
    public static final String tableName = "forwarding";

    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Person transporter;

    @ManyToOne
    @JoinColumn(name = "packages_id")
    private Package packages;

    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private BaseInformation carrier;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Person receiver;

    private String transportDate;

    private String receiveDate;

    private String receiveReport;

    private String description;

    private String carrierNumber;
}
