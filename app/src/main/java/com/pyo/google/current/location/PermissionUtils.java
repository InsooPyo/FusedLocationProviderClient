package com.pyo.google.current.location;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by pyoinsoo on 2017-10-28.
 */

public final class PermissionUtils{
    /**
     * Runtime Permission Check
     */
    public static void requestPermission(AppCompatActivity activity, int requestID,
                                         String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestID);
    }

    /**
     * 위치 권한이 부여되어 있는지 알아내는 공통 메소드
     */
    public static boolean isPermissionGranted(String[] grantPermissions, int[] grantResults,
                                              String permission) {
        int permissionSize = grantPermissions.length;
        for (int i = 0; i < permissionSize; i++) {
            if (permission.equals(grantPermissions[i])) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }
    /**
     * 퍼미션에 대한 다이얼로그 확장
     */
    public static class PermissionDialog extends DialogFragment{
        /**
         * 이 대화 상자의 새 인스턴스를 만들고 '확인'버튼을 클릭하면 호출 활동을 선택적으로 진행.
         */
        public static PermissionDialog newInstance() {
            PermissionDialog dialog = new PermissionDialog();
            return dialog;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            return new AlertDialog.Builder(getActivity())
                    .setMessage("단말기 위치설정이 필요합니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }).create();
        }
    }
}
