package com.stcodesapp.quotes_einstein.database;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.stcodesapp.quotes_einstein.constants.Constants;
import com.stcodesapp.quotes_einstein.database.dao.QuoteDao;
import com.stcodesapp.quotes_einstein.models.Quotes;

@Database(entities = {Quotes.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public static volatile AppDatabase database;

    public abstract QuoteDao quoteDao();


    public static AppDatabase getInstance(Activity activity)
    {
        synchronized (AppDatabase.class)
        {
            if(database == null)
                database = Room.databaseBuilder(activity, AppDatabase.class, Constants.APP_DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            return database;
        }

    }




}
