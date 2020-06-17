package learn.android.pizza_recipes;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {
    private ArrayList<RecyclerViewItem> arrayList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPizzaPic;
        public TextView textViewPizzaName;
        public TextView textViewPizzaDesc;
        private CardView cardView;

        public RecyclerViewViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageViewPizzaPic = itemView.findViewById(R.id.imageViewPizzaPic);
            textViewPizzaName = itemView.findViewById(R.id.textViewPizzaName);
            textViewPizzaDesc = itemView.findViewById(R.id.textViewPizzaDesc);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder= new RecyclerViewViewHolder(view);

        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, final int position) {
        RecyclerViewItem recyclerViewItem = arrayList.get(position);

        holder.imageViewPizzaPic.setImageResource(recyclerViewItem.getImageResource());
        holder.textViewPizzaName.setText(recyclerViewItem.getTextName());
        holder.textViewPizzaDesc.setText(recyclerViewItem.getTextDesc());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
