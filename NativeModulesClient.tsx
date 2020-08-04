import {KotlinZoomViewClient} from './KotlinZoomViewClient';
import React, {useState} from 'react';
import {
  Button,
  requireNativeComponent,
  StyleProp,
  Text,
  View,
  ViewStyle,
} from 'react-native';

interface NativeModulesClientProps {
  style?: StyleProp<ViewStyle>;
}

type NativeTextViewProps = {
  text: string;
  style?: StyleProp<ViewStyle>;
};

const KotlinTextView = requireNativeComponent<NativeTextViewProps>(
  'KotlinTextView',
);

// const JavaZoomView = requireNativeComponent<ZoomViewProps>('JavaZoomView');

export const NativeModulesClient: React.FC<NativeModulesClientProps> = (
  props,
) => {
  const {style} = props;

  const [isVisible, setVisible] = useState(false);

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
        Step 3: Look at JavaZoomView that uses third-party android dependency
        and sure, that it renders correctly
      </Text>
      {/* <JavaZoomView
        style={{
          width: 300,
          height: 300,
        }}
        image={'rn.jpeg'} // link from assets directory
      /> */}

      <Text>
        Step 4: Without debugger, press for show KotlinZoomView and sure that it
        crashed at runtime
      </Text>
      <Text>
        Step 5: Attach debugger via dev menu, press for show KotlinZoomView and
        sure that it render correctly
      </Text>
      <Button
        title={isVisible ? 'Hide KotlinZoomView' : 'Show KotlinZoomView'}
        onPress={() => setVisible(!isVisible)}
      />
      {isVisible && <KotlinZoomViewClient />}
    </View>
  );
};
