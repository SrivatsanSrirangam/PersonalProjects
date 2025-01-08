import { View, StyleSheet } from 'react-native'
import React from 'react'
import NavBarIcon from './NavBarIcon'

export default function NavBar({ navBarItems , handleIconClick }) {
  return (
    <View style={styles.navbar}>
        {navBarItems.map((navBarItem) =>
            <NavBarIcon 
                iconObj={navBarItem}
                handleIconClick={handleIconClick} 
                key={navBarItem.key}
            />
        )}
    </View>
  )
}

const styles = StyleSheet.create({
    navbar:{
        justifyContent:"center",
        alignItems:"center",
        flexDirection:"row",
        width:100,
        height:15,
        gap:30
    }
})