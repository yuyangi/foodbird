package com.sub.common.gen.tools;

import com.sub.common.gen.constants.Constants;
import com.sub.common.gen.ICoder;

/**
 * Created by yuyang on 2016/11/27.
 */
public class Line implements Constants {

    private StringBuilder line = new StringBuilder();

    private String indent = "";

    public Line(String indent) {
        super();
        this.indent = indent;
    }

    public Line() {

    }

    public Line append(String line) {
        if(line != null){
            if(!line.isEmpty()) {
                this.line.append(WORD_SEPARATOR);
            }
            this.line.append(line);
        }
        return this;
    }

    public Line append(Object line) {
        if(line != null){
            this.append(line.toString());
        }
        return this;
    }

    public Line append(ICoder coder) {
        if(coder != null){
            this.line.append(coder.toCode());
        }
        return this;
    }

    public Line separator() {
        line.append(WORD_SEPARATOR);
        return this;
    }

    public Line leftBrace() {
        line.append(LEFT_BRACE);
        return this;
    }

    public Line rightBrace() {
        line.append(RIGHT_BRACE);
        return this;
    }

    public Line leftMidBracket() {
        line.append(LEFT_MID_BRACKET);
        return this;
    }

    public Line rightMidBracket() {
        line.append(RIGHT_MID_BRACKET);
        return this;
    }

    public Line leftBracket() {
        line.append(LEFT_BRACKET);
        return this;
    }

    public Line rightBracket() {
        line.append(RIGHT_BRACKET);
        return this;
    }

    public Line _return() {
        line.append(RETURN);
        return this;
    }

    public Line stateEnd() {
        line.append(SENTENCE_END);
        return this;
    }

    public Line swapLine() {
        line.append(LINE_SEPARATOR);
        return this;
    }

    public Line brace(Segment segment) {
        this.leftBrace().swapLine().append(segment.toString()).swapLine().rightBrace();
        return this;
    }

    public Line brace(String segment) {
        this.leftBrace().swapLine().append(segment).swapLine().rightBrace();
        return this;
    }

    public Line bracket(Segment segment) {
        this.leftBracket().append(segment.toString()).rightBracket();
        return this;
    }

    public Line bracket(String segment) {
        this.leftBracket().append(segment).rightBracket();
        return this;
    }

    public Line _this() {
        line.append("this");
        return this;
    }

    public Line dot() {
        line.append(DOT);
        return this;
    }

    public Line assign() {
        line.append(WORD_SEPARATOR).append("=").append(WORD_SEPARATOR);
        return this;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String toString() {
        return (indent !=null ? indent.toString() : "") + line.append(LINE_SEPARATOR).toString();
    }

}
