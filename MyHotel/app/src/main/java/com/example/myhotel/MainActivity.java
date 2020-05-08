package com.example.myhotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myhotel.fragemnt.Huiyuan;
import com.example.myhotel.fragemnt.My;
import com.example.myhotel.fragemnt.Shouye;

public class MainActivity extends AppCompatActivity {

    private LinearLayout huiyuanTab;
    private LinearLayout shouyeTab;
    private LinearLayout myTab;
    private ImageView shouyeIv;
    private ImageView huiyuanIv;
    private ImageView myIv;
    private TextView shouyeTv;
    private TextView myTv;
    private TextView huiyuanTv;

    private FragmentManager fragmentManager;
    private Huiyuan huiyuanFragment;
    private Shouye shouyeFragment;
    private My myFragment;

    private Fragment currentFragment=new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
        fragmentManager=getSupportFragmentManager();
        shouyeFragment=new Shouye();
        huiyuanFragment=new Huiyuan();
        myFragment=new My();

        showFragment(shouyeFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment != currentFragment){
            //隐藏正在显示的Fragment
            transaction.hide(currentFragment);
            //添加将要显示的Fragment
            if (!fragment.isAdded()) {
                transaction.add(R.id.tabContent, fragment);
            }
            //显示
            transaction.show(fragment);
            //提交事务
            transaction.commit();
            //切换当前选中的Fragment
            currentFragment = fragment;
        }
    }


    private void findViews() {
        shouyeTab=findViewById(R.id.tab1);
        huiyuanTab=findViewById(R.id.tab2);
        myTab=findViewById(R.id.tab3);

        shouyeIv=findViewById(R.id.img1);
        huiyuanIv=findViewById(R.id.img2);
        myIv=findViewById(R.id.img3);

        shouyeTv=findViewById(R.id.tv_title1);
        huiyuanTv=findViewById(R.id.tv_title2);
        myTv=findViewById(R.id.tv_title3);
    }

    private void setListeners() {
        MyClickListener myClickListener = new MyClickListener();

        shouyeTab.setOnClickListener(myClickListener);
        myTab.setOnClickListener(myClickListener);
        huiyuanTab.setOnClickListener(myClickListener);

    }
    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tab1:
                    //显示Fragment
                    showFragment(shouyeFragment);
                    break;
                case R.id.tab2:
                    showFragment(huiyuanFragment);
                    break;
                case R.id.tab3:
                    showFragment(myFragment);
                    break;
            }
        }

    }
}
