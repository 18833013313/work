package bw.com.work17.util;

import bw.com.work17.api.ProduckApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitUtil {
    private static RetroFitUtil instanct;
    private final Retrofit retrofit;

    public RetroFitUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ProduckApi.BaseApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public UserServicer setRetrofit(){
        return retrofit.create(UserServicer.class);
    }
    public static RetroFitUtil getInstanct() {
        if (instanct == null){
            synchronized (RetroFitUtil.class){
                if (instanct == null){
                    instanct = new RetroFitUtil();
                }
            }
        }
        return instanct;
    }
}
