package zju.ccnt.utils;

import org.springframework.beans.BeanUtils;
import zju.ccnt.entity.*;

import java.util.ArrayList;
import java.util.List;

public class entity2DTO {
    public static NodeAndLink entity2DTOconvert(String name, List<Node> nodelist, List<Link> linklist){
        NodeAndLink nodeAndLink=new NodeAndLink();
        List<NodeDTO> nodeDTOList=new ArrayList<>();
        for(Node node:nodelist){
            NodeDTO nodeDTO=new NodeDTO();
            BeanUtils.copyProperties(node,nodeDTO);
            nodeDTO.setKey(node.getGraphKey());
            nodeDTOList.add(nodeDTO);
        }
        List<LinkDTO> linkDTOList=new ArrayList<>();
        for(Link link:linklist){
            LinkDTO linkDTO=new LinkDTO();
            linkDTO.setFrom(link.getStartnode());
            linkDTO.setTo(link.getEndnode());
            linkDTO.setText(link.getText());
            List<Double> points=new ArrayList<>();
            String[] pointsString=link.getPoints().split(",");
            for(String string:pointsString){
                points.add(Double.parseDouble(string));
            }
            linkDTO.setPoints(points);
            linkDTOList.add(linkDTO);
        }
        nodeAndLink.setNodeDataArray(nodeDTOList);
        nodeAndLink.setLinkDataArray(linkDTOList);
        nodeAndLink.setFilename(name);
        return nodeAndLink;
    }

}
