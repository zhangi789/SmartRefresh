package com.refresh.smart.cn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.refresh.smart.cn.baseUse.RecycleviewBasicActivity;
import com.refresh.smart.cn.ui.ClassicalActivity;
import com.refresh.smart.cn.ui.MeituanActivity;
import com.refresh.smart.cn.ui.PullMoreAndRefreshActivity;
import com.refresh.smart.cn.ui.WaterDropActivity;
import com.refresh.smart.cn.ui.WaveSwipeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.m_classical)
    Button mClassical;
    @BindView(R.id.m_bezier)
    Button mBezier;

    Context mContext;
    @BindView(R.id.m_waveswip)
    Button mWaveswip;
    @BindView(R.id.m_watedrop)
    Button mWatedrop;
    @BindView(R.id.m_more)
    Button mMore;
    @BindView(R.id.m_smart_adapter)
    Button mSmartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.m_classical, R.id.m_bezier, R.id.m_waveswip, R.id.m_watedrop, R.id.m_more,R.id.m_smart_adapter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_classical:
                startActivity(new Intent(mContext, ClassicalActivity.class));
                break;
            case R.id.m_bezier:
                startActivity(new Intent(mContext, MeituanActivity.class));
                break;
            case R.id.m_waveswip:
                startActivity(new Intent(mContext, WaveSwipeActivity.class));
                break;

            case R.id.m_watedrop:
                startActivity(new Intent(mContext, WaterDropActivity.class));
                break;
            case R.id.m_more:
                //    startActivity(new Intent(mContext, WaterDropActivity.class));
            /*    TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);*/
                startActivity(new Intent(mContext, PullMoreAndRefreshActivity.class));
                break;
            case R.id.m_smart_adapter:
                //    startActivity(new Intent(mContext, WaterDropActivity.class));
            /*    TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);*/
                startActivity(new Intent(mContext, RecycleviewBasicActivity.class));
                break;


        }
    }

}
