import React, {useMemo} from 'react';
import {StyleProp, ViewStyle, View, requireNativeComponent} from 'react-native';

interface KotlinZoomViewClientProps {
  style?: StyleProp<ViewStyle>;
}

type ZoomViewProps = {
  style?: StyleProp<ViewStyle>;
  image: string; // path to assets file with extension
};

export const KotlinZoomViewClient: React.FC<KotlinZoomViewClientProps> = (
  props,
) => {
  const {style} = props;

  // get native component lazely
  const KotlinZoomView = useMemo(() => {
    return requireNativeComponent<ZoomViewProps>('KotlinZoomView');
  }, []);

  return (
    <View style={style}>
      <KotlinZoomView
        style={{
          width: 300,
          height: 300,
        }}
        image={'rn.jpeg'} // link from assets directory
      />
    </View>
  );
};
