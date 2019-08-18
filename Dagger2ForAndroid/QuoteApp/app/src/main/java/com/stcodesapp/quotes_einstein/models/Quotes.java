package com.stcodesapp.quotes_einstein.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Quotes implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private long quoteID;
    private String quoteText;

    public Quotes(String quoteText) {
        this.quoteText = quoteText;
    }

    public long getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(long quoteID) {
        this.quoteID = quoteID;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "quoteID=" + quoteID +
                ", quoteText='" + quoteText + '\'' +
                '}';
    }
}
