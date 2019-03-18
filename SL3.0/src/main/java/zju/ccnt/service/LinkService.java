package zju.ccnt.service;

import zju.ccnt.entity.Link;

import java.util.List;

public interface LinkService {

    Link save(Link newLink);

    void delete(String filename);

    List<Link> findList(String filename);

}
