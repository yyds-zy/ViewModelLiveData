package com.yyds.viewmodel_livedata.manager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.yyds.log.util.LogUtils;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/10
 * Describe:
 */
public class UploadWorker extends Worker {

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        uploadImages();
        return Result.success();
    }

    private void uploadImages() {
        LogUtils.v("阿飞の小蝴蝶  你来了");
    }
}
