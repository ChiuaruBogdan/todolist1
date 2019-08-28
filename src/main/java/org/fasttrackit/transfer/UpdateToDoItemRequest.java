package org.fasttrackit.transfer;

public class UpdateToDoItemRequest {

    private boolean done;
    //in the future we can update other properties as well if we need to
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "UpdateToDoItemRequest{" +
                "done=" + done +
                '}';
    }
}
