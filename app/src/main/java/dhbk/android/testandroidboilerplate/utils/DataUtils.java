package dhbk.android.testandroidboilerplate.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by huynhducthanhphong on 8/16/16.
 *
 * contain method to progress with data
 */

public class DataUtils {
    // check to see if there are any network available
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    // set date format for JSON response
    public static Gson getGsonInstance() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSz")
                .create();
    }

}
