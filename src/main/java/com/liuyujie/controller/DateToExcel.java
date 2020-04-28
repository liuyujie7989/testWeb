package com.liuyujie.controller;

import com.aliyun.oss.model.ObjectMetadata;
import com.liuyujie.bo.User;
import com.liuyujie.utils.OSSUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DateToExcel {
/*    public static void main(String[] args) throws IOException {

        User user1 = new User("张三", 10, "北大", "1");
        User user2 = new User("李四", 15, "西大", "2");
        User user3 = new User("王五", 12, "南大", "3");
        User user4 = new User("马六", 15, "东大", "4");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

         ByteArrayOutputStream stream = exportProjectList(users);

        String uri = uploadWorkbook(stream, "西安市数字大屏历史数据.xlsx"); // ③

        System.out.println(uri);
    }*/

    public static ByteArrayOutputStream exportProjectList(List<User> users) throws IOException {
        /**
         * 创建一个excel
         */
        HSSFWorkbook workbook = new HSSFWorkbook();
        // excel生成过程: excel-->sheet-->row-->cell
        HSSFSheet sheet = workbook.createSheet("办件数据"); // 为excel创建一个名为test的sheet页

        sheet.setColumnWidth((short) 0, 18 * 256);
        sheet.setColumnWidth((short) 1, 18 * 256);
        sheet.setColumnWidth((short) 2, 15 * 256);
        sheet.setColumnWidth((short) 3, 15 * 256);
        sheet.setColumnWidth((short) 4, 15 * 256);
        //设置统一单元格的高度
        sheet.setDefaultRowHeight((short) 300);

        /**
         * 创建行和单元格
         */
        // 创建行,参数0表示第一行
        HSSFRow row1 = sheet.createRow(0);
        HSSFRow row2 = sheet.createRow(1);
        HSSFRow row3 = sheet.createRow(2);

        HSSFRow row7 = sheet.createRow(6);
        /**
         * 设置每一行的高度
         */
        row1.setHeight((short) 460);
        row2.setHeight((short) 460);
        row3.setHeight((short) 460);
        //创建第一行单元格
        HSSFCell cellB1 = row1.createCell(0);
        cellB1.setCellValue("西安市数字大屏历史数据");
        //创建第二行单元格
        HSSFCell cellB2 = row2.createCell(0);
        cellB2.setCellValue("时间：");
        // 第一行单元格样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        //居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont firstFont = workbook.createFont();
        //加粗
        firstFont.setBold(true);
        //字体大小
        firstFont.setFontHeightInPoints((short) 16);
        headerStyle.setFont(firstFont);

        // 第二行单元格样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        //居中
        style2.setAlignment(HorizontalAlignment.LEFT);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont Font2 = workbook.createFont();
        //字体大小
        Font2.setFontHeightInPoints((short) 14);
        style2.setFont(Font2);
        /**
         * 创建第三行单元格以及样式
         */
        //创建第三行单元格
        /*HSSFCell cellB3 = row3.createCell(0);
        cellB3.setCellValue("事项发布总量");*/

        // 第三行单元格样式
        HSSFCellStyle style3 = workbook.createCellStyle();
        //垂直
        style3.setVerticalAlignment(VerticalAlignment.CENTER);

        //居中
        style3.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont Font3 = workbook.createFont();
        //字体大小
        Font3.setFontHeightInPoints((short) 14);
        Font3.setColor(HSSFColor.WHITE.index);
        style3.setFont(Font3);
        // 设置背景色
        style3.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 边框，居中
        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBorderLeft(BorderStyle.THIN);
        style3.setBorderRight(BorderStyle.THIN);
        style3.setBorderTop(BorderStyle.THIN);

        // 第456行单元格样式
        HSSFCellStyle style4 = workbook.createCellStyle();
        //垂直
        style4.setVerticalAlignment(VerticalAlignment.CENTER);

        //居中
        style4.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont Font4 = workbook.createFont();
        //字体大小
        Font4.setFontHeightInPoints((short) 14);
        Font4.setColor(HSSFColor.BLACK.index);
        style4.setFont(Font4);
        // 设置背景色
       /* style4.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);*/
        // 边框，居中
        style4.setBorderBottom(BorderStyle.THIN);
        style4.setBorderLeft(BorderStyle.THIN);
        style4.setBorderRight(BorderStyle.THIN);
        style4.setBorderTop(BorderStyle.THIN);

/**
 * 第三行单元格赋值
 */
        List<String> list = new ArrayList<>();
        list.add("事项发布总量");
        list.add("大厅现场办理");
        list.add("办件量");
        list.add("网上办理");
        list.add("办件量");
        setThreeRow(row3, list, style3);
        /**
         * 第456行单元格赋值
         */
        setFourToSixRow(sheet, style4);


        // 第一行单元格添加样式
        cellB1.setCellStyle(headerStyle);
        // 第二行单元格添加样式
        cellB2.setCellStyle(style2);

        /**
         * 第七行单元格赋值
         */
        row7.setHeight((short) 460);
        HSSFCell cell_one = row7.createCell(0);
        HSSFCell cell_two = row7.createCell(4);
        cell_one.setCellValue("前五事项名称");
        cell_one.setCellStyle(style3);
        cell_two.setCellValue("办件量");
        cell_two.setCellStyle(style3);

        /**
         * 前五事项名称和办件量
         */
        setFiveItemCountRow(sheet,style4,users);
        //合并单元格

        setBorder(sheet,"A1:E1");// 给第一行
        setBorder(sheet,"A2:E2");// 给第二行
        setBorder(sheet,"A4:A6");// 给第四行
        setBorder(sheet,"A7:D7"); // 给第七行

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\qqq\\Desktop\\user.xls");
            workbook.write(fos);

            //System.out.println("写入成功");
            fos.close();




        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();

        workbook.write(stream);
        return stream;
    }

    /**
     * 第三行
     * @param row
     * @param cellTitles
     * @param style
     */
    private static void setThreeRow(Row row, List<String> cellTitles, HSSFCellStyle style) {

        int cellSign = 0;

        for (String cellName : cellTitles) {
            final Cell cell = row.createCell(cellSign++);
            cell.setCellValue(cellName);
            cell.setCellStyle(style);
        }
    }

    /**
     *第456行
     * @param sheet
     * @param style
     */
    private static void setFourToSixRow(HSSFSheet sheet, HSSFCellStyle style) {

        HSSFRow row4 = sheet.createRow(3);
        HSSFRow row5 = sheet.createRow(4);
        HSSFRow row6 = sheet.createRow(5);
        row4.setHeight((short) 460);
        row5.setHeight((short) 460);
        row6.setHeight((short) 460);

        for (int i = 0; i < 5; i++) {
            Cell cell4 = row4.createCell(i);
            cell4.setCellStyle(style);
            Cell cell5 = row5.createCell(i);
            cell5.setCellStyle(style);
            Cell cell6 = row6.createCell(i);
            cell6.setCellStyle(style);

            if (i == 1 || i == 3) {
                cell4.setCellValue("总办件量");
                cell5.setCellValue("办结量");
                cell6.setCellValue("涉企办件量");
            } else if (i == 0) {
                cell4.setCellValue("事项发布总量1000");

            } else if (i == 2) {
                cell4.setCellValue("4大厅现场办理总办件量1000");
                cell5.setCellValue("5大厅现场办理总办件量1000");
                cell6.setCellValue("6大厅现场办理总办件量1000");
            }else if (i == 4) {
                cell4.setCellValue("4网上办理总办件量1000");
                cell5.setCellValue("5网上办理总办件量1000");
                cell6.setCellValue("6网上办理总办件量1000");
            }
        }
    }
    /**
     *前五事项名称和办件量
     * @param sheet
     * @param style
     */
    private static void setFiveItemCountRow(HSSFSheet sheet, HSSFCellStyle style,List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            HSSFRow row = sheet.createRow(7 + i);
            row.setHeight((short) 460);
            HSSFCell cell_one = row.createCell(0);
            HSSFCell cell_two = row.createCell(4);
            cell_one.setCellValue(users.get(i).getName());
            cell_one.setCellStyle(style);
            cell_two.setCellValue(users.get(i).getAge());
            cell_two.setCellStyle(style);
            //合并单元格并加边框
            setBorder(sheet,"A"+(i+8)+":D"+(i+8));

        }
    }

    /**
     * 合并单元格以及加边框
     * @param sheet
     * @param
     */
    private static void setBorder(HSSFSheet sheet, String strCell ) {
        CellRangeAddress region = CellRangeAddress.valueOf(strCell);
        sheet.addMergedRegion(region);
        //使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(BorderStyle.THIN, region, sheet); // 下边框
        RegionUtil.setBorderLeft(BorderStyle.THIN, region, sheet); // 左边框
        RegionUtil.setBorderRight(BorderStyle.THIN, region, sheet); // 有边框
        RegionUtil.setBorderTop(BorderStyle.THIN, region, sheet); // 上边框
    }




    public static String uploadWorkbook(ByteArrayOutputStream stream, String fileId) throws IOException {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(stream.toByteArray());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(stream.size());
        objectMetadata.setContentEncoding("utf-8");
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");

        //inline 将文件内容直接显示在页面  attachment 弹出对话框让用户下载   filename=cccc 就是下载下来的文件名

        objectMetadata.setContentDisposition("inline;filename=" + fileId);

        return uploadByStream(fileId, objectMetadata, inputStream);
    }

    /**
     * 上传oss
     */
  private static String uploadByStream(String fileId, ObjectMetadata metadata, InputStream in) throws IOException {

      String url = OSSUtil.uploadImageToOSS(fileId, in,metadata);

      in.close();
       return url;
    }
}
