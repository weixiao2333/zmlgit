package zju.ccnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zju.ccnt.entity.Link;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link,Integer> {
    List<Link> findByFilename(String filename);

    void deleteByFilename(String filename);
}
