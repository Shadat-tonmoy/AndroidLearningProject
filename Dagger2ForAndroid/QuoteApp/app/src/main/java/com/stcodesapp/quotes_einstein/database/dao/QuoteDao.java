package com.stcodesapp.quotes_einstein.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.stcodesapp.quotes_einstein.models.Quotes;

import java.util.List;

@Dao
public interface QuoteDao
{

    @Insert
    long[] insertQuote(Quotes... quotes);

    @Query("select * from Quotes")
    List<Quotes> getAllQuotes();

    @Query("select * from Quotes where quoteID = :id")
    Quotes getQuotesByID(long id);
}
