package bw.com.work17.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import bw.com.work17.R;
import bw.com.work17.fragment.Fragment_dd;
import bw.com.work17.fragment.Fragment_kong;
import bw.com.work17.fragment.Fragment_shop;

public class FirstActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    page.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    page.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    page.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    private ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        page = findViewById(R.id.pager);
        page.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 1:
                        return new Fragment_shop();
                    case 2:
                        return new Fragment_dd();
                    default:
                        return new Fragment_kong();
                }

            }

            @Override
            public int getCount() {
                return 3;
            }
        });

    }

}
