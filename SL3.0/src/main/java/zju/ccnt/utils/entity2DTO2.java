package zju.ccnt.utils;

import org.springframework.beans.BeanUtils;
import zju.ccnt.entity.*;

import java.util.ArrayList;
import java.util.List;

public class entity2DTO2 {
    public static NodeAndLink entity2DTOconvert2(String name, List<Node> nodelist, List<Link> linklist){
        NodeAndLink nodeAndLink=new NodeAndLink();
        List<NodeDTO> nodeDTOList=new ArrayList<>();
        for(Node node:nodelist){
            NodeDTO nodeDTO=new NodeDTO();
            BeanUtils.copyProperties(node,nodeDTO);
            nodeDTO.setKey(node.getGraphKey());
//            nodeDTO.setLoc(null);
            nodeDTOList.add(nodeDTO);
        }
        List<LinkDTO> linkDTOList=new ArrayList<>();
        for(Link link:linklist){
            LinkDTO linkDTO=new LinkDTO();
            linkDTO.setFrom(link.getStartnode());
            linkDTO.setTo(link.getEndnode());
            linkDTO.setText(link.getText());
            //只要有from,to,没有setpoints也行
            linkDTOList.add(linkDTO);
        }
        nodeAndLink.setNodeDataArray(nodeDTOList);
        nodeAndLink.setLinkDataArray(linkDTOList);
        nodeAndLink.setFilename(name);
        return nodeAndLink;
    }

}
