package com.hy.crm.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelUtil<T> {
    /*
    * excel导入到数据库
    * */
    public  List<T> importExcel(InputStream in,Class<T> clas) throws IOException, IllegalAccessException, InstantiationException {
        List<T> list=new ArrayList<>();
        Workbook workbook=new HSSFWorkbook(in);
        Sheet sheet=workbook.getSheetAt(0);//得到第一个sheet
        int rowNum=sheet.getLastRowNum();//得到当前sheet最后一行的下标，用于做下方循环
        for(int i=1;i<=rowNum;i++){
            Row row=sheet.getRow(i);//循环获取所有行
            T obj=clas.newInstance();
            Field[] fields=obj.getClass().getDeclaredFields();
            int cellNum=row.getLastCellNum();//得到当前行的最后一列下标
            for(int j=0;j<cellNum;j++){
                Cell cell=row.getCell(j);//循环得出当前行的所有列
                Object value=getCellValue(cell);
                fields[j+1].setAccessible(true);
                if(fields[j+1].getType()==String.class){
                    fields[j+1].set(obj,value);
                }else{
                    fields[j+1].set(obj,value);
                }
            }
            list.add(obj);
        }
        return list;
    }
    /*
    * 数据库导入excel
    * */
    public HSSFWorkbook outPutExcel(String filename,String[] tol,List<T> list) throws IllegalAccessException, InstantiationException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        Sheet sheet=workbook.createSheet(filename);
        Row row=sheet.createRow(0);
        for(int i=0;i<tol.length;i++){
            row.createCell(i).setCellValue(tol[i]);
        }
        for(int j=1;j<=list.size();j++){
            Row row1=sheet.createRow(j);
            T obj=list.get(j-1);
            Field[] fields=obj.getClass().getDeclaredFields();
            for(int c=0;c<tol.length;c++){
                fields[c+1].setAccessible(true);
                row1.createCell(c).setCellValue(fields[c+1].get(obj).toString());
            }
        }
        return workbook;
    }
    /*
    * excel导入数据库取值
    * */
    public static  Object getCellValue(Cell cell){
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化字符类型的数字
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
           /* case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;*/
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }
}
