package com.yyds.viewmodel_livedata.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yyds.viewmodel_livedata.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 阿飞の小蝴蝶 on 2022/10/9
 * Describe:
 */
public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> mUserListLiveData;

    public MutableLiveData<List<User>> getUserListLiveData(){
        if (mUserListLiveData == null) {
            mUserListLiveData = new MutableLiveData<>();
            loadUsers();
        }
        return mUserListLiveData;
    }

    /**
     * 异步请求数据
     */
    private void loadUsers() {
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
        mUserListLiveData.postValue(userList);
    }
}
