import { View, Text, Image, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import fonts from '../config/fonts'

export default function NavBarIcon({iconObj, handleIconClick}) {
  return (
    
    <TouchableOpacity onPress={handleIconClick(iconObj.screenId)} style={styles.background}>
      <View style={styles.insideView}>
        <Image source={iconObj.iconSource} style={styles.icon}></Image>
        <Text style={styles.text}>{iconObj.iconName}</Text>  
      </View> 
    </TouchableOpacity>
    
  )
}

const styles = StyleSheet.create({
  background: {
      alignItems:'center',
      justifyContent:"center",
      // flex:1,
      
  },
  insideView: {
    //gap: 3,
    justifyContent:"center",
    alignItems:"center",
  },

  icon:{
    width:60,
    height:60 
  },
  text: {
    justifyContent:"center",
    alignItems:"center",
    fontFamily:fonts.family.primary
    
  }
})