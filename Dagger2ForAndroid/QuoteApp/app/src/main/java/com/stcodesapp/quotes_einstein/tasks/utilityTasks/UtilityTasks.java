package com.stcodesapp.quotes_einstein.tasks.utilityTasks;

import com.stcodesapp.quotes_einstein.constants.Constants;

public class UtilityTasks
{
    public static String trimString(String input)
    {
        if(input.length()>Constants.MAXIMUM_STRING_LENGTH)
            return input.substring(0, Constants.MAXIMUM_STRING_LENGTH) + Constants.DOTS;
        return input;
    }
}
