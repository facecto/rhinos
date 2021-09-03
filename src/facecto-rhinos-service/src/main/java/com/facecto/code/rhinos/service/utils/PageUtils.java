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

    private int totalCount;

    private int pageSize;

    private int totalPage;

    private int currPage;

    private List<T> list;

    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getSize();
        this.currPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }

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