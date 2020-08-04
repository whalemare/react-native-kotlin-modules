import React, {useMemo} from 'react';
import {
  StyleProp,
  ViewStyle,
  View,
  requireNativeComponent,
  Text,
} from 'react-native';

interface NativeModulesClientProps {
  style?: StyleProp<ViewStyle>;
}

type NativeTextViewProps = {
  text: string;
};

const KotlinTextView = requireNativeComponent<NativeTextViewProps>(
  'KotlinTextView',
);
const KotlinZoomView = requireNativeComponent<{image: string}>('ZoomView');

export const NativeModulesClient: React.FC<NativeModulesClientProps> = (
  props,
) => {
  const {style} = props;

  // const JavaTextView = useMemo(() => {
  //   return requireNativeComponent<NativeTextViewProps>('JavaTextView');
  // }, []);
  // const KotlinTextView = useMemo(() => {
  //   return requireNativeComponent<NativeTextViewProps>('KotlinTextView');
  // }, []);

  return (
    <View style={style}>
      {/* <JavaTextView text={'This is Java Text View'} /> */}
      <Text>
        Step 2: look, that KotlinTextView renders correctly (it is use build it
        android views)
      </Text>
      <KotlinTextView
        style={{
          width: 300,
          height: 30,
        }}
        text={'This is Kotlin Text View'}
      />

      <Text>
        Step 3: Press for open KotlinZoomView that uses third-party android
        dependency
      </Text>
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
