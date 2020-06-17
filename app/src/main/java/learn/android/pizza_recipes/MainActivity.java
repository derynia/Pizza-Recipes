package learn.android.pizza_recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private int maxItems = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = getResources().getStringArray(R.array.arr_names);
        String[] shortDescs = getResources().getStringArray(R.array.arr_desc_recipes);

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        for (int i = 0; i < maxItems; i++) {
            recyclerViewItems.add(new RecyclerViewItem(getResources().getIdentifier("pizza" + String.format ("%02d", i),"drawable", getPackageName())
                    , names[i], shortDescs[i]));
        };

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}