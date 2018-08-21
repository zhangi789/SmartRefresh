package com.refresh.smart.cn.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.refresh.smart.cn.R;
import com.refresh.smart.cn.adapter.BaseAdapter;
import com.refresh.smart.cn.bean.Person;
import com.refresh.smart.cn.util.DynamicTimeFormat;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe 经典版  下拉刷新
 */


public class ClassicalActivity extends AppCompatActivity {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ClassicsHeader mClassicsHeader;

    private ArrayList<Person> mData = new ArrayList<>();

    private BaseAdapter adapter;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classics);
        ButterKnife.bind(this);
        mContext = this;
        mClassicsHeader = (ClassicsHeader) refreshLayout.getRefreshHeader();
        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis() - delta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));
        mClassicsHeader.setSpinnerStyle(SpinnerStyle.Scale);
        mClassicsHeader.setFinishDuration(10);
        adapter = new BaseAdapter(new BaseAdapter.BaseCallback() {
            @Override
            public void mOnItemClick(Person mItemData) {
                Toast.makeText(mContext, "别点我！烦", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        refreshLayout.autoRefresh();
        mData.add(new Person("科比", "美国职业篮球运动员司职得分后卫"));
        mData.add(new Person("乔丹", "历史上最伟大的篮球运动员"));
        mData.add(new Person("姚明", "前中国职业篮球运动员，司职中锋"));
        // adapter.setData(mData);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {



                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                        adapter.setData(mData);
                    }
                },1000);



            }
        });
       /* refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();

            }
        });*/

    }


    @OnClick({R.id.toolbar, R.id.recyclerView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                finish();
                break;
            case R.id.recyclerView:
                break;
        }
    }
}
