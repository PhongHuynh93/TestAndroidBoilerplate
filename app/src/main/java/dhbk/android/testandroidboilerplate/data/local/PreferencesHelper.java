package dhbk.android.testandroidboilerplate.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dhbk.android.testandroidboilerplate.injection.ApplicationContext;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * declare share preference
 */
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "android_boilerplate_pref_file";

    private final SharedPreferences mPref;

//    inject pref to dagger
    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

//    remove pref
    public void clear() {
        mPref.edit().clear().apply();
    }

}
