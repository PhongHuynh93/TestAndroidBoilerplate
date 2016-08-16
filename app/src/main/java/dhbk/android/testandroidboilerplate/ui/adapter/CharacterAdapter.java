package dhbk.android.testandroidboilerplate.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import dhbk.android.testandroidboilerplate.R;
import dhbk.android.testandroidboilerplate.ui.activity.CharacterActivity;
import dhbk.android.testandroidboilerplate.ui.activity.DetailActivity;
import dhbk.android.testandroidboilerplate.data.model.Character;

import static dhbk.android.testandroidboilerplate.ui.activity.CharacterActivity.getStartIntent;

/**
 * Created by huynhducthanhphong on 8/15/16.
 *  - declre adapter
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {
    private List<Character> mCharacters;

    //    create empty list
    @Inject
    public CharacterAdapter() {
        this.mCharacters = new ArrayList<>();
    }

    // : 8/15/16
    @Override
    public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterHolder(view);
    }

    // : 8/15/16
    @Override
    public void onBindViewHolder(CharacterHolder holder, int position) {
        final Context context = holder.itemView.getContext();

        // load info to view holder
        final Character character = mCharacters.get(position);
        holder.nameText.setText(character.name);
        int filmCount = character.films.size();
        String description = context.getString(R.string.text_films_description, filmCount);
        holder.descriptionText.setText(filmCount == 0
                ? context.getString(R.string.text_no_description) : description);
        Glide.with(context)
                .load(getImageUrl(character.name))
                .into(holder.characterImage);


        // listen event
        holder.viewText.setOnClickListener(v -> context.startActivity(getStartIntent(context, character)));

        holder.characterContainer.setOnClickListener(v -> context.startActivity(getStartIntent(context, character)));

        holder.tabText.setOnClickListener(v -> context.startActivity(DetailActivity.getStartIntent(context, character)));
    }

    /**
     * get image url from char name
     * @param name char name
     * @return image url
     */
    private String getImageUrl(String name) {
        // Ugly, but the API doesn't provide images - so this is just for example image loading
        switch (name.toLowerCase()) {
            case "luke skywalker":
                return "http://img3.wikia.nocookie.net/__cb20091030151422/starwars/" +
                        "images/d/d9/Luke-rotjpromo.jpg";
            case "c-3po":
                return "http://img2.wikia.nocookie.net/__cb20131005124036/starwars/" +
                        "images/thumb/5/51/C-3PO_EP3.png/400px-C-3PO_EP3.png";
            case "r2-d2":
                return "http://img1.wikia.nocookie.net/__cb20090524204255/starwars/" +
                        "images/thumb/1/1a/R2d2.jpg/400px-R2d2.jpg";
            case "darth vader":
                return "http://img2.wikia.nocookie.net/__cb20130621175844/starwars/" +
                        "images/thumb/6/6f/Anakin_Skywalker_RotS.png/" +
                        "400px-Anakin_Skywalker_RotS.png";
            default:
                return "http://img2.wikia.nocookie.net/__cb20130221005853/starwars/" +
                        "images/thumb/9/9d/DSI_hdapproach.png/400px-DSI_hdapproach.png";
        }
    }


    // : 8/15/16
    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    /**
     * change the data underneath and notify change
     * @param characters
     */
    public void setCharacters(List<Character> characters) {
        mCharacters = characters;
        notifyDataSetChanged();
    }

    // : 8/15/16
    public static class CharacterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_character)
        CircleImageView characterImage;
        @BindView(R.id.text_name)
        TextView nameText;
        @BindView(R.id.text_description)
        TextView descriptionText;
        @BindView(R.id.container_character)
        RelativeLayout characterContainer;
        @BindView(R.id.seperator_line)
        View mSeperatorLine;
        @BindView(R.id.text_view)
        TextView viewText;
        @BindView(R.id.text_tab)
        TextView tabText;

        public CharacterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
