package org.apache.flink.training.exercises.commentremove;

        //import org.apache.flink.training.solutions.longrides.LongRidesSolution;

        import org.junit.Test;

        import java.time.Instant;

        import static org.junit.Assert.assertEquals;

public class CommentRemoveTest {

    //static final Testable JAVA_EXERCISE = () -> CommentRemove.main(new String[]{});

    private static final Instant BEGINNING = Instant.parse("2020-01-01T12:00:00.00Z");

    @Test
    public void startIsDelayedMoreThanTwoHours() throws Exception {
        Long mark2HoursAfterEnd = BEGINNING.plusSeconds(180 * 60).toEpochMilli();

    }

}
