package library;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by yuzhaoxin on 2017/12/17.
 */

public class Tools extends Activity {
    private Tools() {
    }

    private static Tools tools = null;

    public static Tools getTools() {
        if (tools == null) {
            tools = new Tools();
        }
        return tools;
    }

    /**
     * Get location use GPS.
     * @return The first element is latitude, the second is longitude.
     * @return If no GPS permission, return null.
     */
    private double[] getLocation() {
        String serviceString = Context.LOCATION_SERVICE;
        LocationManager locationManager = (LocationManager) this.getSystemService(serviceString);
        String provider = LocationManager.GPS_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        return new double[]{latitude,longitude};
    }
}
