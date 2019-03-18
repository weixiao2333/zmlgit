package zju.ccnt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zju.ccnt.entity.file;
import zju.ccnt.repository.fileRepository;
import zju.ccnt.service.fileService;

import java.util.List;

@Service
public class fileServiceImp implements fileService {
    @Autowired
    private fileRepository filerepository;

    @Override
    @Transactional
    public file save(file entity) {
        return filerepository.save(entity);
    }

    @Override
    public List<file> findall() {
        return filerepository.findAll();
    }

    @Override
    @Transactional
    public void delete(String filename) {
        filerepository.deleteByName(filename);
    }
}
