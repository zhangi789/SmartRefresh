package com.refresh.smart.cn.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.refresh.smart.cn.R;
import com.refresh.smart.cn.bean.MultipleItem;

import java.util.List;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    public MultipleItemQuickAdapter(Context context, List data) {
        super(data);
        addItemType(MultipleItem.START, R.layout.time_start);
        addItemType(MultipleItem.MIDDLE, R.layout.time_middle);
        addItemType(MultipleItem.END, R.layout.time_end);
    }
    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.START:
                helper.setText(R.id.start_content, item.getContent())
                        .setText(R.id.start_time, item.getTime()).addOnClickListener(R.id.start_content);
                break;
            case MultipleItem.MIDDLE:
                helper.setText(R.id.middle_content, item.getContent());
                helper.setText(R.id.middle_time, item.getTime());
                break;
            case MultipleItem.END:
                helper.setText(R.id.end_content, item.getContent());
                helper.setText(R.id.end_time, item.getTime());
                break;
        }
    }
}
