package com.refresh.smart.cn.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.refresh.smart.cn.R;
import com.refresh.smart.cn.bean.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lingling on 2017/7/26.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyHolder> {
    private List<Person> mData = new ArrayList<>();
    private BaseCallback mOnCallback;

    public interface BaseCallback {
        public void mOnItemClick(Person mItemData);
    }

    public BaseAdapter(BaseCallback mOnCallback) {
        this.mOnCallback = mOnCallback;
    }

    public void setData(List<Person> mDatas) {
        mData.clear();
        mData.addAll(mDatas);
        this.notifyDataSetChanged();
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_classic, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final Person person = mData.get(position);

        String name = person.getName();
        String describe = person.getDescribe();
        holder.tv_title.setText(name);
        holder.tv_context.setText(describe);
        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCallback.mOnItemClick(person);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_context;
        private RelativeLayout ll_click;

        public MyHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_context = (TextView) itemView.findViewById(R.id.tv_context);
            ll_click = (RelativeLayout) itemView.findViewById(R.id.ll_click);
        }
    }
}
