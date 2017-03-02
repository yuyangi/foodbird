package com.sub.gen.meta.packages;

import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/6.
 */
public class Package implements IPackage {

    private List<String> packages;

    private List<IClass> classes;

    public Package() {

    }

    public Package(String packages) {
        String[] packs = packages.split("\\.");
        this.packages = new ArrayList<String>();
        for (String pack : packs) {
            this.packages.add(pack);
        }
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
}
