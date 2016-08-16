package dhbk.android.testandroidboilerplate.ui.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dhbk.android.testandroidboilerplate.R;
import dhbk.android.testandroidboilerplate.data.DataManager;
import dhbk.android.testandroidboilerplate.ui.adapter.CharacterAdapter;
import dhbk.android.testandroidboilerplate.utils.DataUtils;
import dhbk.android.testandroidboilerplate.utils.DialogFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;
import dhbk.android.testandroidboilerplate.data.model.Character;

public class MainActivity extends BaseActivity {
//    findviewbyid
    @BindView(R.id.recycler_characters)
    RecyclerView mCharactersRecycler;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressIndicator;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    private instance
    private CompositeSubscription mSubscriptions;

    // inject
    @Inject
    CharacterAdapter mCharacterAdapter;
    @Inject
    DataManager mDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inject
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // : 8/15/16 7 declare subscription
        // declare subscription that contain set of subcription
        mSubscriptions = new CompositeSubscription();
        //  8 declare toolbar
        setupToolbar();
        //  9 declare recylerview
        setupRecyclerView();
        //   - 10 set character to list
        loadCharacters();
    }



    // : 8/15/16 7b remember to unsubscribe
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscriptions.unsubscribe();
    }

    // : 8/15/16 8b this act contains toolbar
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // call super to handle to home button
    @CallSuper
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupRecyclerView() {
        // : 8/15/16 9b - declare recyclerview
        mCharactersRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCharactersRecycler.setAdapter(mCharacterAdapter);

        // : 8/15/16 9d - declare swipelayout
        mSwipeRefresh.setColorSchemeResources(R.color.primary);
        mSwipeRefresh.setOnRefreshListener(() -> {
//             : 8/15/16 9e - when swipe, reset data to empty, load char again
            mCharacterAdapter.setCharacters(new ArrayList<Character>());
            loadCharacters();
        });
    }


    private void loadCharacters() {
        // : 8/15/16 10a - check the network first before load datas to list
        if (DataUtils.isNetworkAvailable(this)) {
            int[] characterIds = getResources().getIntArray(R.array.characters);
            mSubscriptions.add(mDataManager.getCharacters(characterIds)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<List<Character>>() {
                        @Override
                        public void onCompleted() {

                        }

                        // : 8/15/16 10b if fail, print the log, remove progress bar, force stop refresh, create a dialog to inform to user

                        @Override
                        public void onError(Throwable error) {
                            Timber.e("There was an error retrieving the characters " + error);
                            mProgressIndicator.setVisibility(View.GONE);
                            mSwipeRefresh.setRefreshing(false);
                            DialogFactory.createSimpleErrorDialog(MainActivity.this).show();
                        }

                        // : 8/15/16 10c - update adapter
                        @Override
                        public void onNext(List<Character> characters) {
                            mProgressIndicator.setVisibility(View.GONE);
                            mSwipeRefresh.setRefreshing(false);
                            mCharacterAdapter.setCharacters(characters);
                        }
                    }));
        }
        //  10d if there is not a network, remove progressbar and swiperefresh + create a dialog
        else {
            mProgressIndicator.setVisibility(View.GONE);
            mSwipeRefresh.setRefreshing(false);
            DialogFactory.createSimpleOkErrorDialog(
                    this,
                    getString(R.string.dialog_error_title),
                    getString(R.string.dialog_error_no_connection)
            ).show();
        }
    }

}
