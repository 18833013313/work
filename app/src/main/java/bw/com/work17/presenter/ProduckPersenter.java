package bw.com.work17.presenter;

import java.util.HashMap;
import java.util.List;

import bw.com.work17.content.ProduckContent;
import bw.com.work17.entity.ShopBean;
import bw.com.work17.model.ProduckModel;
import bw.com.work17.request.RequestCallBack;

public class ProduckPersenter extends ProduckContent.IProduckPresent {
    private ProduckModel produckModel;
    private ProduckContent.IProduckView iProduckView;

    public ProduckPersenter(ProduckContent.IProduckView iProduckView) {
        this.produckModel = new ProduckModel();
        this.iProduckView = iProduckView;
    }

    @Override
    public void getList(HashMap<String, String> params) {
        produckModel.getList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {
                if (iProduckView!=null){
                    iProduckView.onFile(msg);
                }
            }

            @Override
            public void onSuccess(List<ShopBean> shopBean) {
                if (iProduckView!=null){
                    iProduckView.onSuccess(shopBean);
                }
            }


        });
    }
}
