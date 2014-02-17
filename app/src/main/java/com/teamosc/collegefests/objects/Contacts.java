package com.teamosc.collegefests.objects;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.teamosc.collegefests.R;

/**
 * Created by omerjerk on 14/2/14.
 */
public class Contacts {

    private Context context;

    private String[] contactTitles;
    private String[] contactDescs;

    public Contacts (Context context) {
        this.context = context;
        Resources mResources = this.context.getResources();
        contactTitles = mResources.getStringArray(R.array.contacts_title);
        contactDescs = mResources.getStringArray(R.array.contacts_title);
    }

    public String[] getContactTitles() {
        return contactTitles;
    }

    public String[] getContactDesc() {
        return contactDescs;
    }

    public int getLength() {
        return contactTitles.length;
    }
}
