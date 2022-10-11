package com.yyds.viewmodel_livedata.snowview;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/11
 * Describe:
 */
public class ColorUtil {
    /**
     * 生成随机颜色
     *
     * @return
     */
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(200);
        int green = random.nextInt(200);
        int blue = random.nextInt(200);
        return Color.rgb(red, green, blue);
    }

    /**
     * 生成随机透明度的白色
     * @return
     */
    public static int randomWhiteColor() {
        Random random = new Random();
        int a = random.nextInt(200);

        return Color.argb(a, 255, 255,255);
    }

    public static int randomRedColor() {
        Random random = new Random();
        int a = random.nextInt(200);

        return Color.argb(a, 255, 0,0);
    }
}
