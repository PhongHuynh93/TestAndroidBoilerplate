package dhbk.android.testandroidboilerplate.injection.component;

import dagger.Component;
import dhbk.android.testandroidboilerplate.injection.PerActivity;
import dhbk.android.testandroidboilerplate.injection.module.ActivityModule;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * todo - make activity subcomponent
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public class ActivityComponent {
}
