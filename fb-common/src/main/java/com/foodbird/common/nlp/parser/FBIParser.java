package com.foodbird.common.nlp.parser;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public interface FBIParser<S, T> {

    default T[] parse(S s) {
        Map<T[], Integer> evaluate = tokenizer().source(s).evaluate(parseRaw(s));
        Optional<Map.Entry<T[], Integer>> result = evaluate.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        return result.map(Map.Entry::getKey).orElse(null);
    }

    default T[][] parseRaw(S s) {
        return tokenizer().source(s).split();
    }

    FBITokenizer<S, T> tokenizer();

}
