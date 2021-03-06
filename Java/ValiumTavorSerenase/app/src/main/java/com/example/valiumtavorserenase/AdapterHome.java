package com.example.valiumtavorserenase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    Context context;
    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public AdapterHome(Context ctx, List<String> titles, List<Integer> images){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context , GamesActivity.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(context , AppActivity.class);
                            context.startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(context , ImpostazioniActivity.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(context , RubricaTelefonoActivity.class);
                            context.startActivity(intent);
                            break;
                    }
                }
            });
        }
    }

}
