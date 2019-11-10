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

public class ingredient_seafoods extends AppCompatActivity {

    GridView gridView;
    Activity act=this;
    Button ingredient_selected,ingredient_result;
    GridLayoutManager mGridLayoutManager;
    RecyclerView recyclerView;

    ArrayList<ingredientitem> ingredientitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_seafoods);


        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitem v1=new ingredientitem(R.drawable.s1,"고등어");
        ingredientitem v2=new ingredientitem(R.drawable.s2,"오징어");
        ingredientitem v3=new ingredientitem(R.drawable.s3,"연어");
        ingredientitem v4=new ingredientitem(R.drawable.s4,"꽁치");
        ingredientitem v5=new ingredientitem(R.drawable.s5,"동태");
        ingredientitem v6=new ingredientitem(R.drawable.s6,"문어");
        ingredientitem v7=new ingredientitem(R.drawable.s7,"새우");
        ingredientitem v8=new ingredientitem(R.drawable.s8,"조개");
        ingredientitem v9=new ingredientitem(R.drawable.s9,"바지락");
        ingredientitem v10=new ingredientitem(R.drawable.s10,"굴");
        ingredientitem v11=new ingredientitem(R.drawable.s11,"홍합");
        ingredientitem v12=new ingredientitem(R.drawable.s12,"전복");
        ingredientitem v13=new ingredientitem(R.drawable.s13,"골뱅이");
        ingredientitem v14=new ingredientitem(R.drawable.s14,"김");
        ingredientitem v15=new ingredientitem(R.drawable.s15,"미역");
        ingredientitem v16=new ingredientitem(R.drawable.s16,"다시마");
        ingredientitem v17=new ingredientitem(R.drawable.s17,"톳");




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
        ingredientitems.add(v11);;
        ingredientitems.add(v12);
        ingredientitems.add(v13);
        ingredientitems.add(v14);
        ingredientitems.add(v15);
        ingredientitems.add(v16);
        ingredientitems.add(v17);


        mGridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView=(RecyclerView)findViewById(R.id.seafood_gridview);
        recyclerView.setLayoutManager(mGridLayoutManager);
        ingredient_gridview adapter=new ingredient_gridview(act,ingredientitems);
        recyclerView.setAdapter(adapter);

        ingredient_selected=(Button)findViewById(R.id.ingredient_selectedlist);
        ingredient_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientDialog ingredientDialog=new IngredientDialog(ingredient_seafoods.this);
                ingredientDialog.callFunction();

            }
        });
        ingredient_result=(Button)findViewById(R.id.ingredient_result);
        ingredient_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selected_ingredient_result_i=new Intent(ingredient_seafoods.this,selected_ingredient_result.class);
                startActivity(selected_ingredient_result_i);
            }
        });
    }

}
