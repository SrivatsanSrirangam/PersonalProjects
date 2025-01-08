package com.hitha.SpringBootApp1.objects;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserConflict {
    private boolean overallConflict;
    private boolean phoneNumber;
    private boolean aadharNumber;
}
