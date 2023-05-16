package ir.hinceid.warehouse.model.general;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = FileStorage.tableName)
public class FileStorage extends BaseModel {

    public static final String tableName = "FileStorage";

    @Column(name = "file_name")
    private String fileName;

    @Lob
    private byte[] file;

    @Column(name = "scope")
    private String scope;

    @Column(name = "related_id", length = 16)
    private UUID related;

    public FileStorage(String fileName, byte[] bytes) {
        this.fileName = fileName;
        this.file = bytes;
    }
    public FileStorage(String fileName, byte[] bytes, UUID related, String scope) {
        this.fileName = fileName;
        this.file = bytes;
        this.related = related;
        this.scope = scope;
    }

    public FileStorage() {

    }
}
