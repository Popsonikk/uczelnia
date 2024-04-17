package com.example.pz_patryk_popek;

public  final class ContactContract {
    public ContactContract() {
    }
    public static class ContactEntry
    {
        public static final String TABLE_NAME= "note_info";
        public static final String NOTE_TITLE= "note_title";
        public static final String NOTE_BODY= "note_body";
    }
    public static class ContactEntryNoti
    {
        public static final String TABLE_NAME= "noti_info";
        public static final String NOTI_TITLE= "noti_title";
        public static final String NOTI_TIME= "noti_time";

    }
}
