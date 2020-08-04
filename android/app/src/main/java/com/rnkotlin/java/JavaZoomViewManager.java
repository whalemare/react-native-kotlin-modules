package com.rnkotlin.java;

import android.view.View;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * @author Anton Vlasov - whalemare
 * @since 2020
 */
class JavaZoomViewManager extends SimpleViewManager<SubsamplingScaleImageView> {

    @NotNull
    @Override
    public String getName() {
        return "JavaZoomView";
    }

    @NotNull
    @Override
    protected SubsamplingScaleImageView createViewInstance(@NotNull ThemedReactContext reactContext) {
        SubsamplingScaleImageView view = new SubsamplingScaleImageView(reactContext);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(), "onPress", null);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(view.getId(), "onLongPress", null);
                return true;
            }
        });

        return view;
    }


    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
            "onPress", MapBuilder.of(
                "registrationName", "onPress"
            ),
            "onLongPress", MapBuilder.of(
                "registrationName", "onLongPress"
            )
        );
    }

    @ReactProp(name = "image")
    public void setImage(SubsamplingScaleImageView view, String uri) {
        if (uri == null || uri.isEmpty()) {
            throw new IllegalArgumentException("Expected not null and not empty image path, but received: $uri");
        } else {
            view.setImage(ImageSource.asset(uri));
        }
    }
}
