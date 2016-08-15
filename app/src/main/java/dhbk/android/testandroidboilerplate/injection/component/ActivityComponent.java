package dhbk.android.testandroidboilerplate.injection.component;

import dagger.Component;
import dhbk.android.testandroidboilerplate.injection.PerActivity;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * todo - make activity component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public class ActivityComponent {
}
