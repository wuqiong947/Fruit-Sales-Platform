package com.fruitsalesplatform.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javafx.scene.input.DataFormat;



public abstract class BaseController {

  /**
   * SpringMVC默认不支持这个表单中的日期字符串和JavaBean的Date类型的转换<br>
   * 所以需要手动配置，自定义数据的绑定才能解决这个问题<br>
   * 
   * @param binder
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 这个方法的含义是是否严格解析日期,这种情况下java会把你输入的日期进行计算
    dataFormat.setLenient(true);

    binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, true));

  }
}
