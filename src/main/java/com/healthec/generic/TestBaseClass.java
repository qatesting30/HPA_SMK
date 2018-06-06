package com.healthec.generic;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestBaseClass  implements IAnnotationTransformer{
	
	public static ExcelData testCaseSheet =null;
	public static ExcelData testdataSheet =null;
    public static String className=null;
	public static String testClassName=null;
    public static String  testMethodName = null;
    public static String methodName = null;

	public static void testcaseInit(){

        testCaseSheet = new ExcelData("TestCases.xlsx");
		
}
    public static void testDataInit() {

        testdataSheet = new ExcelData("testData.xlsx");
}

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        testcaseInit();
        testDataInit();
        className = testMethod.getDeclaringClass().getSimpleName();
        //System.out.println("1: "+className);
        String testcaseName = testMethod.getName();
       // System.out.println("2: "+testcaseName);

        try {
            if(ExcelUtility.getTestRunFlag(testCaseSheet, className, testcaseName, "Execution", "N")){
                annotation.setEnabled(false);
                ExcelUtility.writeStatus(testCaseSheet, className, testcaseName, "Status", "Skipped");
            }
        } catch (Exception e) {

            System.out.println("Exception in getting flag in base Class: "+e.getMessage());
        }

    }


    @BeforeMethod(alwaysRun = true)
    public static void getInfo(ITestContext context,Method method)
    {
        //testClassName = context.getAllTestMethods()[0].getInstance().getClass().getSimpleName();
        testClassName = method.getDeclaringClass().getSimpleName();
        System.out.println("class name in before method: "+testClassName);
        testMethodName =method.getName();
        System.out.println("TestCase Name in before Method "+testMethodName);
    }
    @AfterMethod(alwaysRun = true)
    public static void getResult(ITestResult result) throws Exception
    {
	String testclassName = result.getTestClass().getRealClass().getSimpleName();
	String testCaseName = result.getName();
	String testDate = DateAndTime.thrownDateAndTime();
	
	System.out.println("classname: "+testclassName);
    System.out.println("Testcase name: "+testCaseName);
	
	if(result.getStatus()==ITestResult.SUCCESS){
		ExcelUtility.writeStatus(testCaseSheet, testclassName, testCaseName, "status", "PASS");
		ExcelUtility.writeStatus(testCaseSheet, testclassName, testCaseName, "Actual_Output", "same as Expected Output");
	}
	if(result.getStatus()==ITestResult.FAILURE){
		ExcelUtility.writeStatus(testCaseSheet, testclassName, testCaseName, "status", "FAIL");
		Screenshots.takeScreenShots(result.getName() + "_" +testDate);


	}
}



	

}
