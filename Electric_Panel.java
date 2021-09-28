import java.util.List;
import java.util.ArrayList;

public class Electric_Panel
{
    private boolean is_on;//true if panel is being used, false otherwise
    List<Long> log;//first entry in log is on time in milliseconds, unix epoch
    Electric_Panel()
    {
        this.is_on = false;
        this.log = new ArrayList<Long>();
    }
    //
    public boolean get_state()//returns state of socket
    {
        return this.is_on;
    }
    //
    public void ON()//switches on the socket, if it is not already on
    {
        if(this.is_on)return;
        this.is_on = true;
        this.log.add(System.currentTimeMillis());//time is logged
    }
    public void OFF()//switches off the socket, if it is not already on
    {
        if(!this.is_on)return;
        this.is_on = true;
        this.log.add(System.currentTimeMillis());//time is logged
    }
    //
    public long time_used(long start, long end)//counts the number of milliseconds for which the socket was in operation
    {
        if(start>end || end>System.currentTimeMillis())return -1;//future cannot be predicted
        List<Long> log = new ArrayList<Long>(this.log);//creates a copy of log with an imaginary switchoff at end, so number of entries guaranteed to be even
        if(this.is_on)log.add(System.currentTimeMillis());
        long time=0;
        for(int i=0;i<log.size();i+=2)//looks at how many milliseconds in each on-off chunk falls between start and end
        {
            long ontime = log.get(i);
            long offtime = log.get(i+1);
            if(ontime>=end && offtime>=end)break;
            else if(ontime<=start && offtime<=start)continue;
            else if(ontime>=start&&offtime<=end)time+=offtime-ontime;
            else if(ontime>=start&&offtime>end){time+=-ontime+end;break;}
            else if(ontime<start&&offtime<=end)time+=offtime-start;
        }
        return time;
    }
}
