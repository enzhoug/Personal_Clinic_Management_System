package com.pojo.administrator;

import java.util.List;
//设置好泛型将来可以传入不同的T类型达到通用的效果
public class pagemention<T> {
    private int totalpage;
    private List<T> pagelist;

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getPagelist() {
        return pagelist;
    }

    public void setPagelist(List<T> pagelist) {
        this.pagelist = pagelist;
    }
}
