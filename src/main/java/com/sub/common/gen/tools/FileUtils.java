package com.sub.common.gen.tools;

import java.io.*;

/**
 * Created by yy111026 on 2016/12/8.
 */
public class FileUtils {

    public void writeFile(String path, StringBuffer content) {
        try {
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String path, String content) {
        try {
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String path, byte[] content) {
        try {
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream in = new FileOutputStream(file);
            in.write(content, 0, content.length);
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createFolder(String path) {
        File myFolderPath = new File(path);
        try {
            if (!myFolderPath.exists()) {
                myFolderPath.mkdir();
            }
        }
        catch (Exception e) {
            System.out.println("新建目录操作出错");
            e.printStackTrace();
        }
    }

    public void createFile(String path) {
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
            System.out.println("新建文件操作出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        fileUtils.createFile("/Users/yy111026/Desktop/aaa.txt");
        System.out.println("File create success !");
    }

}
