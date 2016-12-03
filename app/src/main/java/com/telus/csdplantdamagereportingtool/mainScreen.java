package com.telus.csdplantdamagereportingtool;

/**
 * Created by yittrix on 03/12/16.
 */

public class mainScreen {
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

    }
}
