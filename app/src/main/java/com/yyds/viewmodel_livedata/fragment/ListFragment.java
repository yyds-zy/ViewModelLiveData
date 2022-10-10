package com.yyds.viewmodel_livedata.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yyds.viewmodel_livedata.bean.User;
import com.yyds.viewmodel_livedata.viewmodel.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/9
 * Describe:
 */
public class ListFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setAge("28");
        user.setUserName("阿飞的小蝴蝶");
        user.setSex("男");
        user.setAddress("北京市昌平区天通西苑一区66号楼一单元601");
        user.setPersonalNum("410326199509037319");
        user.setTel("18513687319");
        userList.add(user);
        sharedViewModel.select(userList);
    }
}
