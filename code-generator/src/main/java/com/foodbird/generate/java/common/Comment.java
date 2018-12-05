package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.constants.Constants;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public class Comment implements ICoder, Constants {

    private String comments;

    private List<String> params;

    private String returns;

    private CommentType type;

    @Override
    public String toCode() {
        StringBuilder commentBuilder = new StringBuilder();
        if (type == CommentType.BLOCK) {
            commentBuilder.append("/*");
            commentBuilder.append(" *" + this.comments);
            if (params != null) {
                for (String param : params) {
                    commentBuilder.append(" * @param ").append(param);
                }
            }
            if (returns != null) {
                commentBuilder.append(" * @return ").append(returns);
            }
            commentBuilder.append(" */");
        } else if (type == CommentType.ROW) {
            commentBuilder.append("// ").append(this.comments);
        }
        return commentBuilder.toString();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }

    public enum CommentType {

        BLOCK,
        ROW

    }

}
