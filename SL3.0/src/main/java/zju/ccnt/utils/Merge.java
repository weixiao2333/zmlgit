package zju.ccnt.utils;

import org.springframework.beans.BeanUtils;
import zju.ccnt.entity.Graphlink;
import zju.ccnt.entity.Link;
import zju.ccnt.entity.Node;
import zju.ccnt.entity.NodeAndLink;

import java.util.*;

import static zju.ccnt.utils.entity2DTO.entity2DTOconvert;
import static zju.ccnt.utils.entity2DTO2.entity2DTOconvert2;

public class Merge {
    public static NodeAndLink merge(List<Node> nodelist1,List<Node> nodelist2,
                             List<Link> linklist1,List<Link> linklist2,
                             String newFilename){
        List<Node> newNodeList=new ArrayList<>();
        List<Link> newLinkList=new ArrayList<>();

        Map<Integer,Integer> graphkey1=new HashMap<Integer,Integer>();
        Map<Integer,Integer> graphkey2=new HashMap<Integer,Integer>();

        Integer len_node=new Integer(1);

        //entity,ability,attribute三个set
        Set<String> entity=new HashSet<String>();
        Set<String> ability=new HashSet<String>();
        Set<String> attribute=new HashSet<String>();

        Map<String,Integer> entityM=new HashMap<>();
        Map<String,Integer> abilityM=new HashMap<>();
        Map<String,Integer> attributeM=new HashMap<>();

        Set<Graphlink> linkSet=new HashSet<>();

        for(Node node:nodelist1){
            graphkey1.put(node.getGraphKey(),-len_node);
            //先生成，修改后用户点击保存
            node.setId(null);
            node.setGraphKey(-len_node);
            len_node++;
            newNodeList.add(node);
            if(node.getCategory().equals("entity")){
                entity.add(node.getText());
                entityM.put(node.getText(),node.getGraphKey());
            }
            else if(node.getCategory().equals("ability")){
                ability.add(node.getText());
                abilityM.put(node.getText(),node.getGraphKey());
            }
            else{
                attribute.add(node.getText());
                attributeM.put(node.getText(),node.getGraphKey());
            }
        }
        for(Node node:nodelist2){
            if(node.getCategory().equals("entity")){
                if(entity.contains(node.getText())){
                    graphkey2.put(node.getGraphKey(),entityM.get(node.getText()));
                }
                else{
                    node.setId(null);
                    graphkey2.put(node.getGraphKey(),-len_node);
                    node.setGraphKey(-len_node);
                    len_node++;
                    newNodeList.add(node);
                }
            }
            else if(node.getCategory().equals("ability")){
                if(ability.contains(node.getText())){
                    graphkey2.put(node.getGraphKey(),abilityM.get(node.getText()));
                }
                else{
                    node.setId(null);
                    graphkey2.put(node.getGraphKey(),-len_node);
                    node.setGraphKey(-len_node);
                    len_node++;
                    newNodeList.add(node);
                }
            }
            else{
                if(attribute.contains(node.getText())){
                    graphkey2.put(node.getGraphKey(),attributeM.get(node.getText()));
                }
                else{
                    node.setId(null);
                    graphkey2.put(node.getGraphKey(),-len_node);
                    node.setGraphKey(-len_node);
                    len_node++;
                    newNodeList.add(node);
                }
            }
        }

        for(Link link:linklist1){
            Graphlink graphlink=new Graphlink();
            link.setStartnode(graphkey1.get(link.getStartnode()));
            link.setEndnode(graphkey1.get(link.getEndnode()));
            graphlink.setStartnode(link.getStartnode());
            graphlink.setEndnode(link.getEndnode());
            graphlink.setText(link.getText());
            linkSet.add(graphlink);
            newLinkList.add(link);
        }
        for(Link link:linklist2){
            Graphlink graphlink=new Graphlink();
            link.setStartnode(graphkey2.get(link.getStartnode()));
            link.setEndnode(graphkey2.get(link.getEndnode()));
            graphlink.setStartnode(link.getStartnode());
            graphlink.setEndnode(link.getEndnode());
            graphlink.setText(link.getText());
            if(!linkSet.contains(graphlink))
                newLinkList.add(link);
        }
        return entity2DTOconvert2(newFilename,newNodeList,newLinkList);
        //修改文件名filename
    }
}
