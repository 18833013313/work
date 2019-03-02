package bw.com.work17.content;

import java.util.HashMap;
import java.util.List;

import bw.com.work17.entity.ShopBean;
import bw.com.work17.request.RequestCallBack;

public interface ProduckContent {
    public abstract class IProduckPresent{
        protected abstract void getList(HashMap<String, String> params);
    }
    interface IProduckModel{
        void getList(HashMap<String,String> map, RequestCallBack requestCallBack);
    }
    interface IProduckView{
       void onFile(String msg);
       void onSuccess(List<ShopBean> shopBean);
    }
}
