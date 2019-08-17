package com.stcodesapp.quotes_einstein.tasks.utilityTasks;

import com.stcodesapp.quotes_einstein.constants.Constants;

public class UtilityTasks
{
    public static String trimString(String input)
    {
        return input.substring(0, Constants.MAXIMUM_STRING_LENGTH);
    }
}
