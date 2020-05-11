package com.example.b10709043_hw2.myDbUtil;

import android.provider.BaseColumns;

public class MyDbContact {
    public static final class WaitList implements BaseColumns {
        public static final String TABLE_NAME = "WaitList";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_PARTY_SIZE = "partySize";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
