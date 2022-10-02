package ir.hinceid.warehouse.viewModel.reference;

import ir.hinceid.warehouse.viewModel.general.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseInformationViewModel extends BaseViewModel {

    public String label;
    public String icon;
    public String collapsedIcon;
    public String expandedIcon;
    public String hierarchy;
    public String parent;

}
