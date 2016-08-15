package dhbk.android.testandroidboilerplate.ui.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import dhbk.android.testandroidboilerplate.AndroidBoilerplateApplication;
import dhbk.android.testandroidboilerplate.injection.component.ActivityComponent;
import dhbk.android.testandroidboilerplate.injection.component.ApplicationComponent;
import dhbk.android.testandroidboilerplate.injection.component.DaggerActivityComponent;
import dhbk.android.testandroidboilerplate.injection.module.ActivityModule;

/**
 * Created by huynhducthanhphong on 8/15/16.
 */
public class BaseActivity  extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    // get the module for activity
    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }

    protected ApplicationComponent getApplicationComponent() {
        return AndroidBoilerplateApplication.get(this).getMApplicationComponent();
    }

    // listen when click an home icon in toolbar, if child override it, call super
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /**
         *  You should return true if you process the menu item and return super.onOptionsItemSelected(item) if you don't.
         * boolean Return false to allow normal menu processing to proceed, true to consume it here.
         */
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                // check if the backstack not empty, pop all the fragment
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } // if not have fragment, destroy activity
                else {
                    finish();
                }
                return true;
            // in default, return super method
            default:
                return super.onOptionsItemSelected(item);
        }    }


}
