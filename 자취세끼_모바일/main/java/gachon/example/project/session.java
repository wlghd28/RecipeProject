package gachon.example.project;

import android.app.Application;
import android.se.omapi.Session;

import java.util.ArrayList;

public class session extends Application {
    private String userid;
    ArrayList<selected_ingredient> selected_ingredients=new ArrayList<>();

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


}
