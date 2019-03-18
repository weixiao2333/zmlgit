package zju.ccnt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zju.ccnt.entity.Node;
import zju.ccnt.repository.NodeRepository;
import zju.ccnt.service.NodeService;

import java.util.List;

@Service
public class NodeServiceImp implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Override
    @Transactional
    public void delete(String filename) {
        nodeRepository.deleteByFilename(filename);
    }

    @Override
    @Transactional
    public Node save(Node newNode) {
        return nodeRepository.save(newNode);
    }

    @Override
    public List<Node> findList(String filename) {
        return nodeRepository.findByFilename(filename);
    }
}
