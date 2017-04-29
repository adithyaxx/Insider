package pw.adithya.insider;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class SettingsFragment extends Fragment
{
    View rootview;
    Spinner modeSpinner, speedSpinner, tempSpinner, pressureSpinner, timeSpinner, widgetSpinner;
    Typeface condensed;
    TextView modeLabel, locationLabel, speedLabel, tempLabel, pressureLabel, timeLabel, widgetLabel;
    AutoCompleteTextView location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.settings_fragment, container, false);

        return rootview;
    }
}
