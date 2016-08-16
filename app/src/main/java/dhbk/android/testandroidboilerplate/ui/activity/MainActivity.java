package dhbk.android.testandroidboilerplate.ui.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dhbk.android.testandroidboilerplate.R;
import dhbk.android.testandroidboilerplate.ui.adapter.CharacterAdapter;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_characters)
    RecyclerView mCharactersRecycler;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressIndicator;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private CompositeSubscription mSubscriptions;
    @Inject
    CharacterAdapter mCharacterAdapter;

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
        //  todo - 10 set character to list
//        loadCharacters();
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
            // TODO: 8/15/16 9e - when swipe, reset data to empty, load char again
//            mCharacterAdapter.setCharacters(new ArrayList<Character>());
//            loadCharacters();
        });
    }
}
