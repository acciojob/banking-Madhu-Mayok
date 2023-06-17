package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000)
        {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String s = this.tradeLicenseId;
                int m[]=new int[26];//Hashmap to store the frequency of each character
                int n=s.length();
                for(int i=0;i<n;i++)
                    m[s.charAt(i)-'A']++;

                StringBuilder ans=new StringBuilder();
                int i=0;
                char prev='*';//Keep track of previous character
                while(i<n){
                    int maxi=0,ind=0;
                    //We traverse the entire hashmap to find the character with maximum count and not equal to previous character
                    for(int j=0;j<26;j++){
                        if(m[j]>maxi&&prev!=(j+'A')&&m[j]>0){
                            maxi=m[j];
                            ind=j;
                        }
                    }
                    if(maxi==0) //If maxi is 0 then no solution can be made as suitable element not found
                    {
                        throw new ValidLicenseCanNotBeGenerated("Valid License Can Not Be Generated");
                    }
                    prev=(char)(ind+'A');//Updating previous
                    ans.append(prev);
                    m[ind]--;  //Decreasing count from map since the character is done
                    i++;
                }
                s= ans.toString();
    }

}
