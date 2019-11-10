package gachon.example.project;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationSubMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class home_Activity extends AppCompatActivity {
Button ingredient_menu,recipe_menu,btnOpenDrawer,btnCloseDrawer;
    DrawerLayout drawerLayout;
   View drawerView,header;
   Toolbar toolbar;
   NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    TextView nav_text,nav_userid;
    LayoutInflater inflater;
    MenuItem menuItem;
   private String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        if(getIntent().getStringExtra("home")==null){
        final Intent loading_i=new Intent(home_Activity.this,loading.class);
        startActivity(loading_i);}
        final session session=(session)getApplicationContext();
        session.setUserid("로그인해주세요");



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View nav_header_view = navigationView.getHeaderView(0);
        nav_text= (TextView) nav_header_view.findViewById(R.id.nav_text);
        nav_userid = (TextView) nav_header_view.findViewById(R.id.nav_userid);
        MenuInflater inflater=getMenuInflater();

        if(!(((getIntent().getStringExtra("userid")))==null)){
         nav_text.setText("접속자 : ");
         nav_userid.setText(getIntent().getStringExtra("userid"));


        session.setUserid(getIntent().getStringExtra("userid"));

          navigationView.getMenu().findItem(R.id.item1).setTitle("로그아웃");
            navigationView.getMenu().findItem(R.id.item2).setTitle("회원탈퇴");
        }

        ingredient_menu=(Button)findViewById(R.id.ingredient_menu);
        recipe_menu=(Button)findViewById(R.id.recipe_menu);
        recipe_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipe_i=new Intent(home_Activity.this,recipe_Activity.class);
                recipe_i.putExtra("userid",getIntent().getStringExtra("userid"));
                startActivity(recipe_i);
            }
        });
        ingredient_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingredient_i=new Intent(home_Activity.this,ingredient_Activity.class);
                startActivity(ingredient_i);
            }

        });





        InitializeLayout();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.item1:
                        if(menuItem.getTitle().equals("로그인")){

                        Intent login_i=new Intent(home_Activity.this,MainActivity.class);
                        startActivity(login_i);}

                        else{
                            Toast.makeText(getApplicationContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
                            nav_text.setText("");
                            nav_userid.setText("로그인해주세요");
                            menuItem.setTitle("로그인");
                            session.setUserid("로그인해주세요");
                        }

                        break;
                    case R.id.item2:
                        if(menuItem.getTitle().equals("회원가입")){
                       Intent register_i=new Intent(home_Activity.this,register_Activity.class);
                       startActivity(register_i);}
                       else{
                            Intent withdrawal_i=new Intent(home_Activity.this,withdrawal.class);
                            startActivity(withdrawal_i);}

                        break;


                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });



    }

    public void InitializeLayout()
    {
        //toolBar를 통해 App Bar 생성
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //App Bar의 좌측 영영에 Drawer를 Open 하기 위한 Incon 추가
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_format_list_bulleted_black_24dp);
        getSupportActionBar().setTitle("");

        DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawLayout.addDrawerListener(actionBarDrawerToggle);
    }
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
