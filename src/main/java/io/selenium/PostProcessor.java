package io.jobee.selenium;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class PostProcessor extends RuntimeException implements TestExecutionExceptionHandler, AfterTestExecutionCallback {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)  {
        //System.out.println("\n\nDEBUG: " + throwable.getLocalizedMessage() + "\n\n");
        //System.out.println( "\n\nTEST: " + Arrays.stream(throwable.getSuppressed()).findFirst().get().toString());
        System.out.println("\n\n\nSTACK_TRACE"); throwable.printStackTrace();
        System.out.println("END\n\n\n");

    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("\n\nTEST METHOD: " +context.getTestInstanceLifecycle().get() + " END\n");
    }
}
