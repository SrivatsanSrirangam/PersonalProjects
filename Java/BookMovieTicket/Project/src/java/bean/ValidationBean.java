/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author srivatsansrirangam
 */
@Named(value = "validationBean")
@RequestScoped
public class ValidationBean {
    private String creditCardNo;
    private String billingZipCode;
    private String validationMessage;
    private int numberOfTickets;
    
    public ValidationBean() {
        numberOfTickets=0;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    
    public int findTotalCost() {
        return numberOfTickets*10;
    }
    
    
    
    
    
    
    public void validateValues(){
        if (creditCardNo == null || creditCardNo.length() != 16) {
            if (billingZipCode==null || billingZipCode.length() != 5){
                validationMessage="Credit card  number and billing zipcode must be 16 and five characters long respectively";
            }
            else{
                validationMessage="Credit card number must be 16 characters long";
            }
        }
        else{
            if (billingZipCode==null || billingZipCode.length() != 5){
                validationMessage="Billing zip code must be five characters long";
            }
            else{
                
                if (numberOfTickets < 1){
                    validationMessage="Number Of tickets must be greater than or equal to 1";
                }
                else {
                    validationMessage="Movie tickets have been booked. Your total cost is $"
                            + findTotalCost() + 
                            ". Enjoy the movie!!";
                }
            }
              
        }
            
        
        
    }
}
