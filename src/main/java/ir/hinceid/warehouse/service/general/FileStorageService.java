package ir.hinceid.warehouse.service.general;

import ir.hinceid.warehouse.model.general.FileStorage;
import ir.hinceid.warehouse.repository.interfaces.general.IFileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileStorageService {

    @Autowired
    private IFileStorageRepository iFileStorageRepository;

    public FileStorage saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileStorage fileStorage = new FileStorage(fileName,file.getBytes());
        return iFileStorageRepository.save(fileStorage);
    }

    public Optional<FileStorage> getFileStorage(String fileId) {
        return iFileStorageRepository.findById(UUID.fromString(fileId));
    }
}
