package gachon.example.project;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ingredient_cycle extends RecyclerView.Adapter<ingredient_cycle.ViewHolder> {

    Context context;


    session session;

    public ingredient_cycle(){}
    public ingredient_cycle( Context context){
        this.context=context;
        session=(session)context.getApplicationContext();
    }




    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        Button selected_delete;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.selected_ingredient_img);
            name = (TextView) view.findViewById(R.id.selected_ingredient_name);
            selected_delete=(Button)view.findViewById(R.id.selected_ingredient_delete);

        }



    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredient_dialog_list, viewGroup, false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        ViewHolder myviewholder=(ViewHolder) viewHolder;

        myviewholder.img.setImageResource(session.selected_ingredients.get(position).getImg());

        myviewholder.name.setText(session.selected_ingredients.get(position).getName());

        myviewholder.selected_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.selected_ingredients.remove(position);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return session.selected_ingredients.size();
    }
}

