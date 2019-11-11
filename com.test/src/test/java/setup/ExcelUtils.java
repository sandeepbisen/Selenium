package setup;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

	private static FileInputStream excelFile;
	private static String filePath;


public static Object[][] readExcelData(String sheetName) throws Exception {
	String[][] arrayExcelData = null;
	try {
			DataFormatter formatter = new DataFormatter();
			filePath = "C:\\CognizantCCA\\com.test\\customer_registration.xlsx";	
			excelFile = new FileInputStream(new File(filePath));
	        ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
				
	        XSSFRow Row=ExcelWSheet.getRow(0);     //get my Row which start from 0   
	        
	        int RowNum = ExcelWSheet.getPhysicalNumberOfRows();// count my number of Rows
	        int ColNum= Row.getLastCellNum(); // get last ColNum 
	         
	        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	         
	            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	            {  
	                XSSFRow row= ExcelWSheet.getRow(i+1);
	                 
	                for (int j=0; j<ColNum; j++) //Loop work for colNum
	                {
	                    if(row==null)
	                        Data[i][j]= "";
	                    else
	                    {
	                        XSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data 
	                        else
	                        {
	                            String value=formatter.formatCellValue(cell);
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                        }
	                    }
	                }
	            }
	 
	        return Data;
	    }
		finally {
			excelFile.close();
		}
	}
}
