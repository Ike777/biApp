package com.system.file;

import com.system.date.DateFormat;
import com.system.exception.SystemException;
import com.system.mybatis.BeanUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/1/29
 * Version    : 1.0
 * </pre>
 */
public class Excel {

    private static final Logger logger = LoggerFactory.getLogger(Excel.class);

    private HSSFWorkbook wb = new HSSFWorkbook();

    public HSSFRow addRow(HSSFSheet sheet, int index, int height, HSSFCellStyle cellStyle, String[] titles) {
        HSSFRow row = sheet.createRow(index);
        for (int i = 0; i < titles.length; ++i) {
            HSSFCell cell = addCell(row, i, titles[i]);
            if (cellStyle != null) {
                cell.setCellStyle(cellStyle);
            }
        }

        // row.setHeight((short) (int) (height * 15.625D));
        return row;
    }

    public HSSFCell addCell(HSSFRow row, int index, Object value) {
        HSSFCell cell = row.createCell(index);
        if (value instanceof String) {
            cell.setCellType(1);
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            cell.setCellType(0);
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellType(0);
            cell.setCellValue((Double) value);
        } else if (value instanceof Date) {
            cell.setCellType(0);
            cell.setCellValue((Date) value);
        } else {
            cell.setCellType(1);
            cell.setCellValue(value != null ? value.toString() : "");
        }
        return cell;
    }

    public HSSFRow createRow(HSSFSheet sheet, int index) {
        HSSFRow row = sheet.createRow(index);
        return row;
    }

    public void setColumnWidth(HSSFSheet sheet, int index, int width) {
        sheet.setColumnWidth(index, 35 * width);
    }

    public void setColumnWidth(HSSFSheet sheet, int start, int end, int width) {
        for (int i = start; i <= end; ++i) {
            sheet.setColumnWidth(i, 35 * width);
        }
    }

    public HSSFCellStyle getBorderStyle(HSSFWorkbook wb, short top, short right, short bottom, short left) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(top);
        cellStyle.setBorderLeft(right);
        cellStyle.setBorderRight(bottom);
        cellStyle.setBorderTop(left);
        cellStyle.setWrapText(true);
        cellStyle.setAlignment((short) 2);
        cellStyle.setVerticalAlignment((short) 1);
        return cellStyle;
    }

    public HSSFCellStyle getBorderStyle(HSSFWorkbook wb, int border) {
        return getBorderStyle(wb, (short) border, (short) border, (short) border, (short) border);
    }

    public HSSFFont getFontStyle(HSSFWorkbook wb, short color, int fontSize, int fontWeight) {
        HSSFFont font = wb.createFont();
        font.setColor(color);
        font.setBoldweight((short) fontSize);
        font.setFontHeightInPoints((short) fontSize);
        font.setBoldweight((short) fontWeight);
        return font;
    }

    public void write(OutputStream stream) {
        try {
            write(stream, true);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void writeWebExcel(HttpServletRequest request, HttpServletResponse response, String fileName) {
        try {
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-disposition", "attachment;filename=\"" + fileName + ".xls" + "\"");
            write(response.getOutputStream(), true);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void write(OutputStream stream, boolean close) throws IOException {
        wb.write(stream);
        if (close) {
            stream.flush();
            stream.close();
        }
    }

    public <T> HSSFSheet createHSSFSheet(String title, String[] heads, String[] fileds, List<T> list) {
        HSSFSheet st = title == null ? wb.createSheet() : wb.createSheet(title);

        // 表头样式
        // HSSFCellStyle headStyle = this.getBorderStyle(wb, 0);
        // headStyle.setFont(this.getFontStyle(wb, HSSFColor.BLACK.index, 10,
        // HSSFFont.BOLDWEIGHT_BOLD));

        // 全局文字样式
        // HSSFCellStyle styletxt = this.getBorderStyle(wb, 0);
        // styletxt.setFont(this.getFontStyle(wb, HSSFColor.BLACK.index, 10,
        // HSSFFont.BOLDWEIGHT_NORMAL));

        // 行索引
        int rowIndex = 0;

        if (title != null) {
            // 添加表头
            CellRangeAddress region = new CellRangeAddress(0, 0, 0, heads.length - 1);
            st.addMergedRegion(region);
            this.addRow(st, rowIndex++, 33, null, new String[]{title});
        }

        this.addRow(st, rowIndex++, 33, null, heads);

        // 设置列宽
        // this.setColumnWidth(st, 0, 9, 150);

        for (T t : list) {
            HSSFRow row = this.createRow(st, rowIndex++);
            int comumnIndex = 0;
            if (fileds == null) {
                if (t.getClass().isArray()) {
                    for (int i = 0; i < Array.getLength(t); i++) {
                        this.addCell(row, comumnIndex++, Array.get(t, i));// .setCellStyle(styletxt);
                    }
                } else if (t instanceof List) {
                    List<?> values = (List<?>) t;
                    for (Object val : values) {
                        this.addCell(row, comumnIndex++, val);// .setCellStyle(styletxt);
                    }
                } else {
                    throw new SystemException("未知数据类型");
                }
            } else {
                for (String filed : fileds) {

                    Object val = null;
                    if (filed != null) {
                        if (filed.contains("?")) {
                            String[] ss = filed.split("\\?");
                            String filedName = ss[0];

                            String pattern = "[a-zA-Z0-9_]*\\(([a-zA-Z0-9_',]*)\\)";
                            Pattern reg = Pattern.compile(pattern);
                            Matcher m = reg.matcher(ss[1]);
                            // 字典
                            try {
                                if (m.find()) {
                                    String methodName = m.group(0);
                                    String params = m.group(1).replace("'", "");
                                    if (methodName.startsWith("Dict(")) {
                                        Object val1 = BeanUtils.getValue(t, filedName);
                                        //val = DictCache.getDictValue(params, (String) val1);
                                    } else if (methodName.startsWith("Date(")) {
                                        Date date = (Date) BeanUtils.getValue(t, filedName);
                                        val = DateFormat.dateToString(date, params);
                                    } else {
                                        throw new SystemException("表达式错误:" + filed);
                                    }
                                } else {
                                    throw new SystemException("表达式错误:" + filed);
                                }
                            } catch (Exception e) {
                                throw new SystemException("表达式错误" + filed, e);
                            }
                        } else {
                            val = BeanUtils.getValue(t, filed);
                        }
                    }
                    this.addCell(row, comumnIndex++, val);// .setCellStyle(styletxt);
                }
            }
        }
        return st;
    }

    public static void main(String[] args) {
        Excel excel = new Excel();
        List<Object> list = new ArrayList<Object>();
        String[] fileds = {"id", "key"};
        String[] heads = {"编号", "名称"};
        excel.createHSSFSheet(null, heads, fileds, list);
        try {
            excel.write(new FileOutputStream(new File("D:/tt.xls")));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
    }
}


