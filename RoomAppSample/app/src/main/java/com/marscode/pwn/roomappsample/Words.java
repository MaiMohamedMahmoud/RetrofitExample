package com.marscode.pwn.roomappsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Words {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;


    public Words(@NonNull String word) {
        mWord = word;
    }

    public void setWord(@NonNull String word) {
        mWord = word;
    }

    public String getWord(){return this.mWord;}
}
