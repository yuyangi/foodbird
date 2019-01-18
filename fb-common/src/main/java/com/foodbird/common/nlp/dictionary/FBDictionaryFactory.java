package com.foodbird.common.nlp.dictionary;

import com.foodbird.common.nlp.FBIDictionary;
import com.foodbird.common.nlp.parser.FBTokenizer;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/17
 */
public class FBDictionaryFactory {

    public static final String DEFAULT_DICTIONARY = "defaultDictionary";

    private static Map<String, FBIDictionary> dics = Maps.newHashMap();

    public static FBIDictionary load(String dicName) throws Exception {
        if (dics.containsKey(dicName)) {
            return dics.get(dicName);
        }
        FBIDictionary dic = new FBDictionary();
        dic.load(loadDic());
        dics.put(dicName, dic);
        return dic;
    }

    private static List<String> loadDic() throws Exception {
        URL resource = FBTokenizer.class.getClassLoader().getResource("dic/main2012.dic");
        if (resource == null) {
            return null;
        }
        File dicFile = new File(resource.getPath());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(dicFile));
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
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

}
