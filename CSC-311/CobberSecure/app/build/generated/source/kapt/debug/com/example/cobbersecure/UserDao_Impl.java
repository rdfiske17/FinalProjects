package com.example.cobbersecure;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user_table` (`user_id`,`user_password`,`user_fname`,`user_lname`,`user_email`,`user_bio`,`user_img`,`user_friendlist`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUserPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserPassword());
        }
        if (value.getUserFname() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserFname());
        }
        if (value.getUserLname() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserLname());
        }
        if (value.getUserEmail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserEmail());
        }
        if (value.getUserBio() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUserBio());
        }
        if (value.getUserImageName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserImageName());
        }
        final String _tmp = __converters.fromList(value.getUserFriendList());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp);
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user_table` WHERE `user_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user_table` SET `user_id` = ?,`user_password` = ?,`user_fname` = ?,`user_lname` = ?,`user_email` = ?,`user_bio` = ?,`user_img` = ?,`user_friendlist` = ? WHERE `user_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUserPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserPassword());
        }
        if (value.getUserFname() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserFname());
        }
        if (value.getUserLname() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserLname());
        }
        if (value.getUserEmail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserEmail());
        }
        if (value.getUserBio() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUserBio());
        }
        if (value.getUserImageName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserImageName());
        }
        final String _tmp = __converters.fromList(value.getUserFriendList());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp);
        }
        stmt.bindLong(9, value.getUserId());
      }
    };
  }

  @Override
  public Object insert(final User user, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final User user, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final User user, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<User> get(final long key) {
    final String _sql = "SELECT * FROM user_table WHERE user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, key);
    return __db.getInvalidationTracker().createLiveData(new String[]{"user_table"}, false, new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfUserPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "user_password");
          final int _cursorIndexOfUserFname = CursorUtil.getColumnIndexOrThrow(_cursor, "user_fname");
          final int _cursorIndexOfUserLname = CursorUtil.getColumnIndexOrThrow(_cursor, "user_lname");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user_email");
          final int _cursorIndexOfUserBio = CursorUtil.getColumnIndexOrThrow(_cursor, "user_bio");
          final int _cursorIndexOfUserImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "user_img");
          final int _cursorIndexOfUserFriendList = CursorUtil.getColumnIndexOrThrow(_cursor, "user_friendlist");
          final User _result;
          if(_cursor.moveToFirst()) {
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpUserPassword;
            if (_cursor.isNull(_cursorIndexOfUserPassword)) {
              _tmpUserPassword = null;
            } else {
              _tmpUserPassword = _cursor.getString(_cursorIndexOfUserPassword);
            }
            final String _tmpUserFname;
            if (_cursor.isNull(_cursorIndexOfUserFname)) {
              _tmpUserFname = null;
            } else {
              _tmpUserFname = _cursor.getString(_cursorIndexOfUserFname);
            }
            final String _tmpUserLname;
            if (_cursor.isNull(_cursorIndexOfUserLname)) {
              _tmpUserLname = null;
            } else {
              _tmpUserLname = _cursor.getString(_cursorIndexOfUserLname);
            }
            final String _tmpUserEmail;
            if (_cursor.isNull(_cursorIndexOfUserEmail)) {
              _tmpUserEmail = null;
            } else {
              _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            }
            final String _tmpUserBio;
            if (_cursor.isNull(_cursorIndexOfUserBio)) {
              _tmpUserBio = null;
            } else {
              _tmpUserBio = _cursor.getString(_cursorIndexOfUserBio);
            }
            final String _tmpUserImageName;
            if (_cursor.isNull(_cursorIndexOfUserImageName)) {
              _tmpUserImageName = null;
            } else {
              _tmpUserImageName = _cursor.getString(_cursorIndexOfUserImageName);
            }
            final List<Integer> _tmpUserFriendList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfUserFriendList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfUserFriendList);
            }
            _tmpUserFriendList = __converters.toList(_tmp);
            _result = new User(_tmpUserId,_tmpUserPassword,_tmpUserFname,_tmpUserLname,_tmpUserEmail,_tmpUserBio,_tmpUserImageName,_tmpUserFriendList);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<User>> getAll() {
    final String _sql = "SELECT * FROM user_table ORDER BY user_id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"user_table"}, false, new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfUserPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "user_password");
          final int _cursorIndexOfUserFname = CursorUtil.getColumnIndexOrThrow(_cursor, "user_fname");
          final int _cursorIndexOfUserLname = CursorUtil.getColumnIndexOrThrow(_cursor, "user_lname");
          final int _cursorIndexOfUserEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "user_email");
          final int _cursorIndexOfUserBio = CursorUtil.getColumnIndexOrThrow(_cursor, "user_bio");
          final int _cursorIndexOfUserImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "user_img");
          final int _cursorIndexOfUserFriendList = CursorUtil.getColumnIndexOrThrow(_cursor, "user_friendlist");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpUserPassword;
            if (_cursor.isNull(_cursorIndexOfUserPassword)) {
              _tmpUserPassword = null;
            } else {
              _tmpUserPassword = _cursor.getString(_cursorIndexOfUserPassword);
            }
            final String _tmpUserFname;
            if (_cursor.isNull(_cursorIndexOfUserFname)) {
              _tmpUserFname = null;
            } else {
              _tmpUserFname = _cursor.getString(_cursorIndexOfUserFname);
            }
            final String _tmpUserLname;
            if (_cursor.isNull(_cursorIndexOfUserLname)) {
              _tmpUserLname = null;
            } else {
              _tmpUserLname = _cursor.getString(_cursorIndexOfUserLname);
            }
            final String _tmpUserEmail;
            if (_cursor.isNull(_cursorIndexOfUserEmail)) {
              _tmpUserEmail = null;
            } else {
              _tmpUserEmail = _cursor.getString(_cursorIndexOfUserEmail);
            }
            final String _tmpUserBio;
            if (_cursor.isNull(_cursorIndexOfUserBio)) {
              _tmpUserBio = null;
            } else {
              _tmpUserBio = _cursor.getString(_cursorIndexOfUserBio);
            }
            final String _tmpUserImageName;
            if (_cursor.isNull(_cursorIndexOfUserImageName)) {
              _tmpUserImageName = null;
            } else {
              _tmpUserImageName = _cursor.getString(_cursorIndexOfUserImageName);
            }
            final List<Integer> _tmpUserFriendList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfUserFriendList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfUserFriendList);
            }
            _tmpUserFriendList = __converters.toList(_tmp);
            _item = new User(_tmpUserId,_tmpUserPassword,_tmpUserFname,_tmpUserLname,_tmpUserEmail,_tmpUserBio,_tmpUserImageName,_tmpUserFriendList);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> loginQuery(final String email, final String password) {
    final String _sql = "SELECT user_id FROM user_table WHERE user_email= ? AND user_password= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"user_table"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
