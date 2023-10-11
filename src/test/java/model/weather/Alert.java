package model.weather;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import org.openqa.selenium.devtools.v85.layertree.model.Layer;

import java.util.List;

public class Alert {
    @JsonProperty("sender_name")
    private String senderName;

    private String event;
    private long start;
    private long end;
    private String description;
    private List<Tag> tags;
}
