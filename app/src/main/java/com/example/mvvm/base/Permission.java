package com.example.mvvm.base;

import androidx.fragment.app.Fragment;

import pub.devrel.easypermissions.EasyPermissions;

public class Permission {
    public static void requestPermissions(Fragment fragment, String rationale, int requestCode, String[] perms) {
        EasyPermissions.requestPermissions(fragment, rationale, requestCode, perms);
    }
}
