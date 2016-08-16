package dhbk.android.testandroidboilerplate.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dhbk.android.testandroidboilerplate.R;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * todo - declre adapter
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder>{
    private List<Character> mCharacters;

//    create empty list
    @Inject
    public CharacterAdapter() {
        this.mCharacters = new ArrayList<>();
    }

    // TODO: 8/15/16
    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterHolder(view);
    }

    // TODO: 8/15/16
    @Override
    public void onBindViewHolder(CharacterHolder holder, int position) {

    }

    // TODO: 8/15/16
    @Override
    public int getItemCount() {
        return 0;
    }

    // TODO: 8/15/16
    public static class CharacterHolder extends RecyclerView.ViewHolder {
        public CharacterHolder(View itemView) {
            super(itemView);
        }
    }
}
