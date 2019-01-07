package com.foodbird.generate.java.common;

import com.foodbird.generate.java.ICoder;
import com.foodbird.generate.java.codes.Indented;
import com.foodbird.generate.java.codes.metas.Brackets;
import org.apache.commons.lang.ArrayUtils;

import java.util.List;
import java.util.StringJoiner;

import static com.foodbird.generate.java.codes.metas.Brackets.PARENTHESIS;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/30
 */
public class Body extends IndentSection {

    private Brackets[] brackets = Brackets.BRACKETS;

    public Body() {
        super(LINE_SEPARATOR);
        this.setPassed(false);
    }

    public Body(String delimiter, Brackets[] brackets) {
        super(delimiter);
        this.brackets = brackets;
        this.setPassed(false);
    }

    public Body(List<Sentence> sentences) {
        super(LINE_SEPARATOR);
        sentences.forEach(this::add);
        this.setPassed(false);
    }

    public void add(ICoder codes) {
        if (codes instanceof Body)
        getCodes().add(codes);
    }

    @Override
    public String toCode() {
        StringJoiner joiner = new StringJoiner(getDelimiter(),
                fix(brackets[0]),
                fix(brackets[1]));
        for (ICoder c : getCodes()) {
            if ((c instanceof Indented)) {
                String indent = Indent.instance.toCode();
                if (!((Indented) c).isPassed() && getIndent() != null) {
                    indent = indent + getIndent();
                }
                ((Indented) c).setIndent(indent);
            }
            joiner.add(c.toCode());
        }
        return joiner.toString();
    }

    private String fix(Brackets brackets) {
        if (brackets == Brackets.LEFT_BRACKET) {
            return brackets.toCode() + LINE_SEPARATOR;
        } else if (brackets == Brackets.RIGHT_BRACKET) {
            return LINE_SEPARATOR + (getIndent() != null ? getIndent() : "") + brackets.toCode();
        }
        return brackets.toCode();

    }

    public Body comments(String comments) {
        this.comments = comments;
        return this;
    }

    public static Body classBody(ICoder... coders) {
        Body body = create(Brackets.BRACKETS, WORD_SEPARATOR, coders);
        return body;
    }

    public static Body methodBody(ICoder... coders) {
        Body body = create(Brackets.BRACKETS, LINE_SEPARATOR, coders);
        return body;
    }

    public static Body classBody(Section... coders) {
        Body body = create(Brackets.BRACKETS, LINE_SEPARATOR + LINE_SEPARATOR, coders);
        return body;
    }

    public static Body paramBody(Section... coders) {
        return Body.create(PARENTHESIS, coders);
    }

    public static Body create(Brackets[] brackets, ICoder... coders) {
        return create(brackets, WORD_SEPARATOR, coders);
    }

    public static Body create(Brackets[] brackets, String delimiter, ICoder... coders) {
        Body b = new Body(delimiter, brackets);
        if (ArrayUtils.isEmpty(coders)) {
            return b;
        }
        for (ICoder coder : coders) {
            if (coder != null) {
                b.getCodes().add(coder);
            }
        }
        return b;
    }

}
