package com.sub.common.gen.tools;

/**
 * Created by yuyang on 2016/11/27.
 */
public class Segment {

    private Line[] lines;

    private String indent;

    public Segment(Line... lines) {
       super();
       this.lines = lines;
    }

    public Segment(String indent, Line... lines) {
        super();
        this.indent = indent;
        this.lines = lines;
    }

    public String toString() {
        if(lines != null) {
            StringBuilder sb = new StringBuilder();
            for(Line line : lines) {
                line.setIndent(indent);
                sb.append(line.toString());
            }
            return sb.toString();
        }
        return null;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }
}
