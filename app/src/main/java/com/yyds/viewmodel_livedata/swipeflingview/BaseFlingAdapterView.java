package com.yyds.viewmodel_livedata.swipeflingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/10
 * Describe:
 */
public abstract class BaseFlingAdapterView extends AdapterView {

    private int heightMeasureSpec;
    private int widthMeasureSpec;

    public BaseFlingAdapterView(Context context) {
        super(context);
    }

    public BaseFlingAdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFlingAdapterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setSelection(int i) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
    }


    public int getWidthMeasureSpec() {
        return widthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return heightMeasureSpec;
    }
}
