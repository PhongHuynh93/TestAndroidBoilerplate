package dhbk.android.testandroidboilerplate.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by huynhducthanhphong on 8/15/16.
 *  - Qualifier để phân biệt 2 dependence
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Remote {
}
