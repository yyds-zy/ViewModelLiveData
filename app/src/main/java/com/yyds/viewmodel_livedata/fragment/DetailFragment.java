package com.yyds.viewmodel_livedata.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yyds.viewmodel_livedata.bean.User;
import com.yyds.viewmodel_livedata.viewmodel.SharedViewModel;

import java.util.List;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/9
 * Describe:
 */
public class DetailFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user:users) {
                    Log.d("DetailFragment","用户ID: = " + user.getId() + "\n" +
                            "用户名: = " + user.getUserName() + "\n" +
                            "年龄: = " + user.getAge() + "\n" +
                            "家庭住址: = " + user.getAddress() + "\n" +
                            "性别: = " + user.getSex() + "\n" +
                            "身份证号: = " + user.getPersonalNum() + "\n" +
                            "电话: = " + user.getTel());
                }
            }
        });
    }
}
