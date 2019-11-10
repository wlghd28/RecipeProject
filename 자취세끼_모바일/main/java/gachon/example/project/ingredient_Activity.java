package gachon.example.project;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ingredient_Activity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    Button action_home;
    FragmentManager manager;
    ArrayList<Fragment> fraglist=new ArrayList<>();
    ArrayList<String> titlelist=new ArrayList<>();
   ingredient_fruit sub4=new ingredient_fruit();
   ingredient_meat sub1=new ingredient_meat();
   ingredient_sauce sub5=new ingredient_sauce();
   ingredient_seafood sub2=new ingredient_seafood();
   ingredient_vegetable sub3=new ingredient_vegetable();
   ingredient_nut_dairy sub6=new ingredient_nut_dairy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs2);


        setCustomActionbar();
        action_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent action_home_i = new Intent(ingredient_Activity.this, home_Activity.class);
                action_home_i.putExtra("home", "home");
                startActivity(action_home_i);


            }
        });
        titlelist.add("육류");
        titlelist.add("해산물");
        titlelist.add("채소");
        titlelist.add("과일");
        titlelist.add("양념/소스류");
        titlelist.add("유제품/견과류");
        fraglist.add(sub1);
        fraglist.add(sub2);
        fraglist.add(sub3);
        fraglist.add(sub4);
        fraglist.add(sub5);
        fraglist.add(sub6);
         /*tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("육류")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("해산물")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("채소")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("과일")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("양념/소스류")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("유제품/견과류")));*/
        pager = (ViewPager) findViewById(R.id.pager2);
        manager = getSupportFragmentManager();
        pageradapter adapter = new pageradapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);


    }
  /*private View createTabView(String tabname){
        View tabView=LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_tab,null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);

        txt_name.setText(tabname);
        return tabView;
    }*/

    public void setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();

        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.


        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.

        View actionbarview = LayoutInflater.from(this).inflate(R.layout.actionbarlayout,null);
        actionBar.setCustomView(actionbarview);
        action_home=(Button)actionbarview.findViewById(R.id.home_btn);

        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbarview.getParent();
        parent.setContentInsetsAbsolute(0,0);

        ActionBar.LayoutParams params=new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(actionbarview,params);


    }
    class pageradapter extends FragmentPagerAdapter {

        public pageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fraglist.get(i);
        }

        @Override
        public int getCount() {
            return fraglist.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }

    }

}
