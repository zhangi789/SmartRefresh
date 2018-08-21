package com.refresh.smart.cn.baseUse;

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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.refresh.smart.cn.R;
import com.refresh.smart.cn.adapter.MultipleItemQuickAdapter;
import com.refresh.smart.cn.bean.MultipleItem;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe
 */


public class RecycleviewBasicActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    Context mContext;

    private List<MultipleItem> mImem = new ArrayList<>();
    private List<MultipleItem> mImem2 = new ArrayList<>();
    private MultipleItemQuickAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mutl);
        ButterKnife.bind(this);
        mContext = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initData();
        //refreshLayout.autoLoadMore();
    }

    private void initData() {
        mImem.add(new MultipleItem(1, 23, "快件已从杭州中转部发出", "2017-05-15 10:59:04"));
        mImem.add(new MultipleItem(2, 56, "快件已到上海", "2017-05-16 11:59:04"));
        mImem.add(new MultipleItem(2, 43, "快件已从上海中转部花园", "2017-05-17 10:59:04"));
        mImem.add(new MultipleItem(3, 18, "快件送到", "2017-05-19 12:59:04"));
        adapter = new MultipleItemQuickAdapter(mContext, mImem);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, "儿子", Toast.LENGTH_LONG).show();
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, mImem.get(position).getContent(), Toast.LENGTH_LONG).show();
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mImem2.add(new MultipleItem(1, 23, "快件已从杭州中转部发出", "2017-05-15 10:59:04"));
                mImem2.add(new MultipleItem(2, 48, "快件添加", "2017-05-16 11:59:04"));
                mImem2.add(new MultipleItem(2, 43, "快件异常", "2017-05-17 10:59:04"));

                mImem2.add(new MultipleItem(2, 56, "快件已到上海", "2017-05-16 11:59:04"));
                mImem2.add(new MultipleItem(2, 43, "快件已从上海中转部花园", "2017-05-17 10:59:04"));
                mImem2.add(new MultipleItem(3, 18, "快件送到", "2017-05-19 12:59:04"));
                adapter.replaceData(mImem2);
                refreshLayout.finishRefresh();
            }
        });
    }

    @OnClick({R.id.toolbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                finish();
                break;
        }
    }
}
