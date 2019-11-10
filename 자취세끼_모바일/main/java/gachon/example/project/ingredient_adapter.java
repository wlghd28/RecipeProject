package gachon.example.project;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ingredient_adapter extends BaseAdapter {
    ImageView img;
    TextView name;
    Context context;
    LayoutInflater inflater;
    ArrayList<ingredientitem> ingredientitems;
    session session;

    ingredient_adapter(){}
    ingredient_adapter(Context context,ArrayList<ingredientitem> items){
         this.context=context;
        this.ingredientitems=items;
        session=(session)context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return ingredientitems.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ingredient_list, parent,false);
            img = (ImageView) convertView.findViewById(R.id.ingredient_img);
            name = (TextView) convertView.findViewById(R.id.ingredient_name);
               img.setImageResource(ingredientitems.get(position).getImg());
            name.setText(ingredientitems.get(position).getName());
            final selected_ingredient selected_ingredient=new selected_ingredient();
            selected_ingredient.setImg(ingredientitems.get(position).getImg());
            selected_ingredient.setName(ingredientitems.get(position).getName());


            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int flag=0;


                    session.selected_ingredients.add(selected_ingredient);
                    if( session.selected_ingredients.size()>1) {

                        for (int i = 0; i < session.selected_ingredients.size()-1; i++) {

                            if (selected_ingredient.getName().equals(session.selected_ingredients.get(i).getName())) {
                                Toast toast1= Toast.makeText(context,ingredientitems.get(position).getName()+ " 이(가) 이미 있습니다.", Toast.LENGTH_SHORT);
                                toast1.show();
                                session.selected_ingredients.remove(session.selected_ingredients.size()-1);
                                flag=1;
                                break;
                            }
                        }


                    }
                    if(flag==0){
                        Toast toast2 = Toast.makeText(context,ingredientitems.get(position).getName()+ " 이(가) 추가되었습니다.", Toast.LENGTH_SHORT);
                        toast2.show();}




                }
            });

        }



        return convertView;
    }

}
