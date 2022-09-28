package ir.hinceid.warehouse.repository.body.reference;

import ir.hinceid.warehouse.model.references.BaseInformation;
import ir.hinceid.warehouse.repository.interfaces.reference.IBaseInformationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseInformationRepository implements IBaseInformationRepository {
    @Override
    public List<BaseInformation> getByHierarchy(String hierarchy) {
        String hql = " FROM ";
        return null;
    } //extends BaseRepository<BaseInformation, UUID> implements IBaseInformationRepository {

////    @Override
//    public List<BaseInformation> loadByWareType() {
////        HashMap<String, Object> param = new HashMap<String, Object>();
////        String hql = "FROM " + ir.hinceid.warehouse.model.references.BaseInformation.class + " e " +
////                "           ";
//        return super.findAll();
//    }
}
