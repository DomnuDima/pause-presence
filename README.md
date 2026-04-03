# PULZ

React + Vite app with Capacitor Android support.

## Targets in this repo

- `android/app`: Android phone wrapper for the web app.
- `android/wear`: native Wear OS starter app for Android watches.
- `garmin`: Garmin Connect IQ starter app for Garmin watches.

## Run on Android Studio emulator

1. Create `.env.local` from `.env.example` and fill in the required values.
2. Install dependencies with `npm install`.
3. Build the web app with `npm run build`.
4. Sync the native project with `npm run cap:sync`.
5. Open Android Studio with `npm run android`.
6. In Android Studio, wait for Gradle sync, choose an emulator, and run the `app` configuration.

## Daily update flow

After web code changes:

1. Run `npm run build`.
2. Run `npm run cap:sync`.
3. Re-run the app from Android Studio.

## Notes

- The Android project lives in `android/` after you generate it.
- This app requires valid Clerk and Supabase environment variables before it can boot.
- Clerk redirect auth may require adding Capacitor/mobile redirect origins in your Clerk dashboard for emulator testing.
- The watch targets are native scaffolds, not webviews. They are designed as a clean starting point for dedicated watch UX.

## Wear OS

1. Open `android/` in Android Studio.
2. Wait for Gradle sync to finish.
3. Choose the `wear` run target.
4. Start a Wear OS emulator and run the module.

The Wear OS app is currently a native offline flow for quick pause actions and check-ins. It does not yet reuse Clerk auth from the web app because that flow is not watch-friendly.

## Garmin

1. Install the Garmin Connect IQ SDK and Eclipse plugin or use Monkey C tooling.
2. Open the `garmin/` folder as a Connect IQ project.
3. Build and run it in a Garmin simulator.

The Garmin app is also a native starter implementation. It focuses on a simple on-watch pause/check-in experience and is intentionally separate from the Android project.
