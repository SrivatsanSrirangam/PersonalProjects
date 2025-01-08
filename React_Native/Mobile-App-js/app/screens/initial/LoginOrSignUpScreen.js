import { StyleSheet, Button, View, Text, TouchableOpacity } from 'react-native'
import React from 'react'
import colors from '../../config/colors'
import fonts from '../../config/fonts'
import { HithaText } from '../../config/Styles'
import languageTexts from '../../config/languageTexts'
export default function LoginOrSignUpScreen({route,navigation}) {
    const {language}=route.params
    const screenText=languageTexts[language].screens.initial.loginOrSignUp
    return (
        <View style={styles.background}>
            <Button 
                style={styles.loginButton}
                title={screenText.login}
            />
            <View style={styles.signUpBar}>
                <HithaText>{screenText.or}</HithaText>
                <TouchableOpacity onPress={() => navigation.navigate("Sign Up",{language:language})}>
                    <HithaText>{screenText.signUp}</HithaText>
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
    },
    loginButton: {
        alignContent:"center",
        justifyContent:"center",
        fontFamily:fonts.family.primary

    },
    signUpBar: {
        flexDirection:"row",
        gap:4,
        fontFamily:fonts.family.primary
    }
})