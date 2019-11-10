package gachon.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationSubMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class category4 extends Fragment {
    NavigationView navigationView;
    String userid;
    Button bulletin_btn;
    ArrayList<categoryitem> categories=new ArrayList<categoryitem>();
    ListView list4;
    FloatingActionButton fab;
    RecyclerView recyclerView;

         Context context;
    public category4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            session session=(session)getActivity().getApplication();
            userid=session.getUserid();
            System.out.println("사용자아이디"+userid);

            View v4 = inflater.inflate(R.layout.category4, container, false);
            bulletin_btn=(Button)v4.findViewById(R.id.bulletin_btn);
            final FloatingActionButton floatingActionButton = (FloatingActionButton) v4.findViewById(R.id.fab);
            recyclerView = v4.findViewById(R.id.categorylist4);
            RecyclerView.LayoutManager layoutManager;
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getContext());


            recyclerView.setLayoutManager(layoutManager);

            recipe_cycle adapter = new recipe_cycle();
            recyclerView.setAdapter(adapter);
            fab = (FloatingActionButton) v4.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reciperegisterpage_i = new Intent(getContext(), reciperegisterpage.class);
                    startActivity(reciperegisterpage_i);
                }
            });
      bulletin_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(userid.equals("로그인해주세요")) {
                  CustomDialog customDialog=new CustomDialog(getContext());
                  customDialog.callFunction();

              }else{
                  System.out.println("서버연결 시도...");
                  new JSONTask().execute("http://"+getString(R.string.ip)+":65000/userrecipe/myrecipe");
              }
          }
      });
       bulletin_btn.performClick();

            return v4;
        }

    class JSONTask extends AsyncTask<String, String, String> {
        @Override
        public String doInBackground(String... urls) {

            HttpURLConnection con = null;
            BufferedReader reader = null;
            try {

                URL url = new URL(urls[0]);
                System.out.println(url);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                //서버로 보내기위해서 스트림 만듬
                InputStream stream = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) buffer.append(line);
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                con.disconnect();
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("넘어온데이터 :" + s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                System.out.println(jsonArray);
                //System.out.println(jsonArray.length());
                int count=0;
                categories.clear();
                JSONObject object;
                while (count<jsonArray.length()){
                    object=jsonArray.getJSONObject(count);
                    //System.out.println(object);
                    categoryitem categoryitem=new categoryitem();
                    categoryitem.setMenuname(object.getString("menuname"));
                    categoryitem.setDifficulty(object.getString("difficulty"));
                    categoryitem.setImage(object.getString("image"));
                    categoryitem.setMenunumber(object.getString("menunum"));
                    categoryitem.setRecipenum(object.getString("recipenum"));
                    categoryitem.setUploader(object.getString("uploaduser"));
                    categories.add(categoryitem);
                    count++;
                }
                recipe_cycle adapter = new recipe_cycle(categories);
                recyclerView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }}

