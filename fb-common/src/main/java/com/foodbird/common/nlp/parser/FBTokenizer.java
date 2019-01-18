package com.foodbird.common.nlp.parser;

import com.foodbird.common.nlp.FBIDescription;
import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.FBIWord;
import com.foodbird.common.nlp.dictionary.FBDictionaryFactory;
import com.foodbird.common.nlp.dictionary.FBWord;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/3
 */
public class FBTokenizer implements FBITokenizer<FBIDescription, FBIWord> {

    public static final Logger LOGGER = LoggerFactory.getLogger(FBTokenizer.class);

    private FBIDescription source;

    private FBIWord next;

    private String remain;

    private FBIDictionary dictionary;

    private boolean complete;

    public FBTokenizer() {
        try {
            dictionary = FBDictionaryFactory.load(FBDictionaryFactory.DEFAULT_DICTIONARY);
        } catch (Exception e) {
            LOGGER.error("Load dictionary failed!", e);
        }
    }

    @Override
    public FBITokenizer<FBIDescription, FBIWord> source(FBIDescription s) {
        this.source = s;
        return this;
    }

    //@Override
    public FBIDescription source() {
        return source;
    }

    @Override
    public Map<FBIWord[], Integer> evaluate(FBIWord[][] splits) {
        return null;
    }

    @Override
    public FBIWord[][] split() {
        List<List<String>> possibleSplitStrings = splitsIterator2List(source.description());
        if (possibleSplitStrings == null) {
            complete = false;
            return null;
        }
        FBIWord[][] possibleSplits = new FBIWord[possibleSplitStrings.size()][];
        for (int i = 0; i < possibleSplitStrings.size(); i++) {
            FBIWord[] words = possibleSplitStrings.get(i).stream().map(FBWord::new).toArray(FBIWord[]::new);
            possibleSplits[i] = words;
        }
        complete = true;
        return possibleSplits;
    }

    @Override
    public boolean isCompleted() {
        return complete;
    }

    public static void main(String[] args) throws Exception {
//        String description = "从前有座山，山里有个庙,庙里有个和尚；和尚有个筐;筐里有个盆。";
//
//        StringTokenizer tokenizer = new StringTokenizer(description, "，。；,.; \t\n\r\f");
//        while (tokenizer.hasMoreTokens()) {
//            System.out.println(tokenizer.nextToken());
//        }
        FBTokenizer tokenizer = new FBTokenizer();
        String description = "模拟主存储器空间的分配和回收";

        List<List<String>> strings = tokenizer.splitsIterator2List(description);
        for (List<String> row : strings) {
            System.out.println(Joiner.on(" ").join(row));
        }
    }

    public List<List<String>> splitsIterator2List(String description) {
        if ("".equals(description)) {
            return null;
        }
        List<List<String>> lists = Lists.newArrayList();
        if (dictionary.isWord(description)) {
            lists.add(Lists.newArrayList(description));
        }
        char[] chars = description.toCharArray();
        String cs = "";
        Map<String, String> lefts = Maps.newHashMap();
        boolean findWord = false;
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char c = chars[i];
            cs += c;
            if (dictionary.isWord(cs)) {
                findWord = true;
                String left = new String(Arrays.copyOfRange(chars, i + 1, charsLength));
                lefts.put(cs, left);
            }
        }
        if (!findWord) {
            return null;
        }

        for (Map.Entry<String, String> left : lefts.entrySet()) {
            List<List<String>> tempList = splitsIterator2List(left.getValue());
            if (tempList != null) {
                for (List<String> row : tempList) {
                    row.add(0, left.getKey());
                }
                lists.addAll(tempList);
            }
        }
        return lists;
    }

}
