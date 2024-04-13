package com.dji.ux.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import dji.ux.widget.FPVOverlayWidget;
import dji.ux.widget.FPVWidget;

public class CustomizedWidgetsActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final static String TAG = "CustomizedWidgetsActivity";
    private FPVWidget fpvWidget;
    private FPVOverlayWidget fpvOverlayWidget;
    private FPVWidget secondaryFpvWidget;
    private boolean isOriginalSize = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_widgets);
        initView();

    }

    private void initView() {
        fpvWidget = (FPVWidget)findViewById(R.id.fpv_custom_widget);
        fpvOverlayWidget = (FPVOverlayWidget) findViewById(R.id.fpv_overlay_widget);
        secondaryFpvWidget = (FPVWidget)findViewById(R.id.secondary_fpv_custom_widget);
        ((CheckBox) findViewById(R.id.checkbox_primary_camera_name)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_secondary_camera_name)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_primary_camera_side)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_secondary_camera_side)).setOnCheckedChangeListener(this);
        //((CheckBox) findViewById(R.id.checkbox_primary_overexposure_warning)).setOnCheckedChangeListener(this);
        //((CheckBox) findViewById(R.id.checkbox_secondary_overexposure_warning)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_touch_focus)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_touch_metering)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_gimbal_control)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_display_grid)).setOnCheckedChangeListener(this);
        //((CheckBox) findViewById(R.id.checkbox_display_center_point)).setOnCheckedChangeListener(this);

        findViewById(R.id.primary_video_feed).setOnClickListener(this);
        findViewById(R.id.secondary_video_feed).setOnClickListener(this);
        findViewById(R.id.auto_video_feed).setOnClickListener(this);
        findViewById(R.id.change_size).setOnClickListener(this);
        findViewById(R.id.grid_type_none).setOnClickListener(this);
        findViewById(R.id.grid_type_parallel).setOnClickListener(this);
        findViewById(R.id.grid_type_parallel_diagonal).setOnClickListener(this);
        /*findViewById(R.id.center_point_none).setOnClickListener(this);
        findViewById(R.id.center_point_standard).setOnClickListener(this);
        findViewById(R.id.center_point_cross).setOnClickListener(this);
        findViewById(R.id.center_point_narrow_cross).setOnClickListener(this);
        findViewById(R.id.center_point_frame).setOnClickListener(this);
        findViewById(R.id.center_point_frame_and_cross).setOnClickListener(this);
        findViewById(R.id.center_point_square).setOnClickListener(this);
        findViewById(R.id.center_point_square_and_cross).setOnClickListener(this);
        findViewById(R.id.center_point_color).setOnClickListener(this);*/
    }


    // On click event for button
    public void resizeView() {

        ViewGroup.LayoutParams params = fpvWidget.getLayoutParams();
        if (!isOriginalSize)
        {
            params.height = 2 * fpvWidget.getHeight();
            params.width = 2 * fpvWidget.getWidth();
        } else {
            params.height = fpvWidget.getHeight()/2;
            params.width = fpvWidget.getWidth()/2;
        }
        isOriginalSize = !isOriginalSize;
        fpvWidget.setLayoutParams(params);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.primary_video_feed) {
            fpvWidget.setVideoSource(FPVWidget.VideoSource.PRIMARY);
            //fpvOverlayWidget.setOverlayVideoSource(FPVWidget.VideoSource.PRIMARY);
            secondaryFpvWidget.setVideoSource(FPVWidget.VideoSource.SECONDARY);
        } else if (id == R.id.secondary_video_feed) {
            fpvWidget.setVideoSource(FPVWidget.VideoSource.SECONDARY);
            //fpvOverlayWidget.setOverlayVideoSource(FPVWidget.VideoSource.SECONDARY);
            secondaryFpvWidget.setVideoSource(FPVWidget.VideoSource.PRIMARY);
        } else if (id == R.id.auto_video_feed) {
            fpvWidget.setVideoSource(FPVWidget.VideoSource.AUTO);
        } else if (id == R.id.change_size) {
            resizeView();
        } else if (id == R.id.grid_type_none) {
            fpvOverlayWidget.setCurrentGridOverlayType(FPVOverlayWidget.GridOverlayType.NONE);
        } else if (id == R.id.grid_type_parallel) {
            fpvOverlayWidget.setCurrentGridOverlayType(FPVOverlayWidget.GridOverlayType.PARALLEL);
        } else if (id == R.id.grid_type_parallel_diagonal) {
            fpvOverlayWidget.setCurrentGridOverlayType(FPVOverlayWidget.GridOverlayType.PARALLEL_DIAGONAL);
                /*case R.id.center_point_none:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.NONE);
                break;
            case R.id.center_point_standard:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.STANDARD);
                break;
            case R.id.center_point_cross:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.CROSS);
                break;
            case R.id.center_point_narrow_cross:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.NARROW_CROSS);
                break;
            case R.id.center_point_frame:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.FRAME);
                break;
            case R.id.center_point_frame_and_cross:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.FRAME_AND_CROSS);
                break;
            case R.id.center_point_square:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.SQUARE);
                break;
            case R.id.center_point_square_and_cross:
                fpvOverlayWidget.setCenterPointType(FPVOverlayWidget.CenterPointType.SQUARE_AND_CROSS);
                break;
            case R.id.center_point_color:
                setRandomCenterPointColor();
                break;*/
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        if (id == R.id.checkbox_primary_camera_name) {
            fpvWidget.setSourceCameraNameVisibility(isChecked);
        } else if (id == R.id.checkbox_secondary_camera_name) {
            secondaryFpvWidget.setSourceCameraNameVisibility(isChecked);
        } else if (id == R.id.checkbox_primary_camera_side) {
            fpvWidget.setSourceCameraSideVisibility(isChecked);
        } else if (id == R.id.checkbox_secondary_camera_side) {
            secondaryFpvWidget.setSourceCameraSideVisibility(isChecked);
                /*case R.id.checkbox_primary_overexposure_warning:
                fpvWidget.setOverexposureWarningEnabled(isChecked);
                break;
            case R.id.checkbox_secondary_overexposure_warning:
                secondaryFpvWidget.setOverexposureWarningEnabled(isChecked);
                break;*/
        } else if (id == R.id.checkbox_touch_focus) {
            fpvOverlayWidget.setTouchFocusEnabled(isChecked);
        } else if (id == R.id.checkbox_touch_metering) {
            fpvOverlayWidget.setSpotMeteringEnabled(isChecked);
        } else if (id == R.id.checkbox_gimbal_control) {
            fpvOverlayWidget.setGimbalControlEnabled(isChecked);
        } else if (id == R.id.checkbox_display_grid) {
            fpvOverlayWidget.setGridOverlayEnabled(isChecked);
            //case R.id.checkbox_display_center_point:
            //fpvOverlayWidget.setCenterPointEnabled(isChecked);
            //break;
        }

    }

    /*private void setRandomCenterPointColor() {
        Random rnd = new Random();
        @ColorInt int randomColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        fpvOverlayWidget.setCenterPointColor(randomColor);
    }*/
}
