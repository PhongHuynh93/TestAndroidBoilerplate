package dhbk.android.testandroidboilerplate.data.remote;

import android.content.Context;

import dhbk.android.testandroidboilerplate.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by huynhducthanhphong on 8/15/16.
 */
public interface AndroidBoilerplateService {
    // path
    String ENDPOINT = "http://swapi.co/api/";

    // : 8/15/16 4 declare retrofit endpoint
    @GET("people/{personId}")
    Observable<Character> getCharacter(@Path("personId") int id);

    /********
     * Factory class that sets up a new boilerplate service
     *******/
    class Factory {
        // : 8/15/16 5 declare retrofit service
        public static AndroidBoilerplateService makeAndroidBoilerplateService(Context context) {
//            create client
            OkHttpClient.Builder client = new OkHttpClient.Builder();


            // create a new HttpLoggingInterceptor and set logging level, if debug mode, print log, if not - not print
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            client.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AndroidBoilerplateService.ENDPOINT)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(AndroidBoilerplateService.class);
        }

    }
}
