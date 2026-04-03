package com.pulz.wear;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String PREFS_NAME = "pulz_wear";
    private static final String KEY_LAST_CHECK_IN = "last_check_in";
    private static final String KEY_PAUSE_COUNT = "pause_count";

    private TextView statusText;
    private TextView statsText;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        statusText = findViewById(R.id.status_text);
        statsText = findViewById(R.id.stats_text);

        Button calmButton = findViewById(R.id.calm_button);
        Button urgeButton = findViewById(R.id.urge_button);
        Button pauseButton = findViewById(R.id.pause_button);

        calmButton.setOnClickListener(view -> saveCheckIn("Calm and steady"));
        urgeButton.setOnClickListener(view -> saveCheckIn("Feeling an urge"));
        pauseButton.setOnClickListener(view -> triggerPause());

        renderState();
    }

    private void saveCheckIn(String state) {
        preferences.edit().putString(KEY_LAST_CHECK_IN, state).apply();
        renderState();
    }

    private void triggerPause() {
        int pauseCount = preferences.getInt(KEY_PAUSE_COUNT, 0) + 1;
        preferences.edit()
            .putInt(KEY_PAUSE_COUNT, pauseCount)
            .putString(KEY_LAST_CHECK_IN, "Take 3 slow breaths")
            .apply();
        renderState();
    }

    private void renderState() {
        String lastCheckIn = preferences.getString(KEY_LAST_CHECK_IN, "Ready for a quick check-in");
        int pauseCount = preferences.getInt(KEY_PAUSE_COUNT, 0);

        statusText.setText(lastCheckIn);
        statsText.setText(getString(R.string.pause_count_template, pauseCount));
    }
}
