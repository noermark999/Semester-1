/**
 A simple stopwatch
 */
public class StopWatch
{
    private long startTime;
    private long endTime;
    private boolean isRunning;

    /**
     Constructs a stopwatch that is in the stopped state
     and has no time accumulated.
     */
    public StopWatch()
    {
    }

    public void start()
    {
        if (isRunning)
            throw new RuntimeException("Cannot start a running stopwatch");
        isRunning = true;
        startTime = System.currentTimeMillis();
    }


    public void stop()
    {
        if (!isRunning)
            throw new RuntimeException("Cannot stop a stopped stopwatch");
        isRunning = false;
        endTime = System.currentTimeMillis();

    }

    public long getTime()
    {
        if (isRunning)
            throw new RuntimeException("Cannot get time for a running stopwatch");

        return endTime-startTime;
    }

}
