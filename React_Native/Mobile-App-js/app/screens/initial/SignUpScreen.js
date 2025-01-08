import { StyleSheet, View, TextInput, Pressable, Keyboard, Button } from 'react-native'
import { React, useState } from 'react'
import colors from '../../config/colors'
import OTPInput from '../../components/OTPInput'
import fonts from '../../config/fonts'
import { HithaText } from '../../config/Styles'
import languageTexts from '../../config/languageTexts'

export default function SignUpScreen({route, navigation}) {
    const {language}=route.params
    const screenText=languageTexts[language].screens.initial.signUp
   
    const [serverIP, setServerIP]=useState("")
    const [phoneNumber, setPhoneNumber]=useState("")
    const [aadharNumber, setAadharNumber]=useState("")
    const [firstName, setFirstName]=useState("")
    const [middleName, setMiddleName]=useState("")
    const [lastName, setLastName]=useState("")
    

    const handlePress= async() =>  {
        let serverEndpoint="http://"+serverIP+":8080"
        let hithaUser={
            phoneNumber:phoneNumber,
            aadharNumber:aadharNumber,
            firstName:firstName,
            middleName:middleName,
            lastName:lastName,
            language:language
        }
        console.log(serverEndpoint)
        console.log(serverEndpoint+"/users/checkConflict")
        console.log(JSON.stringify(hithaUser))
        fetch(serverEndpoint+"/users/checkConflict", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(hithaUser),
        })
        .then((response) => {
            console.log("Status:"+response.status)
            if(response.status==409){
                console.log(response.json())
                throw error;
            }
            else if(response.ok) {
                navigation.navigate("OTP",{hithaUser:hithaUser, language:language, serverIP:serverIP})
                console.log(response.json())
            }
            
        })
        .catch((error) => console.error(error))
        .finally();
        
    }
    return (
        
        <View style={styles.background}>
            <View style={styles.detailsContainer} >
                <HithaText>Server IP</HithaText>
                <TextInput 
                    placeholder='Server IP' 
                    style={styles.inputBox}
                    keyboardType='default'
                    onChangeText={(text => {setServerIP(text)})}    
                />
                <HithaText>{screenText.phoneNumber}</HithaText>
                <TextInput 
                    placeholder={screenText.phoneNumber}
                    style={styles.inputBox}
                    keyboardType='number-pad'
                    onChangeText={(text => {setPhoneNumber(text)})}
                    
                />
                <HithaText>{screenText.aadharNumber}</HithaText>
                <TextInput 
                    placeholder={screenText.aadharNumber} 
                    style={styles.inputBox}
                    keyboardType='number-pad'
                    onChangeText={(text => {setAadharNumber(text)})}
                />
                <HithaText>{screenText.firstName}</HithaText>
                <TextInput 
                    placeholder={screenText.firstName} 
                    style={styles.inputBox}
                    keyboardType="default"
                    onChangeText={(text => {setFirstName(text)})}
                />
                <HithaText>{screenText.middleName}</HithaText>
                <TextInput 
                    placeholder={screenText.middleName} 
                    style={styles.inputBox}
                    keyboardType="default"
                    onChangeText={(text => {setMiddleName(text)})}
                />
                <HithaText>{screenText.lastName}</HithaText>
                <TextInput 
                    placeholder={screenText.lastName} 
                    style={styles.inputBox}
                    keyboardType="default"
                    onChangeText={(text => {setLastName(text)})}
                />
                <Button
                    title={screenText.next}
                    // disabled={!isPinReady}
                    onPress={handlePress}
                />
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
        gap:3,
        padding:50
    },
    detailsContainer: {
        flex: 1,
        backgroundColor: colors.light,
        alignItems: 'center',
        justifyContent: 'center',
        gap:10
    },
    inputBox: {
        color:colors.dark,
        borderWidth: 2,
        borderColor: colors.dark,
        // fontFamily:fonts.family.primary,
        // fontSize: 20,
        width:300,
        padding:10
    }
})