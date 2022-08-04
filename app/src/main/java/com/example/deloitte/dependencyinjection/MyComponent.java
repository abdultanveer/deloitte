package com.example.deloitte.dependencyinjection;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
//component is like my real estate agent who know where is the buyer and seller
public interface MyComponent {
    void inject(DiActivity activity);
}