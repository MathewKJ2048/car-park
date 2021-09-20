import java.util.List;
import java.util.ArrayList;

public class Electric_Panel
{
    private boolean is_on;
    List<Long> log;//first entry in log is on time in milliseconds, unix epoch
    Electric_Panel()
    {
        this.is_on = false;
        this.log = new ArrayList<Long>();
    }
    //
    public boolean get_state()
    {
        return this.is_on;
    }
    //
    public void ON()
    {
        if(this.is_on)return;
        this.is_on = true;
        this.log.add(System.currentTimeMillis());
    }
    public void OFF()
    {
        if(!this.is_on)return;
        this.is_on = true;
        this.log.add(System.currentTimeMillis());
    }
    //
    public long time_used(long start, long end)
    {
        if(start>end || end>System.currentTimeMillis())return -1;
        List<Long> log = new ArrayList<Long>(this.log);
        if(this.is_on)log.add(System.currentTimeMillis());
        long time=0;
        for(int i=0;i<log.size();i+=2)
        {
            long ontime = log.get(i);
            long offtime = log.get(i+1);
            if(ontime >= end && offtime>=end)break;
            else if(ontime>=start&&offtime<=end)time+=offtime-ontime;
            else if(ontime>=start&&offtime>end){time+=-ontime+end;break;}
            else if(ontime<start&&offtime<=end)time+=offtime-start;
        }
        return time;
    }
}
