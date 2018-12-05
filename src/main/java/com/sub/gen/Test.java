package com.sub.gen;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;

import java.io.File;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/11/1
 */
public class Test {

    private static final CachedCompiler JCC = CompilerUtils.DEBUGGING ?
            new CachedCompiler(new File("src/test/java"), new File("target/compiled")) :
            CompilerUtils.CACHED_COMPILER;

    public static void main(String[] args) throws ClassNotFoundException {
        // dynamically you can call
        String className = "mypackage.MyClass";
        String javaCode = "package mypackage;\n" +
                "public class MyClass implements Runnable {\n" +
                "    public void run() {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n";
        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
        Runnable runner = null;
        try {
            runner = (Runnable) aClass.newInstance();
            runner.run();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
