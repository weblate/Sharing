package com.ammar.filescenter.custom.ui;

import static com.ammar.filescenter.activities.MainActivity.MainActivity.darkMode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ammar.filescenter.R;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class AdaptiveTextView extends androidx.appcompat.widget.AppCompatTextView {

    public static final LinkedList<WeakReference<AdaptiveTextView>> textViews = new LinkedList<>();

    private void addTextView() {
        AdaptiveTextView.textViews.addLast(new WeakReference<>(this));
        setTextColor( darkMode ? darkModeColor : lightModeColor );
    }

    public AdaptiveTextView(@NonNull Context context) {
        super(context);
        darkModeColor = Color.rgb(220, 220, 220);
        lightModeColor = Color.rgb(1, 1, 1);
        addTextView();

    }

    public AdaptiveTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
        addTextView();

    }

    public AdaptiveTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        addTextView();
    }


    int darkModeColor;
    int lightModeColor;
    private void init(@Nullable AttributeSet attrs) {
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.AdaptiveTextView);
        darkModeColor = arr.getColor(R.styleable.AdaptiveTextView_darkModeColor, Color.rgb(220, 220, 220));
        lightModeColor = arr.getColor(R.styleable.AdaptiveTextView_lightModeColor, Color.rgb(1, 1, 1));
        arr.recycle();
    }

    public void setDark(boolean dark) {
        setTextColor( dark ? darkModeColor : lightModeColor );

        // for now we're only interested in the drawableStart
        Drawable drawable = getCompoundDrawablesRelative()[0];
        if( drawable != null ) {
            drawable.mutate()
                    .setTint(dark ? darkModeColor : lightModeColor);
        }
    }
}