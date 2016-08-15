package dhbk.android.testandroidboilerplate.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by huynhducthanhphong on 8/15/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
