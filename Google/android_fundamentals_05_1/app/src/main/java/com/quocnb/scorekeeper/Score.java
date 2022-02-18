package com.quocnb.scorekeeper;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.ObservableInt;

public class Score implements Parcelable {
    public final ObservableInt firstScore = new ObservableInt();
    public final ObservableInt secondScore = new ObservableInt();

    public Score(int first, int second) {
        this.firstScore.set(first);
        this.secondScore.set(second);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(firstScore.get());
        parcel.writeInt(secondScore.get());
    }
}
