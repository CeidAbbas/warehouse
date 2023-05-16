package ir.hinceid.warehouse.viewModel.warehouse;

import ir.hinceid.warehouse.viewModel.general.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForwardingViewModel extends BaseViewModel {

    private String id;
    private String transporterId;
    private String transporterFullName;
    private String packagesId;
    private String packagesBarcode;
    private String packagesColor;
    private String carrierId;
    private String carrierTitle;
    private String receiverId;
    private String receiverFullName;
    private String transportDate;
    private String receiveDate;
    private String receiveReport;
    private String description;
    private String carrierNumber;
}
