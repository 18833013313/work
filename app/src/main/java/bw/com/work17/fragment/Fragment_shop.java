package bw.com.work17.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import bw.com.work17.adapter.ShopAdapter;
import bw.com.work17.content.ProduckContent;
import bw.com.work17.entity.ShopBean;
import bw.com.work17.presenter.ProduckPersenter;


public class Fragment_shop extends Fragment implements ProduckContent.IProduckView {

    private RecyclerView rlv;
    private CheckBox check;
    private Button jiesuan;
    private ShopAdapter shopAdapter;
    private List<ShopBean> list1;
    double p = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        initView(view);
        initData();
        EventBus.getDefault().register(this);
        return view;
    }
    @Subscribe
    private void getId(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }
    private void inPlus() {
        for (ShopBean result : list1) {
            if (result.isCheck){
                p+=result.price;
            }
        }
    }

    private void initData() {
        list1 = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        map.put("labelId","1002");
        map.put("page","1");
        map.put("count","8");
        ProduckPersenter produckPersenter = new ProduckPersenter(this);
        produckPersenter.getList(map);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    for (int i = 0;i<list1.size();i++) {

                        list1.get(i).isCheck=true;
                       Toast.makeText(getActivity(),list1.size()+"",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    for (int i = 0;i<list1.size();i++) {
                        //
                        list1.get(i).isCheck=false;
                      //  Toast.makeText(getActivity(),list1.get(i).isCheck+"",Toast.LENGTH_SHORT).show();
                    }
                }
                shopAdapter.notifyDataSetChanged();
                inPlus();
                check.setText(p+"");
                p = 0;
            }
        });
    }

    private void initView(View view) {
        check = view.findViewById(R.id.check);
        jiesuan = view.findViewById(R.id.jiesuan);
        rlv = view.findViewById(R.id.rlv);
    }

    @Override
    public void onFile(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<ShopBean> shopBean) {
        list1 = shopBean;
        //   Toast.makeText(getContext(),shopBean.result.size()+"",Toast.LENGTH_SHORT).show();
        shopAdapter = new ShopAdapter(getActivity(),shopBean);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlv.setAdapter(shopAdapter);
    }


}
