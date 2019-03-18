package zju.ccnt.service;

import zju.ccnt.entity.Node;

import java.util.List;

public interface NodeService {

    Node save(Node newNode);

    void delete(String filename);

    List<Node> findList(String filename);
}
