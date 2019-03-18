package zju.ccnt.entity;

public class Graphlink {
    private Integer startnode;
    private Integer endnode;
    private String text;


    public Integer getStartnode() {
        return startnode;
    }

    public void setStartnode(Integer startnode) {
        this.startnode = startnode;
    }

    public Integer getEndnode() {
        return endnode;
    }

    public void setEndnode(Integer endnode) {
        this.endnode = endnode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        Graphlink other=(Graphlink) o;
        if(this.startnode.equals(other.startnode)&&this.endnode.equals(other.endnode)&&this.text.equals(other.text))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return text.hashCode()+startnode+endnode;
    }
}
