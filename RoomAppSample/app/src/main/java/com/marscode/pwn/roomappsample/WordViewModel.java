package com.marscode.pwn.roomappsample;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    public WordViewModel (WordRepository wordRepository,Application application) {
        super(application);
        mRepository = wordRepository;
    }

    LiveData<List<Words>> getAllWords() { return mRepository.getAllWords(); }

    public void insert(Words word) { mRepository.insert(word); }
}