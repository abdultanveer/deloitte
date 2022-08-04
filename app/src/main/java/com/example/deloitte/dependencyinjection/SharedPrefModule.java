package com.example.deloitte.dependencyinjection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

//module == provider/seller
@Module // place where all creators reside [yatish]
public class SharedPrefModule {
    private Context context;

    //constructor of this module
    public SharedPrefModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides //he creates context object
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides //creates shared prefs object
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
} 