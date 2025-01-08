import { View, Text, Image, StyleSheet, TouchableNativeFeedbackComponent, TouchableOpacity } from 'react-native'
import React from 'react'
import { NativeStackScreenProps } from '@react-navigation/native-stack'
import { HithaText } from '../../config/Styles'
import colors from '../../config/colors'
import fonts from '../../config/fonts'
import languageTexts from '../../config/languageTexts'

export default function WelcomeScreen({route,navigation}) {
  const {language}=route.params
  const screenText=languageTexts[language].screens.initial.welcome
  return (
    <View style={styles.background}>
        <Image source={require("../../assets/welcomeImage.jpg")}/>
        <HithaText style={styles.mainText}>{screenText.hitha}</HithaText>
        <View>
            <TouchableOpacity onPress={() => navigation.navigate("Login Or Sign Up",{language:language})}>
              <HithaText style={styles.nextButton}>{screenText.next}</HithaText> 
            </TouchableOpacity>
        </View>
    </View>
  )
}

const styles = StyleSheet.create({
    background: {
      flex: 1,
      backgroundColor: colors.light,
      alignItems: 'center',
      justifyContent: 'center',
      gap:2
    },
    welcomeImage: {

    },
    mainText: {
      fontFamily:fonts.family.primary
    },
    nextButton: {
      fontStyle:"italic",
      fontFamily:fonts.family.primary
    }

})