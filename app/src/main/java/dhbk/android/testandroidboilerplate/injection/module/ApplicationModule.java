package dhbk.android.testandroidboilerplate.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dhbk.android.testandroidboilerplate.data.remote.AndroidBoilerplateService;
import dhbk.android.testandroidboilerplate.injection.ApplicationContext;

/**
 * Created by huynhducthanhphong on 8/15/16.
 *  3 - create app module
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    // context
    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    // todo declare retrofit service
    @Provides
    @Singleton
    AndroidBoilerplateService provideAndroidBoilerplateService() {
        return AndroidBoilerplateService.Factory.makeAndroidBoilerplateService(mApplication);
    }

}
