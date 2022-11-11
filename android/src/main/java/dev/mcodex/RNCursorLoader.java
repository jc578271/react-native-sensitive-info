package dev.mcodex;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import java.util.HashMap;

public class RNCursorLoader implements LoaderManager.LoaderCallbacks<Cursor> {
    CursorLoader cursorLoader;
    Context rnContext;
    String ContextURI;

    public HashMap<String, String> values = new HashMap<String, String>();

    public RNCursorLoader(Context _rnContext, String providerName) {
        ContextURI = "content://" + providerName + "/cte";
        rnContext = _rnContext;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        cursorLoader = new CursorLoader(rnContext, Uri.parse(ContextURI), null, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String key = cursor.getString(cursor.getColumnIndex("id"));
            String value = cursor.getString(cursor.getColumnIndex("name"));
            values.put(key, value);
            cursor.moveToNext();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
