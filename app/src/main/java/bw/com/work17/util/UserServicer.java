package bw.com.work17.util;

import java.util.HashMap;
import java.util.List;

import bw.com.work17.entity.BaseBean;
import bw.com.work17.entity.ShopBean;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserServicer {
    //查询购物车
    @GET
    Observable<BaseBean<List<ShopBean>>> GetShop(@Url String Url, @QueryMap HashMap<String,String> map);

}
