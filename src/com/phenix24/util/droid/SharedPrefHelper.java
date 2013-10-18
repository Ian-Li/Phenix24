package com.phenix24.util.droid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPrefHelper {

    private SharedPreferences prefs;

    /**
     * Construct a instance that points to the default file that is used by the
     * SharedPreferences framework in the given context.
     * 
     * @param context
     */
    public SharedPrefHelper(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Construct a instance that points to the preferences file 'name'.
     * 
     * @param context
     * @param name
     *            Desired preferences file
     * @param mode
     *            Operating mode.Use 0 or Context.MODE_PRIVATE for the default
     *            operation,Context.MODE_WORLD_READABLE and
     *            Context.MODE_WORLD_WRITEABLE to control permissions.The bit
     *            Context.MODE_MULTI_PROCESS can also be used if multiple
     *            processes are mutating the same SharedPreferences file.
     *            Context.MODE_MULTI_PROCESS is always on in apps targetting
     *            Gingerbread (Android 2.3) and below, and off by default in
     *            later versions.
     */
    public SharedPrefHelper(Context context, String name, int mode) {
        prefs = context.getSharedPreferences(name, mode);
    }

    /**
     * Retrieve a boolean value from the preferences.
     * 
     * @param key
     *            The name of the preference to retrieve.
     * @param def
     *            Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or def.
     */
    public boolean getBoolean(String key, boolean def) {
        return prefs.getBoolean(key, def);
    }

    /**
     * Set a boolean value in the preferences.
     * 
     * @param key
     *            The name of the preference to modify.
     * @param value
     *            The new value for the preference.
     */
    public void setBoolean(String key, boolean value) {
        Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Retrieve an int value from the preferences.
     * 
     * @param key
     *            The name of the preference to retrieve.
     * @param def
     *            Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or def.
     */
    public int getInt(String key, int def) {
        return prefs.getInt(key, def);
    }

    /**
     * Set an int value in the preferences.
     * 
     * @param key
     *            The name of the preference to modify.
     * @param value
     *            The new value for the preference.
     */
    public void setInt(String key, int value) {
        Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Retrieve a long value from the preferences.
     * 
     * @param key
     *            The name of the preference to retrieve.
     * @param def
     *            Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or def.
     */
    public long getLong(String key, long def) {
        return prefs.getLong(key, def);
    }

    /**
     * Set a long value in the preferences.
     * 
     * @param key
     *            The name of the preference to modify.
     * @param value
     *            The new value for the preference.
     */
    public void setLong(String key, long value) {
        Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Retrieve a float value from the preferences.
     * 
     * @param key
     *            The name of the preference to retrieve.
     * @param def
     *            Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or def.
     */
    public float getFloat(String key, float def) {
        return prefs.getFloat(key, def);
    }

    /**
     * Set a float value in the preferences.
     * 
     * @param key
     *            The name of the preference to modify.
     * @param value
     *            The new value for the preference.
     */
    public void setFloat(String key, float value) {
        Editor editor = prefs.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Retrieve a String value from the preferences.
     * 
     * @param key
     *            The name of the preference to retrieve.
     * @param def
     *            Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or def.
     */
    public String getString(String key, String def) {
        return prefs.getString(key, def);
    }

    /**
     * Set a String value in the preferences.
     * 
     * @param key
     *            The name of the preference to modify.
     * @param value
     *            The new value for the preference.
     */
    public void setString(String key, String value) {
        Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Remove all values from the preferences.
     */
    public void cleanAll() {
        Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }
}
