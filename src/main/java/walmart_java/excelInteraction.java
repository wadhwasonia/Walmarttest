package walmart_java;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class excelInteraction {
    private static  XSSFSheet ExcelWSheet;

    private static   XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;



    public static List<String> getData(String FilePath, String SheetName) throws Exception {

        String[][] dataArray = null;
        List<String> val = new ArrayList<String>();

        XSSFCell cellvalue = null;
        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

             ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);


            int ci, cj;

            int rowcount = ExcelWSheet.getLastRowNum();
            int cellcount = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
            dataArray = new String[rowcount][cellcount];


            ci = 0;
            for (int r = 1; r <=rowcount; r++, ci++) {
                XSSFRow row = ExcelWSheet.getRow(r);

                cj = 0;

                for (int c = 0; c <cellcount; c++, cj++) {

                    cellvalue = row.getCell(c);
                    if(cellvalue.getCellType()== XSSFCell.CELL_TYPE_STRING)
                    {dataArray[ci][cj] = cellvalue.getStringCellValue();
                    val.add(dataArray[ci][cj]);
                    }
                    else
                    {
                        double v1 = cellvalue.getNumericCellValue();
                    long v = (new Double(v1).longValue());
                        String conv =String.valueOf(v);
                        dataArray[ci][cj]=conv;
                        val.add(dataArray[ci][cj]);
                    }



                }

            }


        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return val;
    }
}