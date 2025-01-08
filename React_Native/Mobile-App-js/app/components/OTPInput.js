import { StyleSheet, Text, View } from 'react-native'
import React, {useRef, useState, useEffect} from 'react'
import { OTPInputContainer, TextInputHidden, SplitBoxText, SplitBoxes, SplitOTPBoxesContainer, SplitBoxesFocused } from '../config/Styles'

export default function OTPInput({ code, setCode, maximumLength, setIsPinReady }) {
    const boxArray = new Array(maximumLength).fill(0);
    const inputRef = useRef();
    const [isInputBoxFocused, setIsInputBoxFocused] = useState(false);
    useEffect(() => {
        // update pin ready status
        setIsPinReady(code.length === maximumLength);
        // clean up function
        return () => {
          setIsPinReady(false);
        };
      }, [code]);
    const handleOnPress = () => {
        setIsInputBoxFocused(true);
        inputRef.current.focus();
    };

    const handleOnBlur = () => {
        setIsInputBoxFocused(false);
    };
    
    const boxDigit = (_, index) => {
        const emptyInput = "";
        const digit = code[index] || emptyInput;

        const isCurrentValue = index === code.length;
        const isLastValue = index === maximumLength - 1;
        const isCodeComplete = code.length === maximumLength;

        const isValueFocused = isCurrentValue || (isLastValue && isCodeComplete);
        const StyledSplitBoxes =
            isInputBoxFocused && isValueFocused ? SplitBoxesFocused : SplitBoxes;
        
        return (
            <StyledSplitBoxes key={index}>
                <SplitBoxText>{digit}</SplitBoxText>
            </StyledSplitBoxes>
        );
    };
    return (
        <OTPInputContainer >
            <SplitOTPBoxesContainer onPress={handleOnPress}>{boxArray.map(boxDigit)}</SplitOTPBoxesContainer>
            <TextInputHidden
                value={code}
                onChangeText={setCode}
                maxLength={maximumLength}
                ref={inputRef}
                onBlur={handleOnBlur}
                keyboardType='number-pad'
                
            />
        </OTPInputContainer>
  )
}

const styles = StyleSheet.create({})