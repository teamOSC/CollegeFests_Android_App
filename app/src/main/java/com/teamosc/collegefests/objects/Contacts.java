package com.teamosc.collegefests.objects;

import android.content.Context;
import android.content.res.Resources;

import com.teamosc.collegefests.R;

/**
 * Created by omerjerk on 14/2/14.
 */
public class Contacts {

    private Context context;

    private String[] contacts;

    public Contacts (Context context) {
        this.context = context;
        Resources mResources = this.context.getResources();
        contacts = mResources.getStringArray(R.array.contacts);
    }

    public String[] getContacts() {
        return contacts;
    }
}
