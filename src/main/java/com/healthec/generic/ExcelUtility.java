package com.healthec.generic;

public class ExcelUtility {
	
	public static String readTestdata(ExcelData ed,String sheetName,int rowNum,int colNum){
		return ed.retrieveTestData(sheetName, rowNum, colNum);
	}
	public static boolean getTestRunFlag(ExcelData ed,String sheetName,String rowName,String columnName,String value) throws Exception{
		
		boolean flag = false;
		
		if(!(ed.retrieveFlag(sheetName, rowName, columnName).equalsIgnoreCase("Y")||ed.retrieveFlag(sheetName, rowName, columnName).equalsIgnoreCase("N")))
		{
			throw new Exception("Enter values like Y or N");
		}
		
		else if(ed.retrieveFlag(sheetName, rowName, columnName).equalsIgnoreCase(value)){
			flag = true;
		}
		else{
			//System.out.println("Enter values like Y or N");
			flag = false;
		}
		return flag;
	}
	public static boolean writeStatus(ExcelData dx,String sheetName,String rowName,String colName,String status){
		  return dx.writeResult(sheetName, rowName, colName, status);
	}
	public static int retrieveTotalRows(ExcelData dx,String sheetName)
	{
		return dx.retrievenoOfRows(sheetName);
	}

}
