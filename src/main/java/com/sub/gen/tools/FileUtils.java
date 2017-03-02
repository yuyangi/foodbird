package com.sub.gen.tools;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * @author yy111026 on 2016/12/8.
 */
public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class);

    public static void writeFile(String path, StringBuffer content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void writeFile(String path, String content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void writeFile(String path, byte[] content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream in = new FileOutputStream(file);
            in.write(content, 0, content.length);
            in.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void createFolder(String path) {
        File myFolderPath = new File(path);
        try {
            if (!myFolderPath.exists()) {
                myFolderPath.mkdir();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void createFile(String path) {
        File myFilePath = new File(path);
        try {
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(path);
            resultFile.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        FileUtils.createFile("/Users/yy111026/Desktop/aaa.txt");
        System.out.println("File create success !");
    }

}
