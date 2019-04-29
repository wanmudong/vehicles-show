package io.github.wanmudong.vehiclesshow.utils;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wanmudong
 * @date 2019/4/29
 */
@Data
public class MyPageInfo<T> implements Serializable {

    private static final long serialVersionUID = 4042924045710218720L;

    /**
     * 总记录数
     */
    private int total;
    /**
     * 每页条数
     */
    private int size;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 当前页数
     */
    private int page;
    /**
     * 具体数据
     */
    private List<T> list;

    public MyPageInfo(Page<T> page) {
        this.size = (int) page.getSize();
        this.total = (int) page.getTotal();
        this.pages = (int) page.getPages();
        this.page = (int) page.getCurrent();
        this.list = page.getRecords();
    }

    public MyPageInfo(PageInfo<T> pageInfo) {
        this.size = pageInfo.getSize();
        this.total = (int) pageInfo.getTotal();
        this.pages =pageInfo.getPages();
        this.page = pageInfo.getPageNum();
        this.list = pageInfo.getList();
    }
    public MyPageInfo(PageInfo<T> pageInfo, List list) {
        this.size = pageInfo.getSize();
        this.total = (int) pageInfo.getTotal();
        this.pages =pageInfo.getPages();
        this.page = pageInfo.getPageNum();
        this.list = list;
    }



}
