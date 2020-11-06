package cn.project.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cyp
 * @date 2020/8/5
 */
@Slf4j
public class ExcelUtil {

    /**
     * 查询指定目录中电子表格中所有的数据
     *
     * @param in 输入流
     * @return
     */
    public static List<?> insertByExcel(InputStream in, Object obj) {
        List<Object> list = new ArrayList<>();

        try {
            XSSFWorkbook rwb = new XSSFWorkbook(in);
            XSSFSheet sheet = rwb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Class clas = obj.getClass();
                Object object = clas.newInstance();
                row = sheet.getRow(i);
                //去除空行数值
                if (null == sheet.getRow(i).getCell(1) && null == sheet.getRow(i+1).getCell(1)){
                    break;
                }
                //获取Test类当前属性的setXXX方法（私有和公有方法）
                Field[] fields = obj.getClass().getDeclaredFields();
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    if (null != cell){
                        //循环set对象属性值
                        String fieldName = fields[j].getName();
                        // 将属性的首字符大写，方便构造get，set方法
                        String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        // 获取属性的类型
                        String type = fields[j].getGenericType().toString();
                        try {
                            String typeLong = "class java.lang.Long";
                            String typeString = "class java.lang.String";
                            // 如果type是类类型，则前面包含"class "，后面跟类名
                            if (type.equals(typeString)) {
                                Method setMethod = obj.getClass().getDeclaredMethod("set" + methodName, String.class);
                                setMethod.invoke(object, String.valueOf(cell));
                                if (log.isDebugEnabled()) {
                                    log.debug("第" + i + "行第" + j + "列的值为-------" + cell);
                                }
                            } else if (type.equals(typeLong)) {
                                Method setMethod = obj.getClass().getDeclaredMethod("set" + methodName, Long.class);
                                setMethod.invoke(object, Long.parseLong(String.valueOf(cell)));
                                if (log.isDebugEnabled()) {
                                    log.debug("第" + i + "行第" + j + "列的值为-------" + cell);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    }
                list.add(object);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
