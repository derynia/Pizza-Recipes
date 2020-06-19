package learn.android.pizza_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class RecypeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);
        String[] names = getResources().getStringArray(R.array.arr_names);

        TextView recypeTextView  = findViewById(R.id.textView);
        recypeTextView.setMovementMethod(new ScrollingMovementMethod());
        ImageView bigPizza = findViewById(R.id.imageViewBigPic);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            int idImage = getResources().getIdentifier("pizza_b" + String.format ("%02d", arguments.getInt("ID")), "drawable", getPackageName());
            bigPizza.setImageResource(idImage);

            String text = "text" + String.format ("%02d", arguments.getInt("ID")) + ".txt";
            byte[] buffer = null;
            InputStream is;
            try {
                is = getAssets().open(text);
                int size = is.available();
                buffer = new byte[size];
                is.read(buffer);
                is.close();
            } catch (IOException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }

            String str_data = new String(buffer);

            recypeTextView.setText(str_data);
        }
    }
}
