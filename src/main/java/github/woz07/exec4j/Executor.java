package github.woz07.exec4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author woz07
 *
 * Executor.java
 * This is the class that must be initialized in order to execute programs
 */

public class Executor {
    /**
     * This is the method used to execute different files from within your project
     * @param command The command you would like to execute
     * @return Returns the end result code, 0 for success, >0 for issue
     * @throws IOException Thrown because of builder.start()
     * @throws InterruptedException Thrown because of process.waitFor()
     */
    public synchronized int execute(String command) throws IOException, InterruptedException {
        if (command == null) return 1;
        List<String> list = new ArrayList<>(Arrays.asList(command.split("\\s+")));
        ProcessBuilder builder = new ProcessBuilder(list);
        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process process = builder.start();

        return process.waitFor();
    }
}
