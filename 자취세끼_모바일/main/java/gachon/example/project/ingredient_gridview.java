package gachon.example.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ingredient_gridview extends  RecyclerView.Adapter<ingredient_gridview.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<ingredientitem> ingredientitems;
    session session;

    public ingredient_gridview(){}
    public ingredient_gridview( Context context,ArrayList<ingredientitem> items){
        this.context=context;
        this.ingredientitems=items;
        session=(session)context.getApplicationContext();
    }




    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.ingredient_img);
            name = (TextView) view.findViewById(R.id.ingredient_name);


        }



    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredient_list, viewGroup, false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        ViewHolder myviewholder=(ViewHolder) viewHolder;

        myviewholder.img.setImageResource(ingredientitems.get(position).getImg());
        myviewholder.name.setText(ingredientitems.get(position).getName());
        final selected_ingredient selected_ingredient=new selected_ingredient();
        selected_ingredient.setImg(ingredientitems.get(position).getImg());
        selected_ingredient.setName(ingredientitems.get(position).getName());
        myviewholder.img.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public int getItemCount() {
        return ingredientitems.size();
    }
}
