//package com.qanatdev.arithmetiquest.di
//
//import android.app.Application
//import com.qanatdev.arithmetiquest.presentation.MainActivity
//import dagger.BindsInstance
//import dagger.Component
//
//@ApplicationScope
//@Component(modules = [DataModule::class])
//interface ApplicationComponent {
//
//    fun inject(mainActivity: MainActivity)
//
//
////    @Component.Factory
////    interface ComponentFactory {
////        fun create(
////            @BindsInstance application: Application
////        ): ApplicationComponent
////    }
//    @Component.Factory
//    interface ComponentFactory{
//        fun create(
//            @BindsInstance application: Application
//        ): ApplicationComponent
//    }
//}