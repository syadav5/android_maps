package com.tutorials.gmaps.app.googlemapstutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Utilities {
    public static void navigateTo(Context ctx, Class newClass){
        Intent intent = new Intent(ctx,newClass);
        ctx.startActivity(intent);
    }
}
