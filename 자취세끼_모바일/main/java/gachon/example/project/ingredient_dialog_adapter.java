package gachon.example.project;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ingredient_dialog_adapter extends BaseAdapter {
    ImageView img;
    TextView name;
    Button selected_delete;
    Context context;
    LayoutInflater inflater;
    session session;

    ingredient_dialog_adapter(){}
    ingredient_dialog_adapter(Context context){
        this.context=context;
         session=(session)context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return session.selected_ingredients.size();
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
            convertView = inflater.inflate(R.layout.ingredient_dialog_list, parent,false);
            img = (ImageView) convertView.findViewById(R.id.selected_ingredient_img);
            name = (TextView) convertView.findViewById(R.id.selected_ingredient_name);
            selected_delete=(Button)convertView.findViewById(R.id.selected_ingredient_delete);

            img.setImageResource(session.selected_ingredients.get(position).getImg());
            name.setText(session.selected_ingredients.get(position).getName());




            selected_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    session.selected_ingredients.remove(position);
                    notifyDataSetChanged();

                }
            });

                }



        return convertView;
    }

}