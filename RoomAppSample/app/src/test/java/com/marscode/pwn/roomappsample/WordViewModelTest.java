package com.marscode.pwn.roomappsample;


import android.app.Application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class WordViewModelTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Application mApplication;


    @Mock
    private WordRepository mWordRepository;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void testGetAllWords(){
        MutableLiveData<List<Words>> words = new MutableLiveData<List<Words>>() ;
        List<Words> wordsList = new ArrayList<Words>();
        wordsList.add(new Words("MAI"));
        words.setValue(wordsList);

        WordViewModel wordViewModel = new WordViewModel(mWordRepository,mApplication);

        when(mWordRepository.getAllWords()).thenReturn(words);
        LiveData<List<Words>> modelAllWords = wordViewModel.getAllWords();
        assertEquals("MAI",modelAllWords.getValue().get(0).getWord());

    }
}
