package com.admin.service.impl;

import com.admin.service.ExcelImplService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.StudentMapper;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class ExcelServiceImpl  extends ServiceImpl<StudentMapper, Student> implements ExcelImplService {



    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
    @SneakyThrows
    @Override
    public CommonResult addStudentByExcel(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return CommonResult.failed("文件夹不能为空");
        }
        InputStream inputStream = file.getInputStream();
        List list = new ArrayList<>();
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            return CommonResult.failed("请上传excel文件！");
        }
        if (null == workbook) {
            return CommonResult.failed("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        inputStream.close();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = (List<Object>) list.get(i);
          // System.out.println(lo.size());
            for(int j = 0; j < lo.size(); j++)
            {
            //    System.out.print(lo.get(j).toString());
                if (lo.get(j).toString().isEmpty())
                {
                    return CommonResult.failed("请检查excel的完整性");
                }

            }
            Student student=new Student();
            student.setName(lo.get(0).toString());
            student.setUsername(lo.get(1).toString());
            student.setPassword(passwordEncoder().encode(lo.get(2).toString()));
            student.setSchool(lo.get(3).toString());
            student.setClasses(lo.get(4).toString());
            int result=baseMapper.insert(student);
        }
        return CommonResult.success("上传成功");
    }

}
