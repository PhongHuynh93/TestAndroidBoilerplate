package dhbk.android.testandroidboilerplate.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dhbk.android.testandroidboilerplate.data.local.PreferencesHelper;
import dhbk.android.testandroidboilerplate.data.model.Character;
import dhbk.android.testandroidboilerplate.data.remote.AndroidBoilerplateService;
import dhbk.android.testandroidboilerplate.injection.Local;
import dhbk.android.testandroidboilerplate.injection.Remote;
import lombok.Getter;
import rx.Observable;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * a class to handle reposition (local and remote) and communicate with presenter
 */
public class DataManager {
    private final AndroidBoilerplateService mAndroidBoilerplateService;
    @Getter
    private final PreferencesHelper mPreferencesHelper;

    // // : 8/15/16 should put this in interface other than class
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

        // : 8/15/16 understand this
        /**
         * @see <a href="http://fernandocejas.com/2015/01/11/rxjava-observable-tranformation-concatmap-vs-flatmap/">Giong va khac giữa flatmap và concat map</a>
         *
         * concatmap quan tâm thứ tự
         *
         * hàm này sẽ phát ra từng cái interger sau đo lấy character tương tứng với từng interger nó, sau đó gom lại thành 1 list Character
         */
        return Observable.from(characterIds).concatMap(mAndroidBoilerplateService::getCharacter).toList();
    }
}
