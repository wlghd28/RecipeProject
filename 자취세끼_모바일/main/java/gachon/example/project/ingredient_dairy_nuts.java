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

public class ingredient_dairy_nuts extends AppCompatActivity {

    GridView gridView;
    Activity act=this;
    Button ingredient_selected,ingredient_result;
    GridLayoutManager mGridLayoutManager;
    RecyclerView recyclerView;

    ArrayList<ingredientitem> ingredientitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_dairy_nuts);


        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitem v1=new ingredientitem(R.drawable.d1,"아몬드");
        ingredientitem v2=new ingredientitem(R.drawable.d2,"호두");
        ingredientitem v3=new ingredientitem(R.drawable.d3,"땅콩");
        ingredientitem v4=new ingredientitem(R.drawable.d4,"은행");
        ingredientitem v5=new ingredientitem(R.drawable.d5,"잣");
        ingredientitem v6=new ingredientitem(R.drawable.d6,"대추");
        ingredientitem v7=new ingredientitem(R.drawable.d7,"밤");
        ingredientitem v8=new ingredientitem(R.drawable.d8,"우유");
        ingredientitem v9=new ingredientitem(R.drawable.d9,"플레인요구르트");
        ingredientitem v10=new ingredientitem(R.drawable.d10,"요구르트");
        ingredientitem v11=new ingredientitem(R.drawable.d11,"생크림");
        ingredientitem v12=new ingredientitem(R.drawable.d12,"연유");
        ingredientitem v13=new ingredientitem(R.drawable.d13,"체다치즈");
        ingredientitem v14=new ingredientitem(R.drawable.d14,"모짜렐라");




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
        recyclerView=(RecyclerView)findViewById(R.id.dairy_nut_gridview);
        recyclerView.setLayoutManager(mGridLayoutManager);
        ingredient_gridview adapter=new ingredient_gridview(act,ingredientitems);
        recyclerView.setAdapter(adapter);

        ingredient_selected=(Button)findViewById(R.id.ingredient_selectedlist);
        ingredient_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientDialog ingredientDialog=new IngredientDialog(ingredient_dairy_nuts.this);
                ingredientDialog.callFunction();

            }
        });
        ingredient_result=(Button)findViewById(R.id.ingredient_result);
        ingredient_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selected_ingredient_result_i=new Intent(ingredient_dairy_nuts.this,selected_ingredient_result.class);
                startActivity(selected_ingredient_result_i);
            }
        });
    }

}
