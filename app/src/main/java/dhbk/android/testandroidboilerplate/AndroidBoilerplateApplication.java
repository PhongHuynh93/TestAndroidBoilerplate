package dhbk.android.testandroidboilerplate;

import android.app.Application;
import android.content.Context;

import dhbk.android.testandroidboilerplate.injection.component.ApplicationComponent;
import dhbk.android.testandroidboilerplate.injection.component.DaggerApplicationComponent;
import dhbk.android.testandroidboilerplate.injection.module.ApplicationModule;
import lombok.Getter;
import lombok.Setter;
import timber.log.Timber;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * : 8/15/16 1 - create application
 */
public class AndroidBoilerplateApplication extends Application {
    @Getter @Setter
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    // : 8/15/16 2 - get app context
    public static AndroidBoilerplateApplication get(Context context) {
        return (AndroidBoilerplateApplication) context.getApplicationContext();
    }
}
