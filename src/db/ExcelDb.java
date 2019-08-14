package db;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDb<E> implements DbStrategy<E>{
    private List<String[]> items;
    public ExcelDb(){}

    public void save( ) {
        File file = new File("src//testdata//item.xls");

     try {
         WritableWorkbook workbook = Workbook.createWorkbook(file);
         workbook.createSheet("sheet1", 0);
         WritableSheet sheet = workbook.getSheet(0);
         for (int i = 0; i < items.size(); i++) {
             String[] parameters = items.get(i);
             for (int j = 0; j < parameters.length; j++) {
                 Label label = new Label(j, i, parameters[j]);
                 sheet.addCell(label);
             }
         }
         workbook.write();
         workbook.close();
     }catch (Exception ex){
         System.out.println(ex.getMessage());
         ex.printStackTrace();
     }
    }

    public void load() {
        ArrayList<String[]> info = new ArrayList<>();
        try{
            File file = new File("src//testdata//item.xls");

        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        int row = 0;


        while(row < sheet.getRows())
        {
            int column = 0;
            String rowinfo="";
            while(column < sheet.getColumns()){
                Cell cell = sheet.getCell(column,row);
                String information = cell.getContents();
                rowinfo= rowinfo +information + ",";
                column++;
            }
            String[] split = rowinfo.split(",");
            info.add(split);
            row++;
        }
        workbook.close();

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        this.items= info;
    }

    public List<String[]> getItems() {
        return items;
    }

    public void setItems(List<String[]> items) {
        this.items = items;
    }
}