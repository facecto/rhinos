package com.facecto.code.rhinos.service.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.0.0 (2021/08/08)
 */
@Getter
@Setter
@Data
@NoArgsConstructor
public class PageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int currPage;
    /**
     * 列表数据
     */
    private List<T> list;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }


    /**
     * 分页
     * @param page
     */
    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getSize();
        this.currPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }

    /**
     * 类型转换
     * @param page
     * @param list
     * @param <T>
     * @param <Q>
     * @return
     */
    public static<T,Q> IPage<Q> Convert(IPage<T> page, List<Q> list){
        IPage<Q> page1 = new Page<>();
        page1.setTotal(page.getTotal());
        page1.setPages(page.getPages());
        page1.setSize(page.getSize());
        page1.setCurrent(page.getCurrent());
        page1.setRecords(list);
        return page1;
    }
}