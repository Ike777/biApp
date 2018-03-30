package com.system.file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/29
 * Version    : 1.0
 * </pre>
 */
public class ExcelImport {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExcelImport.class);

    private Workbook wb;

    private boolean isExcel2007;

    private InputStream is;

    public ExcelImport(InputStream is) throws IOException {
        this.is = is;
        init();
    }

    public ExcelImport(InputStream is, boolean isExcel2007) throws IOException {
        this.is = is;
        this.isExcel2007 = isExcel2007;
        init();
    }

    private void init() throws IOException {
        wb = isExcel2007 ? new XSSFWorkbook(is) : new HSSFWorkbook(is);
    }

    public List<String[]> getSheetData(int sheetIndex) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        return this.getSheetData(sheet);
    }

    public List<String[]> getSheetData(String sheetName) {
        Sheet sheet = wb.getSheet(sheetName);
        return this.getSheetData(sheet);
    }

    private List<String[]> getSheetData(Sheet sheet) {
        List<String[]> dataList = new ArrayList<String[]>();
        int totalRows = sheet.getPhysicalNumberOfRows();
        if (totalRows <= 0) {
            return dataList;
        }
        int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                dataList.add(null);
                continue;
            }
            dataList.add(getRowData(row, totalCells));
        }
        return dataList;
    }

    public List<Map<String, String>> getSheetMap(int sheetIndex) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        return this.getSheetMap(sheet);
    }

    public List<Map<String, String>> getSheetMap(String sheetName) {
        Sheet sheet = wb.getSheet(sheetName);
        return this.getSheetMap(sheet);
    }

    private List<Map<String, String>> getSheetMap(Sheet sheet) {
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        String[] heads = getRowData(sheet.getRow(0), sheet.getRow(0).getPhysicalNumberOfCells());
        int totalRows = sheet.getPhysicalNumberOfRows();
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            Map<String, String> map = new HashMap<String, String>();
            String[] rowData = getRowData(row, heads.length);
            for (int i = 0; i < rowData.length; i++) {
                map.put(heads[i], rowData[i]);
            }
            dataList.add(map);
        }
        return dataList;
    }

    private String[] getRowData(Row row, int totalCells) {
        if (row == null) {
            return new String[0];
        }
        String[] rowList = new String[totalCells];
        for (int c = 0; c < totalCells; c++) {
            Cell cell = row.getCell(c);
            String cellValue = "";
            if (cell == null) {
                rowList[c] = (cellValue);
                continue;
            }
            cellValue = convertCellStr(cell, cellValue);
            rowList[c] = (cellValue);
        }
        return rowList;
    }

    public String convertCellStr(Cell cell, String cellStr) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                // 读取String
                cellStr = cell.getStringCellValue().toString();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                // 得到Boolean对象的方法
                cellStr = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                cellStr = numericCellFormat(cell);
                break;
            case Cell.CELL_TYPE_FORMULA:
                // 读取公式
                cellStr = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return cellStr;
    }

    private String numericCellFormat(Cell cell) {
        // 先看是否是日期格式
        if (DateUtil.isCellDateFormatted(cell)) {
            // 读取日期格式
            return formatTime(cell.getDateCellValue().toString());
        } else {
            // 读取数字
            return String.valueOf(cell.getNumericCellValue());
        }
    }

    private String formatTime(String s) {
        SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = sf.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(ExcelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(date);
        return result;
    }

    public static boolean isExcel2007(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }

    public static void main(String[] args) throws IOException {
        // ExcelImport re = new ExcelImport();
        // List<String[]> list = re.readExcel("c:/群组.xls");

        // List<String[]> list = re.readExcel("c:/群组.xlsx");
        // if (list != null) {
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println("第" + (i + 1) + "行");
        // String[] cellList = list.get(i);
        // for (int j = 0; j < cellList.length; j++) {
        // System.out.print("\t第" + (j + 1) + "列值：");
        // System.out.println(cellList[j]);
        // }
        // }
        // }
        String path = "E:\\dataTemp.xlsx";
        ExcelImport re = new ExcelImport(new FileInputStream(new File(path)),true);
        List<Map<String, String>> list = re.getSheetMap(0);
        StringBuilder data = new StringBuilder();
        for (Map<String, String> map : list) {
            System.out.println(map);
        }

        //FileUtils.writeStringToFile(new File("D:/1.txt"), data.toString());
    }
}
