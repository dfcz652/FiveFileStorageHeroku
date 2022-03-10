package five.systems.FileStorage.services;

import five.systems.FileStorage.entity.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadRepositoryImpl {

    @Autowired
    private final DownloadRepository downloadRepository;

    public DownloadRepositoryImpl(@Lazy DownloadRepository downloadRepository) {
        this.downloadRepository = downloadRepository;
    }

//    public List<Links> findAll(){
//        return downloadRepository.findAll();
//    }
}
