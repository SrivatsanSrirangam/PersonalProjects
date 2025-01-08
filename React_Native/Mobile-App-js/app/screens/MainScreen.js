import {useEffect, useState} from 'react'
import { View, Text, StyleSheet, TextInput, ActivityIndicator } from 'react-native'
import colors from '../config/colors';
// import NavBarIconComponent from '../components/NavBarIconComponenet';
import NavBar from '../components/NavBar';
import fonts from '../config/fonts';
import { HithaText } from '../config/Styles';
import languageTexts from '../config/languageTexts';
import AsyncStorage from '@react-native-async-storage/async-storage';
export default function MainScreen() {
    const [isLoading, setIsLoading] = useState(true);
    // const url1="http://localhost:8080/languages/english"

    // const url2="https://jsonplaceholder.typicode.com/posts"
    
    const [screenText,setScreenText]=useState("");
    

    useEffect(() => {
        const loadLanguage = async () => {
            try {
              // Load the value for the specified key from AsyncStorage
              const language =await AsyncStorage.getItem("currentAppLanguage");
              if (language !== null) {
                setScreenText(languageTexts[language].screens.main);
                console.log('Data loaded successfully:', language);
                setIsLoading(false);
              } else {
                console.log('No data found for the key:', "currentAppLanguage");
              }
            } catch (error) {
              console.error('Error loading data:', error);
            }
          };
        // fetch(url2)
        //   .then((response) => response.json())
        //   .then((json) => console.log(json))
        //   .catch((error) => console.error(error))
        //   .finally();
        loadLanguage();
        
    }, []);
    const topNavBarItems = [
        {key:1, iconName:screenText.myCrops, iconSource:require("../assets/myCrops.png"), screenId:"MyCrops"},
        {key:2, iconName:screenText.myMoney, iconSource:require("../assets/myMoney.png"), screenId:"MyMoney"},
        {key:3, iconName:screenText.myHarvest, iconSource:require("../assets/myHarvest.jpg"), screenId:"MyHarvest"}
    ]

    const bottomNavBarItems = [
        {key:1, iconName:screenText.home, iconSource:require("../assets/home.png"), screenId:"Home"},
        {key:2, iconName:screenText.banking, iconSource:require("../assets/banking.png"), screenId:"Banking"},
        {key:3, iconName:screenText.knowledgeCenter, iconSource:require("../assets/knowledgeCentre.jpg"), screenId:"KnowledgeCentre"},
        {key:4, iconName:screenText.account, iconSource:require("../assets/account.png"), screenId:"Account"}
    ]

    

    
    
    
    const handleIconClick = (screenId) => {
        
    }
    return (
        <View style={styles.background}>
            {isLoading ? 
            (
                // Display a loading indicator while waiting for the data
                <ActivityIndicator size="large" color="#0000ff" />
            ) 
            : 
            (
                // Render your actual screen content once loading is complete
                <View style={styles.background}>
                    <View style={styles.headingSearchBarContainer}>
                        <View style={styles.heading}>
                                <HithaText style={styles.headingText}>{screenText.hitha}</HithaText>
                        </View>
                        <TextInput style={styles.searchBar} placeholder={screenText.search}/>
                    </View>
                    <NavBar navBarItems={topNavBarItems} handleIconClick={handleIconClick}/>
                    {/* Add new component hear if followin header footer style */}
                    <View style={styles.intermediateView}/>
                    <NavBar navBarItems={bottomNavBarItems} handleIconClick={handleIconClick}/>
                </View>

            )
            }
            </View>
    );
}

const styles = StyleSheet.create({
    background : {
        flex:1,
        justifyContent: "center",
        alignItems: "center",
        gap:50
        
    },
    headingSearchBarContainer: {
        
        justifyContent: "center",
        alignItems: "center",
        gap:10
    },
    heading: {
        borderWidth: 2,
        borderColor: colors.dark,
    }
    ,
    headingText : {
        fontFamily:fonts.family.primary,
        fontSize: fonts.size.large,
        padding:8,
        
    },
    searchBar : {
        color:colors.dark,
        borderWidth: 2,
        borderRadius: 2,
        borderColor: colors.dark,
        fontFamily:fonts.family.primary,
        fontSize: 12,
        width:200,
        height:20,
        padding:2
    },
    intermediateView: {
        widh:600,
        height:400,
    }
})