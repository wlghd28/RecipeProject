package gachon.example.project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class ingredient_meats extends AppCompatActivity {
    GridView gridView;
    Activity act=this;
    Button ingredient_selected,ingredient_result;
    GridLayoutManager mGridLayoutManager;
    RecyclerView recyclerView;

    ArrayList<ingredientitem> ingredientitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_meats);


        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitem v1=new ingredientitem(R.drawable.m1,"소고기");
        ingredientitem v2=new ingredientitem(R.drawable.m2,"차돌박이");
        ingredientitem v3=new ingredientitem(R.drawable.m3,"안심");
        ingredientitem v4=new ingredientitem(R.drawable.m4,"등심");
        ingredientitem v5=new ingredientitem(R.drawable.m5,"사골");
        ingredientitem v6=new ingredientitem(R.drawable.m6,"돼지고기");
        ingredientitem v7=new ingredientitem(R.drawable.m7,"삼겹살");
        ingredientitem v8=new ingredientitem(R.drawable.m8,"수육");
        ingredientitem v9=new ingredientitem(R.drawable.m9,"돼지껍데기");
        ingredientitem v10=new ingredientitem(R.drawable.m10,"목심");
        ingredientitem v11=new ingredientitem(R.drawable.m11,"닭고기");
        ingredientitem v12=new ingredientitem(R.drawable.m12,"삼계탕용닭");
        ingredientitem v13=new ingredientitem(R.drawable.m13,"계란");
        ingredientitem v14=new ingredientitem(R.drawable.m14,"훈제오리");



        ingredientitems.add(v1);
        ingredientitems.add(v2);
        ingredientitems.add(v3);
        ingredientitems.add(v4);
        ingredientitems.add(v5);
        ingredientitems.add(v6);
        ingredientitems.add(v7);
        ingredientitems.add(v8);
        ingredientitems.add(v9);
        ingredientitems.add(v10);
        ingredientitems.add(v11);
        ingredientitems.add(v12);
        ingredientitems.add(v13);
        ingredientitems.add(v14);



        mGridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView=(RecyclerView)findViewById(R.id.meat_gridview);
        recyclerView.setLayoutManager(mGridLayoutManager);
        ingredient_gridview adapter=new ingredient_gridview(act,ingredientitems);
        recyclerView.setAdapter(adapter);

        ingredient_selected=(Button)findViewById(R.id.ingredient_selectedlist);
        ingredient_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientDialog ingredientDialog=new IngredientDialog(ingredient_meats.this);
                ingredientDialog.callFunction();

            }
        });
        ingredient_result=(Button)findViewById(R.id.ingredient_result);
        ingredient_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selected_ingredient_result_i=new Intent(ingredient_meats.this,selected_ingredient_result.class);
                startActivity(selected_ingredient_result_i);
            }
        });
    }

}
