package zju.ccnt.entity;

import java.util.List;

public class NodeAndLink {

    private List<NodeDTO> nodeDataArray;

    private List<LinkDTO> linkDataArray;

    private String filename;

    private String base64;

    public List<NodeDTO> getNodeDataArray() {
        return nodeDataArray;
    }

    public void setNodeDataArray(List<NodeDTO> nodeDataArray) {
        this.nodeDataArray = nodeDataArray;
    }

    public List<LinkDTO> getLinkDataArray() {
        return linkDataArray;
    }

    public void setLinkDataArray(List<LinkDTO> linkDataArray) {
        this.linkDataArray = linkDataArray;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
