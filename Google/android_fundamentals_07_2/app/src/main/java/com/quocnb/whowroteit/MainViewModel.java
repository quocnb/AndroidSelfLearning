package com.quocnb.whowroteit;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

public class MainViewModel extends BaseObservable {
    public ObservableField<String> keyword = new ObservableField<>("");
}
