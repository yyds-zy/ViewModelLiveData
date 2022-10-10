package com.yyds.viewmodel_livedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yyds.viewmodel_livedata.bean.User;

import java.util.List;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/9
 * Describe:
 */
public class SharedViewModel extends ViewModel {

    private final MutableLiveData<List<User>> selected = new MutableLiveData<List<User>>();

    public void select(List<User> users) {
        selected.setValue(users);
    }

    public MutableLiveData<List<User>> getSelected() {
        return selected;
    }
}
