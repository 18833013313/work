package bw.com.work17.model;

import java.util.HashMap;
import java.util.List;

import bw.com.work17.api.ProduckApi;
import bw.com.work17.content.ProduckContent;
import bw.com.work17.entity.BaseBean;
import bw.com.work17.entity.ShopBean;
import bw.com.work17.request.RequestCallBack;
import bw.com.work17.util.RetroFitUtil;
import bw.com.work17.util.UserServicer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProduckModel implements ProduckContent.IProduckModel {
    @Override
    public void getList(HashMap<String, String> map, final RequestCallBack requestCallBack) {
        UserServicer userServicer = RetroFitUtil.getInstanct().setRetrofit();
        userServicer.GetShop(ProduckApi.ShopApi, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<List<ShopBean>>>() {
            @Override
            public void accept(BaseBean<List<ShopBean>> listBaseBean) throws Exception {
                List<ShopBean> relsut = listBaseBean.result;
                requestCallBack.onSuccess(relsut);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                requestCallBack.onFile("请求失败");
            }
        });
     /*   Call<ShopBean> shopBeanCall = userServicer.GetShop(ProduckApi.ShopApi, map);

        shopBeanCall.enqueue(new Callback<ShopBean>() {
            @Override
            public void onResponse(Call<ShopBean> call, Response<ShopBean> response) {
                ShopBean body = response.body();
                requestCallBack.onSuccess(body);
            }

            @Override
            public void onFailure(Call<ShopBean> call, Throwable t) {
                requestCallBack.onFile("请求失败");
            }
        });*/
    }
}
