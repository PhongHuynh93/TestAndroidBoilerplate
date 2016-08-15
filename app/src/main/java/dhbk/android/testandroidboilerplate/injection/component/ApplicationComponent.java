package dhbk.android.testandroidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dhbk.android.testandroidboilerplate.AndroidBoilerplateApplication;
import dhbk.android.testandroidboilerplate.injection.ApplicationContext;
import dhbk.android.testandroidboilerplate.injection.module.ApplicationModule;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * // : 8/15/16 2 create component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // add this to application
    void inject(AndroidBoilerplateApplication androidBoilerplateApplication);

    @ApplicationContext
    Context context();

    Application application();

    // create retrofit service
//    AndroidBoilerplateService androidBoilerplateService();
//    PreferencesHelper preferencesHelper();
//    DataManager dataManager();
}
