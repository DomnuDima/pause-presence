using Toybox.Application;
using Toybox.WatchUi;

class PulzApp extends Application.AppBase {

    function initialize() {
        AppBase.initialize();
    }

    function getInitialView() {
        return [ new PulzView() ];
    }
}
