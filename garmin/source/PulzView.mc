using Toybox.Graphics;
using Toybox.Lang;
using Toybox.System;
using Toybox.WatchUi;

class PulzView extends WatchUi.View {
    var _state as String = Rez.Strings.Subtitle;

    function initialize() {
        View.initialize();
    }

    function onLayout(dc as Dc) as Void {
        setLayout(Rez.Layouts.MainLayout(dc));
    }

    function onShow() as Void {
    }

    function onUpdate(dc as Dc) as Void {
        dc.setColor(Graphics.COLOR_WHITE, Graphics.COLOR_BLACK);
        dc.clear();

        var width = dc.getWidth();
        dc.drawText(width / 2, 26, Graphics.FONT_XTINY, Rez.Strings.Title, Graphics.TEXT_JUSTIFY_CENTER);
        dc.drawText(width / 2, 58, Graphics.FONT_SMALL, _state, Graphics.TEXT_JUSTIFY_CENTER);
        dc.drawText(width / 2, 110, Graphics.FONT_XTINY, "UP Calm  DOWN Urge  START Pause", Graphics.TEXT_JUSTIFY_CENTER);
    }

    function onKey(key as Number, state as Number) as Boolean {
        if (state != WatchUi.KEY_PRESS) {
            return false;
        }

        if (key == WatchUi.KEY_UP) {
            _state = Rez.Strings.CalmState;
            WatchUi.requestUpdate();
            return true;
        }

        if (key == WatchUi.KEY_DOWN) {
            _state = Rez.Strings.UrgeState;
            WatchUi.requestUpdate();
            return true;
        }

        if (key == WatchUi.KEY_START || key == WatchUi.KEY_ENTER) {
            _state = Rez.Strings.PausePrompt;
            WatchUi.requestUpdate();
            return true;
        }

        return false;
    }
}
