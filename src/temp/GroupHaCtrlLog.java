package temp;

import java.util.Date;

public class GroupHaCtrlLog {
    Date time;
    String level;
    String Thread;
    String className;
    String content;


    public GroupHaCtrlLog(Date time, String level, String thread, String className, String content) {
        this.time = time;
        this.level = level;
        Thread = thread;
        this.className = className;
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public GroupHaCtrlLog setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public GroupHaCtrlLog setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getThread() {
        return Thread;
    }

    public GroupHaCtrlLog setThread(String thread) {
        Thread = thread;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public GroupHaCtrlLog setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getContent() {
        return content;
    }

    public GroupHaCtrlLog setContent(String content) {
        this.content = content;
        return this;
    }
}
