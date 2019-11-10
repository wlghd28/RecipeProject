package gachon.example.project;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class information_cycle extends RecyclerView.Adapter<information_cycle.ViewHolder> {
    ArrayList<recipeitem> recipeitems=new ArrayList<recipeitem>();
Context context;

    public information_cycle(){}
    public information_cycle( ArrayList<recipeitem> recipeitems){
        this.recipeitems=recipeitems;
    }




    public class ViewHolder extends  RecyclerView.ViewHolder {
     ImageView orederimage;
     TextView recipeorder;

        public ViewHolder(View view) {
            super(view);
                orederimage=(ImageView)view.findViewById(R.id.orderimage);
                recipeorder=(TextView)view.findViewById(R.id.recipeorder);


        }



    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.informationlist, viewGroup, false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

     ViewHolder myviewholder=(ViewHolder) viewHolder;
    myviewholder.recipeorder.setText(recipeitems.get(position).getOrder());
        Picasso.with(context)
                .load("http://"+context.getString(R.string.ip)+":65000"+recipeitems.get(position).getImage())
                .error(R.drawable.ic_android_black_24dp)
                .resize(120,120)
                .into(myviewholder.orederimage);

    }

    @Override
    public int getItemCount() {
        return recipeitems.size();
    }
}
