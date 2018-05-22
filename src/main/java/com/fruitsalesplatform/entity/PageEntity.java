package com.fruitsalesplatform.entity;

/**
 * 分页查询VO
 * 
 * @author 12071
 *
 */
public class PageEntity {
  /**
   * 开始页面
   */
  private Integer currentPage;
  /**
   * 起始数据位置
   */
  private Integer startPage;
  /**
   * 每页要取的数据
   */
  private Integer pageSize;



  public Integer getCurrentPage() {
    if (currentPage == null) {
      currentPage = 1;
    }
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public int getStartPage() {
    if (startPage == null) {
      startPage = 0;
    }
    return startPage;
  }

  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }

  public int getPageSize() {
    if (pageSize == null) {
      pageSize = 10;
    }
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

}
