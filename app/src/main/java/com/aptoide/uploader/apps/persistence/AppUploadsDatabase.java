package com.aptoide.uploader.apps.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.aptoide.uploader.apps.AppUploadStatus;

@Database(entities = { AppUploadStatus.class }, version = 1)
public abstract class AppUploadsDatabase extends RoomDatabase {
  private static volatile AppUploadsDatabase INSTANCE;

  public static AppUploadsDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (AppUploadsDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppUploadsDatabase.class,
              "AppUploadsDatabase.db")
              .build();
        }
      }
    }
    return INSTANCE;
  }

  public abstract AppUploadStatusDao appUploadsStatusDao();
}
