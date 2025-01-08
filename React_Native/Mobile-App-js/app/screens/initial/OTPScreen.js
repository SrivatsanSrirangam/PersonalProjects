import { Keyboard, Pressable, StyleSheet, View } from 'react-native'
import React, { useState } from 'react'
import OTPInput from '../../components/OTPInput';
import colors from '../../config/colors';
import { HithaText } from '../../config/Styles';
import { Button } from 'react-native-elements';

export default function OTPScreen({route,navigation}) {
    const {languageTexts,serverIP,hithaUser} = route.params
    const [otpCode, setOTPCode] = useState("");
    const [isPinReady, setIsPinReady] = useState(false);
    const maximumCodeLength = 4;
    
    const verifyOTP = async () => {
        return true;
    }

    const handlePress = async ()  => {
        let serverEndpoint="http://"+serverIP+":8080"
        console.log("OTP Screen")
        console.log(hithaUser)
        console.log(serverEndpoint)
        console.log(serverEndpoint+"/users/add")
        isOTPCorrect=await verifyOTP()
        if(isOTPCorrect) {
            console.log("OTP is correct")
            fetch(serverEndpoint+"/users/add", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(hithaUser),
            })
            .then((response) => {
                console.log("Status:"+response.status)
                console.log(response.json())
                if(response.ok) {
                    console.log(response.json())
                    navigation.navigate("Main")
                    
                }

                
                response.json
            })
            .then((json) => console.log(json))
            .catch((error) => console.error(error))
            .finally();
        }

    }

    return(
        <View style={styles.background}>
            <View style={styles.detailsContainer} >
                <HithaText>OTP</HithaText>
                <Pressable  onPress={Keyboard.dismiss}>
                    <OTPInput
                        code={otpCode}
                        setCode={setOTPCode}
                        maximumLength={maximumCodeLength}
                        setIsPinReady={setIsPinReady}
                    />
                </Pressable>
                <Button
                    title="Next"
                    disabled={!isPinReady}
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