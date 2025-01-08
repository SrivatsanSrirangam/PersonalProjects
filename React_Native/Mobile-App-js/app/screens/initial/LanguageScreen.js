import { SafeAreaView, StyleSheet, Text, View } from 'react-native'
import SelectDropdown from 'react-native-select-dropdown'
//import BlinkView from 'react-native-blink-view'
import React, { useEffect, useState } from 'react'
import colors from '../../config/colors'
import { Button } from '@rneui/base'
import { Picker } from '@react-native-picker/picker';
import AsyncStorage from '@react-native-async-storage/async-storage';
// import { HithaText } from '../../config/Styles'


export default function LanguageScreen({navigation}) {
    const languages=[
        { label:"ಕನ್ನಡ",value:"kan"},
        { label:"मराठी",value:"mar"},
        { label:"हिंदी",value:"hin"},
        { label:"English",value:"eng"}
    ]

    const arrow="\u2794"
    const [language,setLanguage]=useState(languages[0].value)
    //const [isLanguageSelected, setIsLanguageSelected]=useState(false)
    
    const setDefaultLanguageAndNavigate= async() =>{
        await AsyncStorage.setItem("currentAppLanguage", language);
        navigation.navigate("Welcome",{language:language})
    }
    return (
        <SafeAreaView style={styles.background}>
            <Picker
                style={styles.picker}
                selectedValue={language}
                onValueChange={currentLanguge => setLanguage(currentLanguge)}
            >

                {languages.map((lang) => 
                    <Picker.Item key={lang.value} label={lang.label} value={lang.value} />
                )}
            </Picker>
        {/* <BlinkView blinking={isBlinking?true:false} delay={1} element={SelectDropdown}> */}
            {/* <SelectDropdown
                data={languages}
                onSelect={(selectedItem, index) => {
                    console.log(selectedItem, index)
                    setIsLanguageSelected(true)
                }}
                buttonTextAfterSelection={(selectedItem, index) => {
                    // text represented after item is selected
                    // if data array is an array of objects then return selectedItem.property to render after item is selected
                    return selectedItem
                }}
                rowTextForSelection={(item, index) => {
                    // text represented for each item in dropdown
                    // if data array is an array of objects then return item.property to represent item in dropdown
                    return item
                }}
                defaultButtonText=" "
            /> */}
        {/* </BlinkView> */}
        <Button 
            style={styles.loginButton}
            title={arrow}
            onPress={setDefaultLanguageAndNavigate}
        />
            
        </SafeAreaView>
    )
    //
}

const styles = StyleSheet.create({
    background: {
        flex:1,
        backgroundColor: colors.light,
        alignItems: 'center',
        justifyContent: 'center',
        gap:10
    },
    picker:{
        width:200,
        height:200,
    }
})