package com.IMEI.Gen;


public class ImeiGenerator {
	private long minNumber = 35757210000000L;
	private long maxNumber = 35757210999999L;

	
	public  int[] longToIntArray(long guess)
    {
		String temp = Long.toString(guess);
		int[] newGuess = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
		    newGuess[i] = temp.charAt(i) - '0';
		}
		return newGuess;
    }
	
	public int luhn_checksum(int[] digits)
	{
	    int sum = 0;
	    int length = digits.length;
	    for (int i = 0; i < length; i++)
	    {
	        // get digits in reverse order
	        int digit = digits[length - i - 1];
	        // every 2nd number multiply with 2
	        if (i % 2 == 1)
	            digit *= 2;
	        sum += digit > 9 ? digit - 9 : digit;
	    }
	    return sum % 10;
	}
	
	
	public int luhn_caclulate(int[] partcode) {
		StringBuilder builder = new StringBuilder();
		for (int value : partcode) {
		    builder.append(value);
		}
		String s = builder.toString();
	    int checksum = luhn_checksum(longToIntArray(Long.parseLong(s + "0")));
	    return checksum == 0 ? 0 : 10 - checksum;
	}
	
	
	public void calculateIMEI() {
		long temp;
		String imei;
		for(temp = minNumber; temp <= maxNumber; temp++) {
			long checkDigit = luhn_caclulate(longToIntArray(temp));
			imei = Long.toString(temp) + Long.toString(checkDigit);
			System.out.println(imei);
		}
	}

}
