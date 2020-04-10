package com.marscode.pwn.roomappsample;

import android.app.Application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class WordRepositoryTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Application mApplication;

    @Mock
    WordDao mWordDao;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void testGetAllWords(){
        WordRepository wordRepository = new WordRepository(mWordDao,mApplication);
        MutableLiveData<List<Words>> mutableLiveData = new MutableLiveData<>();
        List<Words> wordsList = new ArrayList<>();
        wordsList.add(new Words("Alaa"));
        mutableLiveData.setValue(wordsList);

        when(mWordDao.getAlphabetizedWords()).thenReturn(mutableLiveData);

        LiveData<List<Words>> wordLiveDataList =  wordRepository.getAllWords();

        assertEquals("Alaa",wordLiveDataList.getValue().get(0).getWord());
    }
}
