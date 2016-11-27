package com.sub.common.gen.tools;

import com.sub.common.gen.constants.IConstants;
import com.sub.common.gen.model.ICoder;

/**
 * Created by yuyang on 2016/11/27.
 */
public class Line implements IConstants {

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
            this.line.append(line);
        }
        return this;
    }

    public Line append(ICoder coder) {
        if(coder != null){
            this.line.append(coder.toCode());
        }
        return this;
    }

    public Line wordSeparator() {
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

    public Line end() {
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
        this.leftBrace().swapLine().append(segment.toString()).swapLine().rightBrace();
        return this;
    }

    public Line bracket(Segment segment) {
        this.leftBracket().append(segment.toString()).rightBracket();
        return this;
    }

    public Line bracket(String segment) {
        this.leftBracket().append(segment.toString()).rightBracket();
        return this;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String toString() {
        return indent.toString() + line.append(LINE_SEPARATOR).toString();
    }

}
