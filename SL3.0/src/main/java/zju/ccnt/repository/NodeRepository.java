package zju.ccnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zju.ccnt.entity.Node;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node,Integer> {
    List<Node> findByFilename(String filename);

    void deleteByFilename(String filename);
}
