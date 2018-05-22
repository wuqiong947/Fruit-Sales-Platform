package com.fruitsalesplatform.entity;

/**
 * 零售商vo
 * 
 * @author 12071
 *
 */
public class Retailer extends PageEntity{

  /**
   * 零售商ID
   */
  private String retailerId;
  /**
   * 零售商姓名
   */
  private String name;
  /**
   * 零售商手机号
   */
  private String telephone;
  /**
   * 零售商地址
   */
  private String address;
  /**
   * 状态
   */
  private int status;
  /**
   * 创建时间
   */
  private String createTime;
  
  
  
  
  public String getRetailerId() {
    return retailerId;
  }
  public void setRetailerId(String retailerId) {
    this.retailerId = retailerId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTelephone() {
    return telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getCreateTime() {
    return createTime;
  }
  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
