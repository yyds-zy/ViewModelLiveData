package com.yyds.viewmodel_livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.yyds.viewmodel_livedata.bean.User;
import com.yyds.viewmodel_livedata.manager.UploadWorker;
import com.yyds.viewmodel_livedata.swipeflingview.SwipeFlingAdapterView;
import com.yyds.viewmodel_livedata.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements SwipeFlingAdapterView.onFlingListener,
        SwipeFlingAdapterView.OnItemClickListener, View.OnClickListener {

    private UserViewModel userViewModel;
    private TextView tvUserInfo;
    private Button btnGeneralUserInfo;
    private SwipeFlingAdapterView swipeView;


    int [] headerIcons = {
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,
            R.drawable.i10,
            R.drawable.i11,
            R.drawable.i12
    };

    String [] names = {"小玉","小玉","小玉","小玉","小玉","小玉"};

    String [] citys = {"北京", "上海", "广州", "深圳"};

    String [] edus = {"大专", "本科", "硕士", "博士"};

    String [] years = {"1年", "2年", "3年", "4年", "5年"};

    Random ran = new Random();

    private int cardWidth;
    private int cardHeight;
    private InnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        loadData();


        tvUserInfo = findViewById(R.id.tv_userInfo);
        btnGeneralUserInfo = findViewById(R.id.btn_general);
        userViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(UserViewModel.class);
        userViewModel.getUserListLiveData().observe(this, users -> {
             for (User user:users) {
                 tvUserInfo.setText("用户ID: = " + user.getId() + "\n" +
                         "用户名: = " + user.getUserName() + "\n" +
                         "年龄: = " + user.getAge() + "\n" +
                         "家庭住址: = " + user.getAddress() + "\n" +
                         "性别: = " + user.getSex() + "\n" +
                         "身份证号: = " + user.getPersonalNum() + "\n" +
                         "电话: = " + user.getTel());
             }
        });

        btnGeneralUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                WorkRequest uploadWorkRequest =
//                        new OneTimeWorkRequest.Builder(UploadWorker.class).build();
                PeriodicWorkRequest uploadWorkRequest = new PeriodicWorkRequest
                        .Builder(UploadWorker.class,
                        15, TimeUnit.MINUTES).build();
                WorkManager.getInstance(MainActivity.this).enqueue(uploadWorkRequest);
            }
        });
    }

    private void initView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        cardWidth = (int) (dm.widthPixels - (2 * 18 * density));
        cardHeight = (int) (dm.heightPixels - (338 * density));


        swipeView = (SwipeFlingAdapterView) findViewById(R.id.swipe_view);
        if (swipeView != null) {
            swipeView.setIsNeedSwipe(true);
            swipeView.setFlingListener(this);
            swipeView.setOnItemClickListener(this);

            adapter = new InnerAdapter();
            swipeView.setAdapter(adapter);
        }

        View v = findViewById(R.id.swipeLeft);
        if (v != null) {
            v.setOnClickListener(this);
        }
        v = findViewById(R.id.swipeRight);
        if (v != null) {
            v.setOnClickListener(this);
        }

    }


    @Override
    public void onItemClicked(MotionEvent event, View v, Object dataObject) {

    }

    @Override
    public void removeFirstObjectInAdapter() {
        adapter.remove(0);
    }

    @Override
    public void onLeftCardExit(Object dataObject) {
    }

    @Override
    public void onRightCardExit(Object dataObject) {
    }

    @Override
    public void onAdapterAboutToEmpty(int itemsInAdapter) {
        if (itemsInAdapter == 3) {
            loadData();
        }
    }

    @Override
    public void onScroll(float progress, float scrollXProgress) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.swipeLeft:
                swipeView.swipeLeft();
                //swipeView.swipeLeft(250);
                break;
            case R.id.swipeRight:
                swipeView.swipeRight();
                //swipeView.swipeRight(250);
        }
    }

    private void loadData() {
        new AsyncTask<Void, Void, List<Talent>>() {
            @Override
            protected List<Talent> doInBackground(Void... params) {
                ArrayList<Talent> list = new ArrayList<>(10);
                Talent talent;
                for (int i = 0; i < 10; i++) {
                    talent = new Talent();
                    talent.headerIcon = headerIcons[i % headerIcons.length];
                    talent.nickname = names[ran.nextInt(names.length-1)];
                    talent.cityName = citys[ran.nextInt(citys.length-1)];
                    talent.educationName = edus[ran.nextInt(edus.length-1)];
                    talent.workYearName = years[ran.nextInt(years.length-1)];
                    list.add(talent);
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Talent> list) {
                super.onPostExecute(list);
                adapter.addAll(list);
            }
        }.execute();
    }




    private class InnerAdapter extends BaseAdapter {

        ArrayList<Talent> objs;

        public InnerAdapter() {
            objs = new ArrayList<>();
        }

        public void addAll(Collection<Talent> collection) {
            if (isEmpty()) {
                objs.addAll(collection);
                notifyDataSetChanged();
            } else {
                objs.addAll(collection);
            }
        }

        public void clear() {
            objs.clear();
            notifyDataSetChanged();
        }

        public boolean isEmpty() {
            return objs.isEmpty();
        }

        public void remove(int index) {
            if (index > -1 && index < objs.size()) {
                objs.remove(index);
                notifyDataSetChanged();
            }
        }


        @Override
        public int getCount() {
            return objs.size();
        }

        @Override
        public Talent getItem(int position) {
            if(objs==null ||objs.size()==0) return null;
            return objs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // TODO: getView
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            Talent talent = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_new_item, parent, false);
                holder  = new ViewHolder();
                convertView.setTag(holder);
                convertView.getLayoutParams().width = cardWidth;
                holder.portraitView = (ImageView) convertView.findViewById(R.id.portrait);
                //holder.portraitView.getLayoutParams().width = cardWidth;
                holder.portraitView.getLayoutParams().height = cardHeight;
                holder.nameView = (TextView) convertView.findViewById(R.id.name);
                //parentView.getLayoutParams().width = cardWidth;
                //holder.jobView = (TextView) convertView.findViewById(R.id.job);
                //holder.companyView = (TextView) convertView.findViewById(R.id.company);
                holder.cityView = (TextView) convertView.findViewById(R.id.city);
                holder.eduView = (TextView) convertView.findViewById(R.id.education);
                holder.workView = (TextView) convertView.findViewById(R.id.work_year);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }


            holder.portraitView.setImageResource(talent.headerIcon);

            holder.nameView.setText(String.format("%s", talent.nickname));
            //holder.jobView.setText(talent.jobName);

            final CharSequence no = "暂无";

            holder.cityView.setHint(no);
            holder.cityView.setText(talent.cityName);
            holder.cityView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);

            holder.eduView.setHint(no);
            holder.eduView.setText(talent.educationName);
            holder.eduView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);

            holder.workView.setHint(no);
            holder.workView.setText(talent.workYearName);
            holder.workView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_work_year,0,0);


            return convertView;
        }

    }

    private static class ViewHolder {
        ImageView portraitView;
        TextView nameView;
        TextView cityView;
        TextView eduView;
        TextView workView;
        CheckedTextView collectView;
    }

    public static class Talent {
        public int headerIcon;
        public String nickname;
        public String cityName;
        public String educationName;
        public String workYearName;
    }
}