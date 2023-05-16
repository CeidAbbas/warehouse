package ir.hinceid.warehouse.repository.interfaces.general;

import ir.hinceid.warehouse.model.general.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFileStorageRepository extends JpaRepository<FileStorage, UUID> {

    @Query(" FROM FileStorage e WHERE e.related = :related AND e.scope = :scope")
    List<FileStorage> findByRelatedAndScope(UUID related, String scope);
}
