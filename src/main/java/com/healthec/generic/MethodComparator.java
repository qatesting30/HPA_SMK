package com.healthec.generic;

import org.testng.IMethodInstance;

import java.util.Comparator;


public class MethodComparator implements Comparator<IMethodInstance> {



    public int compare(IMethodInstance o1, IMethodInstance o2) {
        return o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
    }
}
