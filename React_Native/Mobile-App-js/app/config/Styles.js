import styled from "styled-components/native";
import colors from "./colors";
import fonts from "./fonts";

export const OTPInputContainer = styled.View`
 justify-content: center;
 align-items: center;
`;

export const TextInputHidden = styled.TextInput`
 position: absolute;
 opacity: 0;
`;

export const SplitOTPBoxesContainer = styled.Pressable`
 width: 300;
 flex-direction: row;
 justify-content: space-evenly;
`;

//border-radius: 5;
//padding: 12;
export const SplitBoxes = styled.View`
 border-color: #000;
 border-width: 2;
 
 
 min-width: 50px;
`;

export const SplitBoxText = styled.Text`
 font-size: 20;
 text-align: center;
 color: #000;
 `;

export const SplitBoxesFocused = styled(SplitBoxes)`
 border-color: #ecdbba;
 background-color: grey;
 `;
 
export const HithaText= styled.Text`
 font-family:${fonts.family.primary}     
 `;