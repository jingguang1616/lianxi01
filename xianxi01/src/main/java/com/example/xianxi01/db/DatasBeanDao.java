package com.example.xianxi01.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.xianxi01.bean.DatasBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATAS_BEAN".
*/
public class DatasBeanDao extends AbstractDao<DatasBean, Long> {

    public static final String TABLENAME = "DATAS_BEAN";

    /**
     * Properties of entity DatasBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ApkLink = new Property(1, String.class, "apkLink", false, "APK_LINK");
        public final static Property Audit = new Property(2, int.class, "audit", false, "AUDIT");
        public final static Property Author = new Property(3, String.class, "author", false, "AUTHOR");
        public final static Property CanEdit = new Property(4, boolean.class, "canEdit", false, "CAN_EDIT");
        public final static Property ChapterId = new Property(5, int.class, "chapterId", false, "CHAPTER_ID");
        public final static Property ChapterName = new Property(6, String.class, "chapterName", false, "CHAPTER_NAME");
        public final static Property Collect = new Property(7, boolean.class, "collect", false, "COLLECT");
        public final static Property CourseId = new Property(8, int.class, "courseId", false, "COURSE_ID");
        public final static Property Desc = new Property(9, String.class, "desc", false, "DESC");
        public final static Property DescMd = new Property(10, String.class, "descMd", false, "DESC_MD");
        public final static Property EnvelopePic = new Property(11, String.class, "envelopePic", false, "ENVELOPE_PIC");
        public final static Property Fresh = new Property(12, boolean.class, "fresh", false, "FRESH");
        public final static Property Link = new Property(13, String.class, "link", false, "LINK");
        public final static Property NiceDate = new Property(14, String.class, "niceDate", false, "NICE_DATE");
        public final static Property NiceShareDate = new Property(15, String.class, "niceShareDate", false, "NICE_SHARE_DATE");
        public final static Property Origin = new Property(16, String.class, "origin", false, "ORIGIN");
        public final static Property Prefix = new Property(17, String.class, "prefix", false, "PREFIX");
        public final static Property ProjectLink = new Property(18, String.class, "projectLink", false, "PROJECT_LINK");
        public final static Property PublishTime = new Property(19, long.class, "publishTime", false, "PUBLISH_TIME");
        public final static Property RealSuperChapterId = new Property(20, int.class, "realSuperChapterId", false, "REAL_SUPER_CHAPTER_ID");
        public final static Property SelfVisible = new Property(21, int.class, "selfVisible", false, "SELF_VISIBLE");
        public final static Property ShareDate = new Property(22, long.class, "shareDate", false, "SHARE_DATE");
        public final static Property ShareUser = new Property(23, String.class, "shareUser", false, "SHARE_USER");
        public final static Property SuperChapterId = new Property(24, int.class, "superChapterId", false, "SUPER_CHAPTER_ID");
        public final static Property SuperChapterName = new Property(25, String.class, "superChapterName", false, "SUPER_CHAPTER_NAME");
        public final static Property Title = new Property(26, String.class, "title", false, "TITLE");
        public final static Property Type = new Property(27, int.class, "type", false, "TYPE");
        public final static Property UserId = new Property(28, int.class, "userId", false, "USER_ID");
        public final static Property Visible = new Property(29, int.class, "visible", false, "VISIBLE");
        public final static Property Zan = new Property(30, int.class, "zan", false, "ZAN");
        public final static Property Xin = new Property(31, boolean.class, "xin", false, "XIN");
    }


    public DatasBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DatasBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATAS_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"APK_LINK\" TEXT," + // 1: apkLink
                "\"AUDIT\" INTEGER NOT NULL ," + // 2: audit
                "\"AUTHOR\" TEXT," + // 3: author
                "\"CAN_EDIT\" INTEGER NOT NULL ," + // 4: canEdit
                "\"CHAPTER_ID\" INTEGER NOT NULL ," + // 5: chapterId
                "\"CHAPTER_NAME\" TEXT," + // 6: chapterName
                "\"COLLECT\" INTEGER NOT NULL ," + // 7: collect
                "\"COURSE_ID\" INTEGER NOT NULL ," + // 8: courseId
                "\"DESC\" TEXT," + // 9: desc
                "\"DESC_MD\" TEXT," + // 10: descMd
                "\"ENVELOPE_PIC\" TEXT," + // 11: envelopePic
                "\"FRESH\" INTEGER NOT NULL ," + // 12: fresh
                "\"LINK\" TEXT," + // 13: link
                "\"NICE_DATE\" TEXT," + // 14: niceDate
                "\"NICE_SHARE_DATE\" TEXT," + // 15: niceShareDate
                "\"ORIGIN\" TEXT," + // 16: origin
                "\"PREFIX\" TEXT," + // 17: prefix
                "\"PROJECT_LINK\" TEXT," + // 18: projectLink
                "\"PUBLISH_TIME\" INTEGER NOT NULL ," + // 19: publishTime
                "\"REAL_SUPER_CHAPTER_ID\" INTEGER NOT NULL ," + // 20: realSuperChapterId
                "\"SELF_VISIBLE\" INTEGER NOT NULL ," + // 21: selfVisible
                "\"SHARE_DATE\" INTEGER NOT NULL ," + // 22: shareDate
                "\"SHARE_USER\" TEXT," + // 23: shareUser
                "\"SUPER_CHAPTER_ID\" INTEGER NOT NULL ," + // 24: superChapterId
                "\"SUPER_CHAPTER_NAME\" TEXT," + // 25: superChapterName
                "\"TITLE\" TEXT," + // 26: title
                "\"TYPE\" INTEGER NOT NULL ," + // 27: type
                "\"USER_ID\" INTEGER NOT NULL ," + // 28: userId
                "\"VISIBLE\" INTEGER NOT NULL ," + // 29: visible
                "\"ZAN\" INTEGER NOT NULL ," + // 30: zan
                "\"XIN\" INTEGER NOT NULL );"); // 31: xin
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATAS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DatasBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String apkLink = entity.getApkLink();
        if (apkLink != null) {
            stmt.bindString(2, apkLink);
        }
        stmt.bindLong(3, entity.getAudit());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
        stmt.bindLong(5, entity.getCanEdit() ? 1L: 0L);
        stmt.bindLong(6, entity.getChapterId());
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(7, chapterName);
        }
        stmt.bindLong(8, entity.getCollect() ? 1L: 0L);
        stmt.bindLong(9, entity.getCourseId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(10, desc);
        }
 
        String descMd = entity.getDescMd();
        if (descMd != null) {
            stmt.bindString(11, descMd);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(12, envelopePic);
        }
        stmt.bindLong(13, entity.getFresh() ? 1L: 0L);
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(14, link);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(15, niceDate);
        }
 
        String niceShareDate = entity.getNiceShareDate();
        if (niceShareDate != null) {
            stmt.bindString(16, niceShareDate);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(17, origin);
        }
 
        String prefix = entity.getPrefix();
        if (prefix != null) {
            stmt.bindString(18, prefix);
        }
 
        String projectLink = entity.getProjectLink();
        if (projectLink != null) {
            stmt.bindString(19, projectLink);
        }
        stmt.bindLong(20, entity.getPublishTime());
        stmt.bindLong(21, entity.getRealSuperChapterId());
        stmt.bindLong(22, entity.getSelfVisible());
        stmt.bindLong(23, entity.getShareDate());
 
        String shareUser = entity.getShareUser();
        if (shareUser != null) {
            stmt.bindString(24, shareUser);
        }
        stmt.bindLong(25, entity.getSuperChapterId());
 
        String superChapterName = entity.getSuperChapterName();
        if (superChapterName != null) {
            stmt.bindString(26, superChapterName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(27, title);
        }
        stmt.bindLong(28, entity.getType());
        stmt.bindLong(29, entity.getUserId());
        stmt.bindLong(30, entity.getVisible());
        stmt.bindLong(31, entity.getZan());
        stmt.bindLong(32, entity.getXin() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DatasBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String apkLink = entity.getApkLink();
        if (apkLink != null) {
            stmt.bindString(2, apkLink);
        }
        stmt.bindLong(3, entity.getAudit());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
        stmt.bindLong(5, entity.getCanEdit() ? 1L: 0L);
        stmt.bindLong(6, entity.getChapterId());
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(7, chapterName);
        }
        stmt.bindLong(8, entity.getCollect() ? 1L: 0L);
        stmt.bindLong(9, entity.getCourseId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(10, desc);
        }
 
        String descMd = entity.getDescMd();
        if (descMd != null) {
            stmt.bindString(11, descMd);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(12, envelopePic);
        }
        stmt.bindLong(13, entity.getFresh() ? 1L: 0L);
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(14, link);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(15, niceDate);
        }
 
        String niceShareDate = entity.getNiceShareDate();
        if (niceShareDate != null) {
            stmt.bindString(16, niceShareDate);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(17, origin);
        }
 
        String prefix = entity.getPrefix();
        if (prefix != null) {
            stmt.bindString(18, prefix);
        }
 
        String projectLink = entity.getProjectLink();
        if (projectLink != null) {
            stmt.bindString(19, projectLink);
        }
        stmt.bindLong(20, entity.getPublishTime());
        stmt.bindLong(21, entity.getRealSuperChapterId());
        stmt.bindLong(22, entity.getSelfVisible());
        stmt.bindLong(23, entity.getShareDate());
 
        String shareUser = entity.getShareUser();
        if (shareUser != null) {
            stmt.bindString(24, shareUser);
        }
        stmt.bindLong(25, entity.getSuperChapterId());
 
        String superChapterName = entity.getSuperChapterName();
        if (superChapterName != null) {
            stmt.bindString(26, superChapterName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(27, title);
        }
        stmt.bindLong(28, entity.getType());
        stmt.bindLong(29, entity.getUserId());
        stmt.bindLong(30, entity.getVisible());
        stmt.bindLong(31, entity.getZan());
        stmt.bindLong(32, entity.getXin() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DatasBean readEntity(Cursor cursor, int offset) {
        DatasBean entity = new DatasBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // apkLink
            cursor.getInt(offset + 2), // audit
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // author
            cursor.getShort(offset + 4) != 0, // canEdit
            cursor.getInt(offset + 5), // chapterId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // chapterName
            cursor.getShort(offset + 7) != 0, // collect
            cursor.getInt(offset + 8), // courseId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // desc
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // descMd
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // envelopePic
            cursor.getShort(offset + 12) != 0, // fresh
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // link
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // niceDate
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // niceShareDate
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // origin
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // prefix
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // projectLink
            cursor.getLong(offset + 19), // publishTime
            cursor.getInt(offset + 20), // realSuperChapterId
            cursor.getInt(offset + 21), // selfVisible
            cursor.getLong(offset + 22), // shareDate
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // shareUser
            cursor.getInt(offset + 24), // superChapterId
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // superChapterName
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // title
            cursor.getInt(offset + 27), // type
            cursor.getInt(offset + 28), // userId
            cursor.getInt(offset + 29), // visible
            cursor.getInt(offset + 30), // zan
            cursor.getShort(offset + 31) != 0 // xin
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DatasBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setApkLink(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAudit(cursor.getInt(offset + 2));
        entity.setAuthor(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCanEdit(cursor.getShort(offset + 4) != 0);
        entity.setChapterId(cursor.getInt(offset + 5));
        entity.setChapterName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCollect(cursor.getShort(offset + 7) != 0);
        entity.setCourseId(cursor.getInt(offset + 8));
        entity.setDesc(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDescMd(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setEnvelopePic(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setFresh(cursor.getShort(offset + 12) != 0);
        entity.setLink(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setNiceDate(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setNiceShareDate(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setOrigin(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPrefix(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setProjectLink(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setPublishTime(cursor.getLong(offset + 19));
        entity.setRealSuperChapterId(cursor.getInt(offset + 20));
        entity.setSelfVisible(cursor.getInt(offset + 21));
        entity.setShareDate(cursor.getLong(offset + 22));
        entity.setShareUser(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setSuperChapterId(cursor.getInt(offset + 24));
        entity.setSuperChapterName(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setTitle(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setType(cursor.getInt(offset + 27));
        entity.setUserId(cursor.getInt(offset + 28));
        entity.setVisible(cursor.getInt(offset + 29));
        entity.setZan(cursor.getInt(offset + 30));
        entity.setXin(cursor.getShort(offset + 31) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DatasBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DatasBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DatasBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
