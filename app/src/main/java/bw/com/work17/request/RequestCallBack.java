package bw.com.work17.request;

import java.util.List;

import bw.com.work17.entity.ShopBean;

public interface RequestCallBack {
    void onFile(String msg);
    void onSuccess(List<ShopBean> shopBean);
}
