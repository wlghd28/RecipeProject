package gachon.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ingredient_vegetable extends Fragment {
    Context context;
    Button ingredient_selected,ingredient_result;
    GridLayoutManager mGridLayoutManager;
    RecyclerView recyclerView;
    ArrayList<ingredientitem> ingredientitems;
    session session;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View v=inflater.inflate(R.layout.activity_ingredient_vegetables, container, false);
        context=container.getContext();
        session=(session)context.getApplicationContext();
        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitem v1=new ingredientitem(R.drawable.v1,"대파");
        ingredientitem v2=new ingredientitem(R.drawable.v2,"양배추");
        ingredientitem v3=new ingredientitem(R.drawable.v3,"브로콜리");
        ingredientitem v4=new ingredientitem(R.drawable.v4,"시금치");
        ingredientitem v5=new ingredientitem(R.drawable.v5,"깻잎");
        ingredientitem v6=new ingredientitem(R.drawable.v6,"부추");
        ingredientitem v7=new ingredientitem(R.drawable.v7,"배추");
        ingredientitem v8=new ingredientitem(R.drawable.v8,"애호박");
        ingredientitem v9=new ingredientitem(R.drawable.v9,"청양고추");
        ingredientitem v10=new ingredientitem(R.drawable.v10,"오이");
        ingredientitem v11=new ingredientitem(R.drawable.v11,"피망");
        ingredientitem v12=new ingredientitem(R.drawable.v12,"가지");
        ingredientitem v13=new ingredientitem(R.drawable.v13,"옥수수");
        ingredientitem v14=new ingredientitem(R.drawable.v14,"양파");
        ingredientitem v15=new ingredientitem(R.drawable.v15,"무");
        ingredientitem v16=new ingredientitem(R.drawable.v16,"감자");
        ingredientitem v17=new ingredientitem(R.drawable.v17,"당근");
        ingredientitem v18=new ingredientitem(R.drawable.v18,"마늘");

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
        ingredientitems.add(v15);
        ingredientitems.add(v16);
        ingredientitems.add(v17);
        ingredientitems.add(v18);




        mGridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView=(RecyclerView)v.findViewById(R.id.vegetable_gridview);
        recyclerView.setLayoutManager(mGridLayoutManager);
        ingredient_gridview adapter=new ingredient_gridview(context,ingredientitems);
        recyclerView.setAdapter(adapter);

        ingredient_selected=(Button)v.findViewById(R.id.ingredient_selectedlist);
        ingredient_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientDialog ingredientDialog=new IngredientDialog(context);
                ingredientDialog.callFunction();

            }
        });
        ingredient_result=(Button)v.findViewById(R.id.ingredient_result);
        ingredient_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(session.selected_ingredients.size()==0){
                    Toast toast = Toast.makeText(context, "선택한 재료가 없습니다 ", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else{

                    Intent selected_ingredient_result_i=new Intent(context,selected_ingredient_result.class);
                    startActivity(selected_ingredient_result_i);}
            }

        });






        return v;
    }
}

