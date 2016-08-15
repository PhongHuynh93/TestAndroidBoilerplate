package dhbk.android.testandroidboilerplate.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huynhducthanhphong on 8/15/16.
 * create character model depend on JSON
 */
public class Character implements Parcelable {
    @SerializedName("hair_color")
    public String hairColor;
    @SerializedName("skin_color")
    public String skinColor;
    @SerializedName("eye_color")
    public String eyeColor;
    @SerializedName("birth_year")
    public String birthYear;


    public String name;
    public String height;
    public String mass;
    public String gender;
    public String homeworld;
    public List<String> films;
    public List<String> species;
    public List<String> vehicles;
    public List<String> starships;

    protected Character(Parcel in) {
        hairColor = in.readString();
        skinColor = in.readString();
        eyeColor = in.readString();
        birthYear = in.readString();
        name = in.readString();
        height = in.readString();
        mass = in.readString();
        gender = in.readString();
        homeworld = in.readString();
        films = in.createStringArrayList();
        species = in.createStringArrayList();
        vehicles = in.createStringArrayList();
        starships = in.createStringArrayList();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hairColor);
        parcel.writeString(skinColor);
        parcel.writeString(eyeColor);
        parcel.writeString(birthYear);
        parcel.writeString(name);
        parcel.writeString(height);
        parcel.writeString(mass);
        parcel.writeString(gender);
        parcel.writeString(homeworld);
        parcel.writeStringList(films);
        parcel.writeStringList(species);
        parcel.writeStringList(vehicles);
        parcel.writeStringList(starships);
    }
}
