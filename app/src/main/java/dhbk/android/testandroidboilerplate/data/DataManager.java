package dhbk.android.testandroidboilerplate.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dhbk.android.testandroidboilerplate.data.local.PreferencesHelper;
import dhbk.android.testandroidboilerplate.data.remote.AndroidBoilerplateService;
import dhbk.android.testandroidboilerplate.injection.Local;
import dhbk.android.testandroidboilerplate.injection.Remote;
import lombok.Getter;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * a class to handle reposition (local and remote) and communicate with presenter
 */
public class DataManager {
    private final AndroidBoilerplateService mAndroidBoilerplateService;
    @Getter
    private final PreferencesHelper mPreferencesHelper;

    // // FIXME: 8/15/16 should put this in interface other than class
    @Inject
    public DataManager(@Local AndroidBoilerplateService watchTowerService,
                       @Remote PreferencesHelper preferencesHelper) {
        mAndroidBoilerplateService = watchTowerService;
        mPreferencesHelper = preferencesHelper;
    }

    public Observable<List<Character>> getCharacters(int[] ids) {
        // translate arrray to arraylist
        List<Integer> characterIds = new ArrayList<>(ids.length);
        for (int id : ids) {
            characterIds.add(id);
        }

        // TODO: 8/15/16 understand this
        return Observable.from(characterIds).concatMap(new Func1<Integer, Observable<Character>>() {
            @Override
            public Observable<Character> call(Integer integer) {
                return mAndroidBoilerplateService.getCharacter(integer);
            }
        }).toList();
    }
}
