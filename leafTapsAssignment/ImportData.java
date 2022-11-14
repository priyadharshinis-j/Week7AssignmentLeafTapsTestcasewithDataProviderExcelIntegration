package leafTapsAssignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Classroom:1
//Create a class with main method
//Step:1 Set the path for wb
//step:2 Get the sheet
//Step 3 Get the row count using the sheet
//step:4 Get the colcount using one row
//Step:5 Use For loop to iterate into each cell
//Step:6 Print the values from each cell

public class ImportData {
	public static String[][] excelData(String fileName,String sheetName) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("./dataImport/"+fileName+".xlsx");
		
		
		XSSFSheet sheetAt = book.getSheet(sheetName);

		int rowCount = sheetAt.getLastRowNum();
		XSSFRow row = sheetAt.getRow(0);
		
		System.out.println(rowCount);
		
		int cellCount = row.getLastCellNum();
		
		System.out.println(cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		System.out.println("Data from all rows and columns");
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String cellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(cellValue);
				data[i-1][j]=cellValue;
			}
		}
		
		book.close();
		return data;
		
		
	}

}
