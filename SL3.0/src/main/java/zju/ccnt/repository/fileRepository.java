package zju.ccnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zju.ccnt.entity.file;

public interface fileRepository extends JpaRepository<file,Integer> {
    void deleteByName(String filename);
}
