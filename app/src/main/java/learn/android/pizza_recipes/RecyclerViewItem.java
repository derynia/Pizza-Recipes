package learn.android.pizza_recipes;

import java.io.Serializable;

public class RecyclerViewItem  implements Serializable  {
    private int imageResource;
    private String textName;
    private String textDesc;

    public RecyclerViewItem(int imageResource, String textName, String textDesc) {
        this.imageResource = imageResource;
        this.textName = textName;
        this.textDesc = textDesc;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTextName() {
        return textName;
    }

    public String getTextDesc() {
        return textDesc;
    }

}
