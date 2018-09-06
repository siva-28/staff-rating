package com.example.abinash.student.juniors;

import android.content.Context;
import android.content.SharedPreferences;

public class check {
   final static String Filename="Myfile";
    public static String readset(Context ctx,String setname,String defaultValue)
    {
            SharedPreferences preferences = ctx.getSharedPreferences(Filename, Context.MODE_PRIVATE);
            return preferences.getString(setname,defaultValue);

        }
        public static void save(Context ctx,String setname,String defaultValue)
        {
            SharedPreferences preferences = ctx.getSharedPreferences(Filename, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(setname,defaultValue);
            editor.apply();
        }
        public static void sharesave(Context cxt,String user)
        {
            SharedPreferences preferences = cxt.getSharedPreferences("details",0);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("username",user);
            editor.commit();
        }


}
