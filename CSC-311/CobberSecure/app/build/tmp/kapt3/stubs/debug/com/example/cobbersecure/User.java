package com.example.cobbersecure;

import java.lang.System;

@androidx.room.Entity(tableName = "user_table")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u00c6\u0003Ja\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u00062"}, d2 = {"Lcom/example/cobbersecure/User;", "", "userId", "", "userPassword", "", "userFname", "userLname", "userEmail", "userBio", "userImageName", "userFriendList", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getUserBio", "()Ljava/lang/String;", "setUserBio", "(Ljava/lang/String;)V", "getUserEmail", "setUserEmail", "getUserFname", "setUserFname", "getUserFriendList", "()Ljava/util/List;", "setUserFriendList", "(Ljava/util/List;)V", "getUserId", "()I", "setUserId", "(I)V", "getUserImageName", "setUserImageName", "getUserLname", "setUserLname", "getUserPassword", "setUserPassword", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class User {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @androidx.room.ColumnInfo(name = "user_id")
    private int userId;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_password")
    private java.lang.String userPassword;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_fname")
    private java.lang.String userFname;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_lname")
    private java.lang.String userLname;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_email")
    private java.lang.String userEmail;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_bio")
    private java.lang.String userBio;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "user_img")
    private java.lang.String userImageName;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "user_friendlist")
    private java.util.List<java.lang.Integer> userFriendList;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.cobbersecure.User copy(int userId, @org.jetbrains.annotations.NotNull
    java.lang.String userPassword, @org.jetbrains.annotations.NotNull
    java.lang.String userFname, @org.jetbrains.annotations.NotNull
    java.lang.String userLname, @org.jetbrains.annotations.NotNull
    java.lang.String userEmail, @org.jetbrains.annotations.NotNull
    java.lang.String userBio, @org.jetbrains.annotations.NotNull
    java.lang.String userImageName, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> userFriendList) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public User() {
        super();
    }
    
    public User(int userId, @org.jetbrains.annotations.NotNull
    java.lang.String userPassword, @org.jetbrains.annotations.NotNull
    java.lang.String userFname, @org.jetbrains.annotations.NotNull
    java.lang.String userLname, @org.jetbrains.annotations.NotNull
    java.lang.String userEmail, @org.jetbrains.annotations.NotNull
    java.lang.String userBio, @org.jetbrains.annotations.NotNull
    java.lang.String userImageName, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> userFriendList) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserPassword() {
        return null;
    }
    
    public final void setUserPassword(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserFname() {
        return null;
    }
    
    public final void setUserFname(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserLname() {
        return null;
    }
    
    public final void setUserLname(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserEmail() {
        return null;
    }
    
    public final void setUserEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserBio() {
        return null;
    }
    
    public final void setUserBio(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserImageName() {
        return null;
    }
    
    public final void setUserImageName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.Integer> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.Integer> getUserFriendList() {
        return null;
    }
    
    public final void setUserFriendList(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.Integer> p0) {
    }
}