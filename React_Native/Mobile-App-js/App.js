//Packages
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

//Screens
import MainScreen from './app/screens/MainScreen';
import WelcomeScreen from './app/screens/initial/WelcomeScreen';
import SignUpScreen from './app/screens/initial/SignUpScreen';
import LoginOrSignUpScreen from './app/screens/initial/LoginOrSignUpScreen';
import LanguageScreen from './app/screens/initial/LanguageScreen';
import OTPScreen from './app/screens/initial/OTPScreen';
// import { useFonts } from 'expo-font';
// import { useCallback } from 'react';


export default function App() {
  // const [fontsLoaded, fontError] = useFonts({
  //   'American-Typewriter-Regular': require('./app/assets/fonts/American-Typewriter-Regular.ttf'),
  // });

  // const onLayoutRootView = useCallback(async () => {
  //   if (fontsLoaded || fontError) {
  //     await SplashScreen.hideAsync();
  //   }
  // }, [fontsLoaded, fontError]);

  // if (!fontsLoaded && !fontError) {
  //   return null;
  // }

  
  
  const Stack = createNativeStackNavigator()

  function isSignedIn() {
    return false;
  }
  if (isSignedIn()) {
    return(
      <MainScreen/>
    );
  }
  else {
    return(
      //screenOptions={{headerShown: false}}
      <NavigationContainer>
        <Stack.Navigator   screenOptions={{headerTitle:'', headerBackTitleVisible:true}} initialRouteName="Language">
          <Stack.Screen name="Language" component={LanguageScreen} />
          <Stack.Screen name="Welcome" component={WelcomeScreen} />
          <Stack.Screen name="Login Or Sign Up" component={LoginOrSignUpScreen} />
          <Stack.Screen name="Sign Up" component={SignUpScreen} />
          <Stack.Screen name="OTP" component={OTPScreen} />
          <Stack.Screen name="Main" 
            component={MainScreen} 
            options={{
              gestureEnabled: false,
              headerShown: true,
              headerLeft: () => <></>,
            }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    );
  }
}



const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
