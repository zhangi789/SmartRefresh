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
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.refresh.smart.cn.R;
import com.refresh.smart.cn.adapter.BaseAdapter;
import com.refresh.smart.cn.bean.Person;
import com.refresh.smart.cn.view.CustomRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe   仿美团下拉刷新
 */


public class MeituanActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ArrayList<Person> mData = new ArrayList<>();

    private BaseAdapter adapter;
    Context mContext;
    private static boolean isFirstEnter = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meituan);
        ButterKnife.bind(this);
        mContext = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout.setEnableHeaderTranslationContent(true);
        adapter = new BaseAdapter(new BaseAdapter.BaseCallback() {
            @Override
            public void mOnItemClick(Person mItemData) {
                Toast.makeText(mContext, "别点我！烦", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adapter);
        initData();
        refreshLayout.setRefreshHeader(new CustomRefreshHeader(mContext));
        // refreshLayout.setRefreshFooter(new CustomRefreshFooter(getActivity(), "加载中…"));
        refreshLayout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
        refreshLayout.setEnableFooterFollowWhenLoadFinished(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(final @NonNull RefreshLayout refreshLayout) {
                Log.i("GGG", "onLoadMore");
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(final @NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh();
                Log.i("GGG", "onRefresh");
            }
        });

        adapter.setData(mData);


    }


    private void initData() {
        mData.add(new Person("科比", "美国职业篮球运动员司职得分后卫"));
        mData.add(new Person("乔丹", "历史上最伟大的篮球运动员"));
        mData.add(new Person("姚明", "前中国职业篮球运动员，司职中锋"));
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
