package dhbk.android.testandroidboilerplate.injection.component;

import dagger.Component;
import dhbk.android.testandroidboilerplate.injection.PerActivity;
import dhbk.android.testandroidboilerplate.injection.module.ActivityModule;
import dhbk.android.testandroidboilerplate.ui.activity.MainActivity;

/**
 * Created by huynhducthanhphong on 8/15/16.
 *  - make activity subcomponent
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
//    void inject(LauncherActivity launcherActivity);
    void inject(MainActivity mainActivity);
//    todo declare addition activity
//    void inject(CharacterActivity characterActivity);
//    void inject(DetailActivity detailActivity);
//    void inject(DetailFragment detailFragment);
}
