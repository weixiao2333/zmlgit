package zju.ccnt.service;

import zju.ccnt.entity.file;

import java.util.List;

public interface fileService {
    file save(file entity);

    List<file> findall();

    void delete(String filename);
}
