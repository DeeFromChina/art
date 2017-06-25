package com.golead.art.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

public class PrintExcel {
   
   /**
    * 整型
    */
   public final static Integer       INT         = 1;

   /**
    * 浮点型
    */
   public final static Integer       DOUBLE      = 2;

   /**
    * 字符串
    */
   public final static Integer       STRING      = 3;
   
   private int                       rowtoCopy;

   private int                       maxRowOfPage;

   private int                       headRowStart;

   private int                       headRowEnd;

   private String[]                  dataFields;

   private List<PrintPoint>          printPointList;

   private List<Map<String, Object>> dataList;

   private boolean                   isForcePage = false;

   public void setRowtoCopy(int rowtoCopy) {
      this.rowtoCopy = rowtoCopy;
   }

   public void setDataFields(String[] dataFields) {
      this.dataFields = dataFields;
   }

   public void setMaxRowOfPage(int maxRowOfPage) {
      this.maxRowOfPage = maxRowOfPage;
   }

   public void setHeadRowStart(int headRowStart) {
      this.headRowStart = headRowStart;
   }

   public void setHeadRowEnd(int headRowEnd) {
      this.headRowEnd = headRowEnd;
   }

   public void setPrintPointList(List<PrintPoint> printPointList) {
      this.printPointList = printPointList;
   }

   public void setDataList(List<Map<String, Object>> dataList) {
      this.dataList = dataList;
   }

   public void setForcePage(boolean isForcePage) {
      this.isForcePage = isForcePage;
   }

   /**
    * 执行打印操作，适用于只有一个sheet的模板
    * 
    * @param response
    * @param tmpFile
    *           模板文件
    * @throws Exception
    */
   public void doPrint(HttpServletResponse response, File tmpFile) throws Exception {

      //String  fileName=new String(docName.getBytes("UTF-8"),"iso8859-1");
      response.setContentType("application/ms-excel");

      InputStream inp = null;
      inp = new FileInputStream(tmpFile);
      HSSFWorkbook wb = null;
      POIFSFileSystem f = new POIFSFileSystem(inp);
      wb = new HSSFWorkbook(f);
      doFillSheet(wb, 0);

      OutputStream out = response.getOutputStream();
      wb.write(out);
      out.flush();
      out.close();

   }

   /**
    * 执行打印操作，适用于有多个sheet的模板
    * 
    * @param response
    * @param tmpFile
    *           模板文件
    * @param wb
    *           工作表对象
    * @throws Exception
    */
   public void doPrint(HttpServletResponse response, File tmpFile, HSSFWorkbook wb) throws Exception {

      //String  fileName=new String(docName.getBytes("UTF-8"),"iso8859-1");
      response.setContentType("application/ms-excel");

      OutputStream out = response.getOutputStream();
      wb.write(out);
      out.flush();
      out.close();

   }

   /**
    * 得到工作表对象，以便后面对工作表对象的其它sheet进行操作
    * 
    * @param response
    * @param tmpFile
    *           模板文件
    * @param sheetIndex
    *           当前填充数据的sheet索引
    * @return
    * @throws Exception
    */
   public HSSFWorkbook getWorkbook(HttpServletResponse response, File tmpFile, int sheetIndex) throws Exception {
      InputStream inp = null;
      inp = new FileInputStream(tmpFile);
      HSSFWorkbook wb = null;
      POIFSFileSystem f = new POIFSFileSystem(inp);
      wb = new HSSFWorkbook(f);
      doFillSheet(wb, sheetIndex);

      return wb;

   }

   /**
    * 填充数据至指定表单
    * 
    * @param sheet
    */
   public void doFillSheet(HSSFWorkbook wb, int sheetIndex) {
      HSSFSheet sheet = wb.getSheetAt(sheetIndex);

      PrintPoint dynamicPoint = null;
      String dynamicField = "";
      //填充指定位置数据
      if (printPointList != null) {
         for (PrintPoint printPoint : printPointList) {
            Cell cell = sheet.getRow(printPoint.getY()).getCell(printPoint.getX());
            Object obj = printPoint.getPointValue();
            if (obj == null) {
               cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
            }
            else if (printPoint.getCellType() == INT) {
               cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
               cell.setCellValue(Integer.valueOf(obj.toString()));
            }
            else if (printPoint.getCellType() == DOUBLE) {
               cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
               cell.setCellValue(Double.valueOf(obj.toString()));
            }
            else {
               cell.setCellValue(obj.toString());
            }
            if (printPoint.isDynamic() && printPoint.getDynamicField().contains("dynamic")) { //包含dynamic，说明该printPoint的值是判断强制分页边界点的标记
               dynamicPoint = printPoint;
               dynamicField = dynamicPoint.getDynamicField();
            }
         }
      }

      //填充列表数据
      if (dataList != null) {
         int rowtoInsert = rowtoCopy + 1;
         int lastRowIndex = rowtoCopy - 1;
         int headRowCount = headRowEnd - headRowStart + 1;
         int currentDataRow = 0;
         int currentPageRowCount = 0; //记录当前页记录条数
         String dynamicValue = "";
         for (Map<String, Object> map : dataList) {

            //强制分页，复制表头，并修改相关表头信息
            if (isForcePage) {
               String newDynamicValue = map.get(dynamicField).toString();
               if (!dynamicValue.equals("") && !dynamicValue.equals(newDynamicValue)) { //强制分页，复制表头

                  sheet.setRowBreak(lastRowIndex);

                  copyRows(sheet, headRowStart, headRowEnd, rowtoInsert, lastRowIndex);

                  //强制分页后，修改相关表头信息 （当前程序只能修改作为标记的printPoint，也就是说实际能动态赋值的printPoint只有一个）
                  Cell cell = sheet.getRow(dynamicPoint.getY() + rowtoInsert - 1).getCell(dynamicPoint.getX());
                  cell.setCellValue(newDynamicValue);

                  //重新定位表头
                  headRowStart = rowtoInsert;
                  headRowEnd = headRowStart + headRowCount - 1;

                  rowtoInsert += headRowCount;
                  lastRowIndex += headRowCount;
                  currentDataRow = 0; //强制分页后，currentDataRow清0,以便后面自然分页
                  currentPageRowCount = 0; //强制分页后，当前页记录条数为0
               }
               dynamicValue = newDynamicValue;
            }

            //自然分页，复制表头
            if (currentDataRow != 0 && currentDataRow % maxRowOfPage == 0) {
               copyRows(sheet, headRowStart, headRowEnd, rowtoInsert, lastRowIndex);

               rowtoInsert += headRowCount;
               lastRowIndex += headRowCount;
               currentPageRowCount = 0; //自然分页后，当前页记录条数为0
            }
            copyRows(sheet, rowtoCopy, rowtoCopy, rowtoInsert, lastRowIndex);
            Iterator<Cell> cells = sheet.getRow(rowtoInsert - 1).cellIterator();
            int i = 0;
            while (cells.hasNext()) {
               if (i >= dataFields.length) break;
               Cell cell = cells.next();
               String cellValue = map.get(dataFields[i]) == null ? "" : map.get(dataFields[i]).toString();
               cell.setCellValue(cellValue);
               i++;
            }

            rowtoInsert++;
            lastRowIndex++;
            currentDataRow++;
            currentPageRowCount++;
         }

         //计算最后一页的空行数
         int blankRows = maxRowOfPage - currentPageRowCount;
         for (int i = 0; i < blankRows; i++) {
            copyRows(sheet, rowtoCopy, rowtoCopy, rowtoInsert, lastRowIndex);
            rowtoInsert++;
            lastRowIndex++;
         }

         sheet.removeRow(sheet.getRow(rowtoCopy - 1));
         sheet.shiftRows(rowtoCopy, lastRowIndex, -1, true, false);
         lastRowIndex--;
      }
   }

   public void copyRows(HSSFSheet st, int startRow, int endRow, int position, int lastRowIndex) {
      int pStartRow = startRow - 1;
      int pEndRow = endRow - 1;
      int pPosition = position - 1;

      CellRangeAddress region = null;
      int targetRowFrom;
      int targetRowTo;

      int shiftRowCount = pEndRow - pStartRow + 1;
      int columnCount;
      int i;
      int j;

      if (pStartRow == -1 || pEndRow == -1) return;

      //合并单元格
      for (i = 0; i < st.getNumMergedRegions(); i++) {
         region = st.getMergedRegion(i);
         if ((region.getFirstRow() >= pStartRow) && (region.getLastRow() <= pEndRow)) {
            targetRowFrom = region.getFirstRow() - pStartRow + pPosition;
            targetRowTo = region.getLastRow() - pStartRow + pPosition;
            CellRangeAddress newRegion = region.copy();
            newRegion.setFirstRow(targetRowFrom);
            newRegion.setFirstColumn(region.getFirstColumn());
            newRegion.setLastRow(targetRowTo);
            newRegion.setLastColumn(region.getLastColumn());
            st.addMergedRegion(newRegion);
         }
      }

      //只有当插入的位置小于等于最后一行时才需要移动下面的行
      if (pPosition <= lastRowIndex) st.shiftRows(pPosition, lastRowIndex, shiftRowCount, true, false);
      //当插入的位置小于等于复制的位置时，由于下面的行（包括复制的位置）都会往下移动，所以需要重新计算复制的位置
      if (position <= startRow) {
         pStartRow += shiftRowCount;
         pEndRow += shiftRowCount;
      }
      //set the column height and value         
      for (i = pStartRow; i <= pEndRow; i++) {
         HSSFRow sourceRow = st.getRow(i);
         columnCount = sourceRow.getLastCellNum();
         if (sourceRow != null) {

            HSSFRow newRow = st.createRow(pPosition + i - pStartRow);
            newRow.setHeight(sourceRow.getHeight());
            for (j = 0; j < columnCount; j++) {
               HSSFCell templateCell = sourceRow.getCell(j);
               if (templateCell != null) {
                  HSSFCell newCell = newRow.createCell(j);
                  copyCell(templateCell, newCell);
               }
            }
         }
      }

   }

   private void copyCell(HSSFCell srcCell, HSSFCell distCell) {
      distCell.setCellStyle(srcCell.getCellStyle());
      if (srcCell.getCellComment() != null) {
         distCell.setCellComment(srcCell.getCellComment());
      }
      int srcCellType = srcCell.getCellType();
      distCell.setCellType(srcCellType);
      if (srcCellType == HSSFCell.CELL_TYPE_NUMERIC) {
         if (HSSFDateUtil.isCellDateFormatted(srcCell)) {
            distCell.setCellValue(srcCell.getDateCellValue());
         }
         else {
            distCell.setCellValue(srcCell.getNumericCellValue());
         }
      }
      else if (srcCellType == HSSFCell.CELL_TYPE_STRING) {
         distCell.setCellValue(srcCell.getRichStringCellValue());
      }
      else if (srcCellType == HSSFCell.CELL_TYPE_BLANK) {

      }
      else if (srcCellType == HSSFCell.CELL_TYPE_BOOLEAN) {
         distCell.setCellValue(srcCell.getBooleanCellValue());
      }
      else if (srcCellType == HSSFCell.CELL_TYPE_ERROR) {
         distCell.setCellErrorValue(srcCell.getErrorCellValue());
      }
      else if (srcCellType == HSSFCell.CELL_TYPE_FORMULA) {
         distCell.setCellFormula(srcCell.getCellFormula());
      }
      else {
      }
   }

}
