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

public class ingredient_sauce extends Fragment {
    Context context;
    Button ingredient_selected,ingredient_result;
    GridLayoutManager mGridLayoutManager;
    RecyclerView recyclerView;
    ArrayList<ingredientitem> ingredientitems;
    session session;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View v=inflater.inflate(R.layout.activity_ingredient_sauces, container, false);
        context=container.getContext();
       session=(session)context.getApplicationContext();
        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitems=new ArrayList<ingredientitem>();

        ingredientitem v1=new ingredientitem(R.drawable.c1,"국간장");
        ingredientitem v2=new ingredientitem(R.drawable.c2,"고추장");
        ingredientitem v3=new ingredientitem(R.drawable.c3,"된장");
        ingredientitem v4=new ingredientitem(R.drawable.c4,"양조간장");
        ingredientitem v5=new ingredientitem(R.drawable.c5,"쌈장");
        ingredientitem v6=new ingredientitem(R.drawable.c6,"맛간장");
        ingredientitem v7=new ingredientitem(R.drawable.c7,"초고추장");
        ingredientitem v8=new ingredientitem(R.drawable.c8,"참기름");
        ingredientitem v9=new ingredientitem(R.drawable.c9,"식용유");
        ingredientitem v10=new ingredientitem(R.drawable.c10,"올리브유");
        ingredientitem v11=new ingredientitem(R.drawable.c11,"케찹");
        ingredientitem v12=new ingredientitem(R.drawable.c12,"굴소스");
        ingredientitem v13=new ingredientitem(R.drawable.c13,"버터");
        ingredientitem v14=new ingredientitem(R.drawable.c14,"마요네즈");




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




        mGridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView=(RecyclerView)v.findViewById(R.id.sauce_gridview);
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
