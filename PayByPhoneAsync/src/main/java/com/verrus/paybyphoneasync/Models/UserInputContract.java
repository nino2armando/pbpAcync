package com.verrus.paybyphoneasync.Models;

import android.provider.BaseColumns;

/**
 * Created by nkhodabandeh on 15/01/14.
 */
public class UserInputContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public UserInputContract(){}

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_VALUE = "value";
    }
}
