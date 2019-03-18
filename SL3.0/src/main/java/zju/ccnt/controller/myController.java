package zju.ccnt.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.entity.*;
import zju.ccnt.service.LinkService;
import zju.ccnt.service.NodeService;
import zju.ccnt.service.fileService;
import zju.ccnt.utils.Merge;

import java.io.File;
import java.util.List;

import static zju.ccnt.utils.entity2DTO.entity2DTOconvert;
import static zju.ccnt.utils.saveImage.saveImg;
import static zju.ccnt.utils.Merge.merge;

@Controller
public class myController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private fileService fileservice;

    @RequestMapping("/test")
    public String hello(){
        return "thumbNail";
    }

    @RequestMapping("/thumbNail")
    public String thumbNail(Model model){
        model.addAttribute("files",fileservice.findall());
        return "thumbNail";
    }

    @RequestMapping("/merge")
    public String Mmerge(Model model,String[] names){
        String filename1=names[0];
        String filename2=names[1];
        model.addAttribute("ele",
                JSONObject.toJSON(merge(nodeService.findList(filename1),
                        nodeService.findList(filename2),
                        linkService.findList(filename1),
                        linkService.findList(filename2),
                        "??")));
        return "merge";
    }

    @RequestMapping("/main")
    public String successor(@RequestParam(name="filename",required=false) String filename,
                            Model model){
        model.addAttribute("fn",filename);
        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    public void deleteFile(@RequestBody file entity){
        String name=entity.getName();
        nodeService.delete(name);
        linkService.delete(name);
        fileservice.delete(name);
        String path="/Users/weixiao2333/Desktop/pic/concept/"+name+".png";
        File picFile=new File(path);
        picFile.delete();
    }

    //我就想一家人健健康康的一起，其他什么都不要
    @ResponseBody
    @RequestMapping(value = "/loadFile",method = RequestMethod.POST)
    public NodeAndLink loadFile(@RequestBody file entity){
        String name=entity.getName();
        return entity2DTOconvert(name,nodeService.findList(name),linkService.findList(name));
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public NodeAndLink save(@RequestBody NodeAndLink entity) {
        nodeService.delete(entity.getFilename());
        List<NodeDTO> nodeDataArray=entity.getNodeDataArray();
        for(NodeDTO nodeDTO:nodeDataArray){
            Node node=new Node();
            BeanUtils.copyProperties(nodeDTO,node);
            node.setGraphKey(nodeDTO.getKey());
            node.setFilename(entity.getFilename());
            nodeService.save(node);
        }
        linkService.delete(entity.getFilename());
        List<LinkDTO> linkDataArray=entity.getLinkDataArray();
        for(LinkDTO linkDTO:linkDataArray){
            Link link=new Link();
            link.setText(linkDTO.getText());
            link.setStartnode(linkDTO.getFrom());
            link.setEndnode(linkDTO.getTo());
            List<Double> points=linkDTO.getPoints();
            String temp="";
            for(Double point:points){
                temp+=(point.toString()+",");
            }
            temp=temp.substring(0,temp.length()-1);
            link.setPoints(temp);
            link.setFilename(entity.getFilename());
            linkService.save(link);
        }
        saveImg(entity.getBase64(),entity.getFilename());
        return entity;
    }

    @ResponseBody
    @GetMapping("/loadName")
    public List<file> loadName(){
       return fileservice.findall();
    }

    @ResponseBody
    @PostMapping("/saveName")
    public void saveFile(@RequestBody file entity){
        fileservice.save(entity);
    }

//    @GetMapping("/listFile")
//    public
}
