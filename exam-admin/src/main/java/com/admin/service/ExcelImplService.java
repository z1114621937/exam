package com.admin.service;

import com.common.api.CommonResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface ExcelImplService {

    CommonResult addStudentByExcel(MultipartFile file);

}
