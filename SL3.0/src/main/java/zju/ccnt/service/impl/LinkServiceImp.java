package zju.ccnt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zju.ccnt.entity.Link;
import zju.ccnt.repository.LinkRepository;
import zju.ccnt.service.LinkService;

import java.util.List;

@Service
public class LinkServiceImp implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    @Transactional
    public void delete(String filename) {
        linkRepository.deleteByFilename(filename);
    }

    @Override
    @Transactional
    public Link save(Link newLink) {
        return linkRepository.save(newLink);
    }

    @Override
    public List<Link> findList(String filename) {
        return linkRepository.findByFilename(filename);
    }
}
