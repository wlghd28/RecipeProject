package gachon.example.project;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class recipe_Activity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    ArrayList<Fragment> fraglist=new ArrayList<>();
    ArrayList<String> titlelist=new ArrayList<>();
    Button action_home;
    FragmentManager manager;
   category sub1 = new category();
    category2 sub2 = new category2();
   category3 sub3 = new category3();
    category4 sub4 = new category4();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);



        fraglist.add(sub1);
        fraglist.add(sub2);
        fraglist.add(sub3);
        fraglist.add(sub4);
        titlelist.add("카테고리별");
        titlelist.add("난이도별");
        titlelist.add("즐겨찾기");
        titlelist.add("레시피 게시판");
        /*tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("카테고리별")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("난이도별")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("즐겨찾기")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("레시피 게시판")));*/
        tabLayout.addTab(tabLayout.newTab().setText("카테고리별"));
        tabLayout.addTab(tabLayout.newTab().setText("난이도별"));
        tabLayout.addTab(tabLayout.newTab().setText("즐겨찾기별"));
        tabLayout.addTab(tabLayout.newTab().setText("레시피게시판"));
        /*pager = (ViewPager) findViewById(R.id.pager);*/
        manager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, sub1).commit();
        /*pageradapter adapter = new pageradapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);*/


       setCustomActionbar();
        action_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent action_home_i = new Intent(recipe_Activity.this, home_Activity.class);
                action_home_i.putExtra("home", "home");
                startActivity(action_home_i);


            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); //탭 버튼의 index 참조

                Fragment selected = null;

                /* 선택된 탭에 따라 화면에 보이는 프래그먼트 변경 */
                switch(position){
                    case 0:
                        selected = sub1;
                        break;
                    case 1:
                        selected = sub2;
                        break;
                    case 2:
                        selected = sub3;
                        break;
                    case 3:
                        selected = sub4;
                        break;
                    default:
                        break;
                }
                recipe_Activity.this.getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });






    }



      /*     private View createTabView(String tabname){
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



   /* class pageradapter extends FragmentPagerAdapter {

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

    }*/




}

