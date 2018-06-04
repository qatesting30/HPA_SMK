package com.healthec.generic;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.Collections;
import java.util.List;

public class Priority implements IMethodInterceptor{


        public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

            Collections.sort(list, new MethodComparator());
            return list;
        }

    }







