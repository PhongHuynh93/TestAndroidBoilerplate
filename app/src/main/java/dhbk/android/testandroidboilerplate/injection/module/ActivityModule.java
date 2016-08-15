package dhbk.android.testandroidboilerplate.injection.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dhbk.android.testandroidboilerplate.injection.ActivityContext;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * provide context for activity
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
