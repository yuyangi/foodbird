package com.foodbird.common.nlp.parser;

import com.foodbird.common.nlp.FBIDescription;
import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.FBIWord;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.*;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.*;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/3
 */
public class FBTokenizer implements FBITokenizer<FBIDescription, FBIWord> {

    private FBIDescription source;

    private FBIWord next;

    private String remain;

    private List<String> sentences;

    private FBIDictionary dictionary;

    public FBTokenizer() {
        sentences = new ArrayList<>();
    }

    @Override
    public FBITokenizer<FBIDescription, FBIWord> source(FBIDescription s) {
        this.source = s;
        return this;
    }

    @Override
    public FBIDescription source() {
        return source;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public FBIWord next() {
        return null;
    }

    @Override
    public FBIWord prefer(FBIWord[] words) {
        return null;
    }

    @Override
    public Map<FBIWord[], Integer> evaluate(FBIWord[][] splits) {
        return null;
    }

    @Override
    public FBIWord[][] split() {
        List<FBIWord[]> possibleSplits = Lists.newArrayList();

        return possibleSplits.toArray(new FBIWord[0][]);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    public static void main(String[] args) {
//        String description = "从前有座山，山里有个庙,庙里有个和尚；和尚有个筐;筐里有个盆。";
//
//        StringTokenizer tokenizer = new StringTokenizer(description, "，。；,.; \t\n\r\f");
//        while (tokenizer.hasMoreTokens()) {
//            System.out.println(tokenizer.nextToken());
//        }

        List<String> dictionary = loadDic();
        String description = "模拟主存储器空间的分配和回收";

        List<List<String>> strings = splitsIterator2List(description, dictionary);
        for (List<String> row : strings) {
            System.out.println(Joiner.on(" ").join(row));
        }

    }

    private static List<List<String>> splitsIterator2List(String description, List<String> dictionary) {
        if ("".equals(description)) {
            return null;
        }
        List<List<String>> lists = Lists.newArrayList();
        if (dictionary.contains(description)) {
            lists.add(Lists.newArrayList(description));
        }
        char[] chars = description.toCharArray();
        String cs = "";
        Map<String, String> lefts = Maps.newHashMap();
        boolean findWord = false;
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char c = chars[i];
            cs += c;
            if (dictionary.contains(cs)) {
                findWord = true;
                String left = new String(Arrays.copyOfRange(chars, i + 1, charsLength));
                lefts.put(cs, left);
            }
        }
        if (!findWord) {
            return null;
        }

        for (Map.Entry<String, String> left : lefts.entrySet()) {
            List<List<String>> tempList = splitsIterator2List(left.getValue(), dictionary);
            if (tempList != null) {
                for (List<String> row : tempList) {
                    row.add(0, left.getKey());
                }
                lists.addAll(tempList);
            }
        }
        return lists;
    }

    private static List<String> loadDic() {
        URL resource = FBTokenizer.class.getClassLoader().getResource("dic/main2012.dic");
        File dicFile = new File(resource.getPath());

        try {
            BufferedReader br = new BufferedReader(new FileReader(dicFile));
            String line;
            List<String> dic = Lists.newArrayList();
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\t");
                if (split.length > 0) {
                    dic.add(split[0]);
                }
            }
            dic.add("和");
            dic.add("的");
            return dic;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
