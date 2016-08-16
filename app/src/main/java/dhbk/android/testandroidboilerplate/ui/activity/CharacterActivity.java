package dhbk.android.testandroidboilerplate.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import dhbk.android.testandroidboilerplate.data.model.Character;

import dhbk.android.testandroidboilerplate.R;

public class CharacterActivity extends AppCompatActivity {
    private static final String EXTRA_CHARACTER =
            "com.hitherejoe.androidboilerplate.ui.activity.CharacterActivity.EXTRA_CHARACTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    /**
     * make an intent for other view to nav to this view
     * @param context view context
     * @param character class {@link Character}
     * @return Intent
     */
    public static Intent getStartIntent(Context context, Character character) {
        Intent intent = new Intent(context, CharacterActivity.class);
        intent.putExtra(EXTRA_CHARACTER, character);
        return intent;
    }
}
