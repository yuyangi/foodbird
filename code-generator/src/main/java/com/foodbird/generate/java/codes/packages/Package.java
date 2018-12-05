package com.foodbird.generate.java.codes.packages;

import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Package implements IPackage {

    private List<String> packages;

    private List<IClass> classes;

    public Package() {
        super();
    }

    public Package(String packages) {
        this();
        String[] packs = packages.split("\\.");
        this.packages = new ArrayList<>();
        this.packages.addAll(Arrays.asList(packs));
    }

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public String toString() {
        return String.join(".", packages);
    }

    public void setClasses(List<IClass> classes) {
        this.classes = classes;
    }

    @Override
    public List<IClass> getClasses() {
        return classes;
    }

    @Override
    public String toCode() {
        return "package " + toString();
    }
}
