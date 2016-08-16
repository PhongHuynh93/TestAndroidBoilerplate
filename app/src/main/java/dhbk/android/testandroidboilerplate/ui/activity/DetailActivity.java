package dhbk.android.testandroidboilerplate.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import dhbk.android.testandroidboilerplate.data.model.Character;
import dhbk.android.testandroidboilerplate.R;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_CHARACTER =
            "com.hitherejoe.androidboilerplate.ui.activity.DetailActivity.EXTRA_CHARACTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public static Intent getStartIntent(Context context, Character character) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_CHARACTER, character);
        return intent;
    }

}
