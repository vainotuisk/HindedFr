package com.example.hindedfr;

import android.preference.DialogPreference;
import android.widget.NumberPicker;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.content.res.TypedArray;


/**
 * Created by vaino on 20/01/15.
 */
public class Numbrivalija extends DialogPreference{
    private int Minute = 0;
    private NumberPicker np= null;

    public static int getMinute(String time) {
        String[] pieces = time.split(":");

        return (Integer.parseInt(pieces[1]));
    }

    public Numbrivalija(Context context, AttributeSet attrs) {
        super(context, attrs);

        setPositiveButtonText("Set");
        setNegativeButtonText("Cancel");
    }

    @Override
    protected View onCreateDialogView() {
        np = new NumberPicker(getContext());

        return (np);
    }

    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);

        np.setMaxValue(100);
        np.setValue(Minute);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {

            Minute = np.getValue();

            String time = 0 + ":" + String.valueOf(Minute);

            if (callChangeListener(time)) {
                persistString(time);
            }
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return (a.getString(index));
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        String time = null;

        if (restoreValue) {
            if (defaultValue == null) {
                time = getPersistedString("08:00");
            } else {
                time = getPersistedString(defaultValue.toString());
            }
        } else {
            time = defaultValue.toString();
        }

        Minute = getMinute(time);
    }
    
    
}
